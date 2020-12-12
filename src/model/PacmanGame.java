package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import engine.Cmd;


/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         Version avec personnage qui peut se deplacer. A completer dans les
 *         versions suivantes.
 * 
 */
public class PacmanGame {
	
	public Hero hero;
	public Monstre monstre;
	private int labyrinthe[][];
	private int width;
	private int height;

	/**
	 * constructeur avec fichier source pour le help
	 * 
	 */
	public PacmanGame(String source) {
		hero = new Hero();
		BufferedReader helpReader;
		try {
			helpReader = new BufferedReader(new FileReader(source));
			String ligne;
			while ((ligne = helpReader.readLine()) != null) {
				System.out.println(ligne);
			}
			helpReader.close();
		} catch (IOException e) {
			System.out.println("Help not available");
		}
	}
	
	/**
	 * constructeur avec fichier nomFichier pour le labyrinthe
	 * 
	 */
	public int[][] createLabyrinthe(String nomFichier) throws IOException{

		//ouvre un fichier txt contenant le labyrinthe et rentre les valeurs dans un tableau à deux dimensions
		//tel que tableau[i][j] est le nombre sur la i-ème ligne et j-ème colonne
		BufferedReader in = new BufferedReader(new FileReader(nomFichier));
		String line;
		this.width = 17;
		this.height = 17;
		this.labyrinthe = new int[this.width][this.height];
		int i = 0;
		while ((line = in.readLine()) != null) {
			int j = 0;
			while (j < this.width) {
				this.labyrinthe[i][j] = Character.getNumericValue(line.charAt(j));
				j++;
			}
			i++;
		}
		in.close();
		return labyrinthe;
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */
	public Hero evolve(Labyrinthe labyrinthe, Cmd commande) {
		this.hero.action(labyrinthe, commande);
		//this.monstre.bouger(hero) ?
		System.out.println("Execute "+commande);
		return this.hero;
	}
	
	public Monstre evolveM(Labyrinthe labyrinthe, Hero hero) {
		this.monstre.bouger(this.monstre.OuBouger(labyrinthe, hero));
		
		return this.monstre;
	}

	/**
	 * verifier si le jeu est fini
	 */

	public boolean isFinished() {
//		//le héro trouve le trésor
//		if (this.labyrinthe[this.hero.getx()][this.hero.gety()] == 2) {
//			System.out.println("Le hero gagne la partie en trouvant le tresor !");
//			return true;
//		}
//
//		//le monstre tue le héro
//		else if (this.hero.getx() == this.monstre.getx() && this.hero.gety() == this.monstre.gety()) {
//			System.out.println("Le hero a perdu. Il s'est fait manger par le monstre.");
//			return true;
//		}
//
		//sinon la game continue
		return false;
	}
	
	

}
