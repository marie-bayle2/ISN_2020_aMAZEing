package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import engine.Cmd;
import engine.Game;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 *         Version avec personnage qui peut se deplacer. A completer dans les
 *         versions suivantes.
 * 
 */
public class PacmanGame implements Game {
	public Hero hero;
	public Monstre monstre;
	private int labyrinthe[][];
	private int width;
	private int height;

	/**
	 * constructeur avec fichier nomFichier pour le labyrinthe
	 * 
	 */
	public PacmanGame(String nomFichier) throws IOException{

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

		//création d'un héro au coord (0,0)
		hero = new Hero();

		//création d'un monstre
		monstre = new Monstre();
		//on le place aléatoirement
		do {
			this.monstre.setx((int)(1 + Math.random()*this.width)); //entre 1 et width-1
			this.monstre.sety((int)(1 + Math.random()*this.height)); //entre 1 et height-1
		} while(this.isFree(this.monstre.getx(), this.monstre.gety()) == false || (this.monstre.getx() == this.hero.getx() && this.monstre.getx() == this.hero.getx())); //on s'assure de ne pas être sur un mur ou sur le héro
	}

	/**
	 * faire evoluer le jeu suite a une commande
	 * 
	 * @param commande
	 */
	@Override
	public void evolve(Cmd commande) {
		System.out.println("Execute "+commande);
	}

	/**
	 * verifier si le jeu est fini
	 */
	@Override
	public boolean isFinished() {
		//le héro trouve le trésor
		if (this.labyrinthe[this.hero.getx()][this.hero.gety()] == 2) {
			System.out.println("Le hero gagne la partie en trouvant le tresor !");
			return true;
		}

		//le monstre tue le héro
		else if (this.hero.getx() == this.monstre.getx() && this.hero.gety() == this.monstre.gety()) {
			System.out.println("Le hero a perdu. Il s'est fait manger par le monstre.");
			return true;
		}

		//sinon la game continue
		return false;
	}

	/**
	 * verifier si la position est accessible
	 */
	@Override
	public boolean isFree(int x, int y) {
		//taille du labyrinthe lxh
		if (x < 0 || y < 0 || x >= this.width || y >= this.height) return false; //hors du plateau
		if (this.labyrinthe[x][y] == 1) return false; //La case est un mur
		return true; //la case est libre

	}

	//affiche le labyrinthe avec le héro et le monstre
	public String toString() {
		String txt = "";
		for (int i = 0; i < this.labyrinthe.length; i++) {
			String line = "";
			for (int j = 0; j < this.labyrinthe[i].length; j++) {
				if (this.hero.getx() == i && this.hero.gety() == j) line += "H";
				else if (this.monstre.getx() == i && this.monstre.gety() == j) line += "M";
				else if (this.labyrinthe[i][j] == 0) line += " ";
				else line = line + this.labyrinthe[i][j];
			}
			txt += line;
			txt += "\n";
		}
		return txt;
	}

	//getter
	public Hero getHero() {
		return this.hero;
	}

	public Monstre getMonstre() {
		return this.monstre;
	}

}
