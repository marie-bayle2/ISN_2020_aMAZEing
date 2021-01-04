package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labyrinthe {
	
	private int labyrinthe[][];
	private int width;
	private int height;
	public static final int MUR = 1;
	public static final int TRESOR = 2;
	public static final int PIEGE1 = 3;
	public static final int PIEGE2 = 4;

	
	public Labyrinthe(String nomFichier) throws IOException{

		//ouvre un fichier txt contenant le labyrinthe et rentre les valeurs dans un tableau à deux dimensions
		//tel que tableau[i][j] est le nombre sur la i-eme ligne et j-ème colonne
		BufferedReader in = new BufferedReader(new FileReader(nomFichier));
		String line;
		this.width = 42;
		this.height = 22;
		this.labyrinthe = new int[this.height][this.width];
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
	}
	
	public int[][] getlabyrinthe() {
		return this.labyrinthe;
	}
	

	public int getHeight(){
		return this.height;
	}

	public int getWidth(){
		return this.width;
	}
	
	/**
	 * verifier si la position est accessible
	 */
	public boolean isFree(int y, int x) {
		if (x < 0 || y < 0 || x >= this.height || y >= this.width) return false; //hors du plateau
		if (this.labyrinthe[x][y] == this.MUR) return false; //La case est un mur
		return true; //la case est libre

	}

	//affiche le labyrinthe en mode txt
	public String toString() {
		String txt = "";
		for (int i = 0; i < this.labyrinthe.length; i++) {
			String line = "";
			for (int j = 0; j < this.labyrinthe[i].length; j++) {
				if (this.labyrinthe[i][j] == 0) line += " ";
				else line = line + this.labyrinthe[i][j];
			}
			txt += line;
			txt += "\n";
		}
		return txt;
	}



}
