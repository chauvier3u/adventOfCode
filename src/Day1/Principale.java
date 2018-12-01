package Day1;

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
		File fichier = new File("./src/Day1/data.txt");
		Scanner sc = new Scanner(fichier);
		String ligne = "";

		int frequence = 0;
		int tmpFrequence = 0;

		while (sc.hasNextLine())
		{
			ligne = sc.nextLine();
			tmpFrequence = Integer.parseInt(ligne);
			frequence += tmpFrequence;
		}
		sc.close();

		System.out.println(frequence);
	}

	public static void partTwo() throws FileNotFoundException
	{
		File fichier = new File("./src/Day1/data.txt");
		Scanner sc = new Scanner(fichier);
		String ligne = "";

		int frequence = 0;
		int tmpFrequence = 0;
		int nbBoucle = 0;
		ArrayList<Integer> frequenceUnique = new ArrayList<Integer>();
		frequenceUnique.add(0);

		boolean continuer = true;

		while (continuer)
		{
			if (!sc.hasNextLine())
			{
				sc.close();
				sc = new Scanner(fichier);
				nbBoucle++;
			}
			ligne = sc.nextLine();
			tmpFrequence = Integer.parseInt(ligne);
			frequence += tmpFrequence;
			frequenceUnique.add(frequence);
			for (int i = 0; i < frequenceUnique.size() - 1; i++)
			{
				if (frequence == frequenceUnique.get(i))
				{
					continuer = false;
				}
			}

		}
		sc.close();

		System.out.println(frequence);
		System.out.println("avec " + nbBoucle + " boucles");
	}
}