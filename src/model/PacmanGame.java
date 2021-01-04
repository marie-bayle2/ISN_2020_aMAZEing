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
	private Fantome fantome;
	private boolean victoire;

	/**
	 * constructeur avec fichier source pour le help
	 * 
	 */
	public PacmanGame(String source) throws IOException{
		//creation de labyrinthe
		this.labyrinthe = new Labyrinthe(source);
		//creation du hero
		this.hero = new Hero();
		//creation du monstre
		this.monstre = new Monstre(this.labyrinthe, this.hero);
		//creation du fantome
		this.fantome = new Fantome(this.labyrinthe);
		
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 *
	 * @param labyrinthe
	 */
	public void evolve(Cmd commande, int compteur, Tire tire) {
		//hero
		//si la commande commence par T alors c'est pour tirer
		this.hero.action(this.labyrinthe, commande);
		System.out.println("Execute "+commande);

		//le monstre bouge un tic sur trois
		if (compteur%3 == 0) this.monstre.bouger(this.monstre.ouBouger(this.labyrinthe, this.hero));

		//le fantome bouge un tic sur deux
		if (compteur%2 == 0) this.fantome.bouger(this.labyrinthe);

		//on regarde si le hero tue le monstre
		if (tire != null){
			if (tire.getToucheMonstre()) {
				this.monstre.setEstActif(false);
				this.monstre.setx(0);
				this.monstre.sety(0);
			}
		}
	}



	/**
	 * verifier si le jeu est fini
	 */

	public boolean isFinished() {
		//le héro trouve le trésor
		if (this.labyrinthe.getlabyrinthe()[this.hero.gety()][this.hero.getx()] == this.labyrinthe.TRESOR) {
			System.out.println("Le hero gagne la partie en trouvant le tresor !");
			victoire = true;
			return true;
		}

		//le monstre touche le héro
		else if (this.hero.getx() == this.monstre.getx() && this.hero.gety() == this.monstre.gety() && this.hero.getShield() == false) {
			this.hero.setVie(this.hero.getVie() - 1); //le hero perd un pt de vie
			if (this.hero.getVie() == 0) {
				System.out.println("Le hero s'est fait manger par le monstre ! Il a perdu !");
				victoire = false;
				return true;		
			}
		}

		//le fantome touche le hero
		else if (this.hero.getx() == this.fantome.getx() && this.hero.gety() == this.fantome.gety() && this.hero.getShield() == false) {
			this.hero.setVie(this.hero.getVie() - 1); //le hero perd un pt de vie
			if (this.hero.getVie() == 0) {
				System.out.println("Le hero s'est fait manger par le Fantome ! Il a perdu !");
				victoire = false;
				return true;		
			}
		}

		//le hero marche sur un piege1
		else if (this.labyrinthe.getlabyrinthe()[this.hero.gety()][this.hero.getx()] == this.labyrinthe.PIEGE1 && this.hero.getShield() == false){
			this.hero.setVie(this.hero.getVie() - 1); //le hero perd un pt de vie
			if (this.hero.getVie() == 0) {
				System.out.println("Le hero est tombe dans un piege ! Il a perdu !");
				victoire = false;
				return true;		
			}
		}

		//le hero marche sur un piege2
		else if (this.labyrinthe.getlabyrinthe()[this.hero.gety()][this.hero.getx()] == this.labyrinthe.PIEGE2 && this.hero.getShield() == false){
			this.hero.setVie(this.hero.getVie() - 1); //le hero perd un pt de vie
			if (this.hero.getVie() == 0) {
				System.out.println("Le hero est tombe dans un piege ! Il a perdu !");
				victoire = false;
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

	public Fantome getFantome() {
		return this.fantome;
	}
	

}
