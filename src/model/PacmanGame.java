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
	
	private Hero hero;
	private Monstre monstre;
	private Labyrinthe labyrinthe;
	private int width;
	private int height;

	/**
	 * constructeur avec fichier source pour le help
	 * 
	 */
	public PacmanGame(String source) throws IOException{
		//creation de labyrinthe
		this.labyrinthe = new Labyrinthe("src/labyrinthe.txt");
		//creation du hero
		this.hero = new Hero();
		//creation du monstre
		this.monstre = new Monstre(this.labyrinthe, this.hero);
		
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 *
	 * @param labyrinthe
	 */
	public void evolve(Cmd commande) {
		this.hero.action(this.labyrinthe, commande);
		//this.monstre.bouger(this.monstre.ouBouger(labyrinthe, this.hero));
		System.out.println("Execute "+commande);
		

	}

	public Monstre evolveM() {
		Cmd c = this.monstre.ouBouger(this.labyrinthe, this.hero);
		this.monstre.bouger(c);
		return this.monstre;
	}

	/**
	 * verifier si le jeu est fini
	 */

	public boolean isFinished() {
		//le héro trouve le trésor
		if (this.labyrinthe.getlabyrinthe()[this.hero.gety()][this.hero.getx()] == this.labyrinthe.TRESOR) {
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

	//getter
	public Hero getHero() {
		return this.hero;
	}

	public Monstre getMonstre() {
		return this.monstre;
	}

	public Labyrinthe getLabyrinthe() {
		return this.labyrinthe;
	}
	

}
