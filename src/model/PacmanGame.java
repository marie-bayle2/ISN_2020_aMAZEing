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
		//creation du hero
		hero = new Hero();
		//creation du monstre
		Monstre monstre = new Monstre();
		//lecture du fichier 
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

	
	public Monstre evolveM(Labyrinthe labyrinthe) {
		//this.monstre.bouger(this.monstre.ouBouger(labyrinthe, this.hero));
		return(new Monstre());
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
