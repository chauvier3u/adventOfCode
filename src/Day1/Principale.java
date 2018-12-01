package Day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Principale
{
	public static void main(String[] args) throws FileNotFoundException
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
}