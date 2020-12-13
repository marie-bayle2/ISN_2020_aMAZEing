package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Labyrinthe {
	
	private int labyrinthe[][];
	private int width;
	private int height;
	
	public Labyrinthe(String nomFichier) throws IOException{

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
	}
	
	public int[][] getlabyrinthe() {
		return this.labyrinthe;
	}
	
	/**
	 * verifier si la position est accessible
	 */
	public boolean isFree(int y, int x) {
		//taille du labyrinthe lxh
		if (x < 0 || y < 0 || x >= this.width || y >= this.height) return false; //hors du plateau
		if (this.labyrinthe[x][y] == 1) return false; //La case est un mur
		return true; //la case est libre

	}

}
