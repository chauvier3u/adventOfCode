package Day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Principale
{
	public static void main(String[] args) throws FileNotFoundException
	{
		partOne();
		partTwo();

	}

	public static void partOne() throws FileNotFoundException
	{
		File fichier = new File("./src/Day2/data.txt");
		Scanner sc = new Scanner(fichier);
		String ligne = "";

		int nombreDeux = 0;
		int nombreTrois = 0;

		boolean DeuxTrouve;
		boolean TroisTrouve;

		String MotCourant;
		char LettreCourante;

		int compteur;

		while (sc.hasNextLine())
		{
			MotCourant = "";
			LettreCourante = ' ';
			DeuxTrouve = false;
			TroisTrouve = false;

			ligne = sc.nextLine();
			for (int i = 0; i < ligne.length() - 1; i++)
			{
				compteur = 1;
				LettreCourante = ligne.charAt(i);
				if (MotCourant.indexOf(LettreCourante) == -1)
				{
					MotCourant += LettreCourante;
					for (int j = i + 1; j < ligne.length(); j++)
					{
						if (ligne.charAt(j) == LettreCourante)
						{
							compteur++;
						}
					}
					if (compteur == 2 && !DeuxTrouve)
					{
						DeuxTrouve = true;
						nombreDeux++;
					}
					if (compteur == 3 && !TroisTrouve)
					{
						TroisTrouve = true;
						nombreTrois++;
					}
				}
			}
		}
		System.out.println("nombre de Deux " + nombreDeux);
		System.out.println("nombre de Trois " + nombreTrois);

		System.out.println(nombreDeux * nombreTrois);

		sc.close();
	}

	public static void partTwo() throws FileNotFoundException
	{
		File fichier = new File("./src/Day2/data.txt");
		Scanner sc = new Scanner(fichier);
		ArrayList<String> touteLignes = new ArrayList<String>();

		while (sc.hasNextLine())
		{
			touteLignes.add(sc.nextLine());
		}

		String currentLigne;
		String newLigne;
		int compteur;
		String vraiLigneUne = "-1";
		String vraiLigneDeux = "-1";
		String code = "";

		for (int i = 0; i < touteLignes.size(); i++)
		{
			currentLigne = touteLignes.get(i);
			for (int j = i + 1; j < touteLignes.size(); j++)
			{
				newLigne = touteLignes.get(j);
				compteur = 0;

				for (int k = 0; k < newLigne.length(); k++)
				{
					if (currentLigne.charAt(k) != newLigne.charAt(k))
					{
						compteur++;
					}
				}

				if (compteur == 1)
				{
					vraiLigneUne = currentLigne;
					vraiLigneDeux = newLigne;
					for (int k = 0; k < vraiLigneDeux.length(); k++)
					{
						if (vraiLigneDeux.charAt(k) == vraiLigneUne.charAt(k))
						{
							code += vraiLigneDeux.charAt(k);
						}
					}
				}
			}
		}
		System.out.println(vraiLigneDeux + "\n" + vraiLigneUne + "\n");
		System.out.println(code);
	}
}