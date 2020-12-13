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
	//private int labyrinthe[][];
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
		monstre = new Monstre();
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
	 *
	 * @param labyrinthe
	 */
	public Hero evolve(Labyrinthe labyrinthe, Cmd commande) {
		this.hero.action(labyrinthe, commande);
		//this.monstre.bouger(this.monstre.ouBouger(labyrinthe, this.hero));
		System.out.println("Execute "+commande);
		return this.hero;

	}

	//place le monstre aléatoirement sur le labyrinthe
	public Monstre placeMonstre(Hero hero, Labyrinthe l) {
		do {
			this.monstre.setx((int)(1 + Math.random()*17)); //entre 1 et width-1
			this.monstre.sety((int)(1 + Math.random()*17)); //entre 1 et height-1
		} while(l.isFree(this.monstre.getx(), this.monstre.gety()) == false || Math.abs(this.monstre.getx() - hero.getx()) < 2 || Math.abs(this.monstre.gety() - hero.gety()) < 2); //on s'assure de ne pas être sur un mur ou a moins de deux blocks du hero
		return this.monstre;
	}

	public Monstre evolveM(Labyrinthe labyrinthe, Hero hero) {
		Cmd c = this.monstre.ouBouger(labyrinthe, hero);
		this.monstre.bouger(c);
		return this.monstre;
	}



	/**
	 * verifier si le jeu est fini
	 */

	public boolean isFinished(Labyrinthe l) {
		//le héro trouve le trésor
		if (l.getlabyrinthe()[this.hero.gety()][this.hero.getx()] == 2) {
			System.out.println("Le hero gagne la partie en trouvant le tresor !");
			return true;
		}

		//le monstre tue le héro
		else if (this.hero.getx() == this.monstre.getx() && this.hero.gety() == this.monstre.gety()) {
			this.hero.setVie(this.hero.getVie() - 1); //le hero perd un pt de vie
			if (this.hero.getVie() == 0) {
				System.out.println("Le hero s'est fait manger par le monstre ! Il a perdu !");
				return true;		
			}
		}

		//sinon la game continue
		return false;
	}
	
	

}
