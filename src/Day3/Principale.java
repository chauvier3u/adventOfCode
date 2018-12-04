package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principale
{

	public static void main(String[] args) throws FileNotFoundException
	{
		// partOne();
		partTwo();
	}

	public static void partOne() throws FileNotFoundException
	{
		File fichier = new File("./src/Day3/data.txt");
		Scanner sc = new Scanner(fichier);
		String ligne = "";
		String[] commande;

		String[] XY1;
		String[] XY2;

		int x1;
		int x2;
		int y1;
		int y2;

		int[][] grille = new int[1000][1000];
		for (int i = 0; i < 1000; i++)
		{
			for (int j = 0; j < 1000; j++)
			{
				grille[i][j] = 0;
			}
		}

		while (sc.hasNextLine())
		{
			ligne = sc.nextLine();
			commande = ligne.split(" ");

			XY1 = commande[2].split(",");
			XY2 = commande[3].split("x");

			x1 = Integer.parseInt(XY1[0]);
			y1 = Integer.parseInt(XY1[1].substring(0, XY1[1].length() - 1));

			x2 = x1 + Integer.parseInt(XY2[0]);
			y2 = y1 + Integer.parseInt(XY2[1]);

			for (int i = x1; i < x2; i++)
			{
				for (int j = y1; j < y2; j++)
				{
					grille[i][j]++;
				}
			}
		}
		int compteur = 0;
		for (int i = 0; i < 1000; i++)
		{
			for (int j = 0; j < 1000; j++)
			{
				if (grille[i][j] >= 2)
				{
					compteur++;
				}
			}
		}
		System.out.println(compteur);
		sc.close();
	}

	public static void partTwo() throws FileNotFoundException
	{
		File fichier = new File("./src/Day3/data.txt");
		Scanner sc = new Scanner(fichier);
		String ligne = "";
		String[] commande;

		String id;

		String[] XY1;
		String[] XY2;

		int x1;
		int x2;
		int y1;
		int y2;

		String[][] grille = new String[1000][1000];
		for (int i = 0; i < 1000; i++)
		{
			for (int j = 0; j < 1000; j++)
			{
				grille[i][j] = "";
			}
		}

		while (sc.hasNextLine())
		{

			ligne = sc.nextLine();
			commande = ligne.split(" ");

			id = commande[0];
			XY1 = commande[2].split(",");
			XY2 = commande[3].split("x");

			x1 = Integer.parseInt(XY1[0]);
			y1 = Integer.parseInt(XY1[1].substring(0, XY1[1].length() - 1));

			x2 = x1 + Integer.parseInt(XY2[0]);
			y2 = y1 + Integer.parseInt(XY2[1]);

			for (int i = x1; i < x2; i++)
			{
				for (int j = y1; j < y2; j++)
				{
					if (grille[i][j] == "")
					{
						grille[i][j] = id;
					} else
					{
						grille[i][j] = "X";
					}
				}
			}
		}
		sc.close();
		sc = new Scanner(fichier);
		boolean seul;
		while (sc.hasNextLine())
		{
			seul = true;
			ligne = sc.nextLine();
			commande = ligne.split(" ");

			id = commande[0];
			XY1 = commande[2].split(",");
			XY2 = commande[3].split("x");

			x1 = Integer.parseInt(XY1[0]);
			y1 = Integer.parseInt(XY1[1].substring(0, XY1[1].length() - 1));

			x2 = x1 + Integer.parseInt(XY2[0]);
			y2 = y1 + Integer.parseInt(XY2[1]);

			for (int i = x1; i < x2; i++)
			{
				for (int j = y1; j < y2; j++)
				{
					if (grille[i][j] == "X")
					{
						seul = false;
					}
				}
			}
			if (seul)
			{
				System.out.println(id);
			}
		}

		sc.close();
	}
}
