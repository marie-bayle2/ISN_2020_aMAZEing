package model;

import java.util.ArrayList;

public class Fantome {
	private int x;
	private int y;
	private boolean estActif;
	private static int c;
	
	//constructeur
	public Fantome(Labyrinthe labyrinthe) {
		this.estActif = true;
		//il commence en haut on en bas
		if ((int)(Math.random()*2) == 0) this.y = 1;
		else this.y = labyrinthe.getHeight() - 1;
		//on choisit sa position lateralle
		this.x = (int)(2 + Math.random()*(labyrinthe.getWidth() - 2));

	}
	
	public void bouger(Labyrinthe labyrinthe){

		if(this.y == 1){
			c=1;
			this.y = this.y + 1;
		}
		else if(this.y == labyrinthe.getHeight()-2) {
			c=0;
			this.y = this.y - 1;

		}
		else {
			if(c==1) {
				this.y = this.y + 1;}
			else {
				this.y = this.y - 1;
			}
		}
	}
	//getter
	public int getx(){
		return this.x;
	}

	public int gety(){
		return this.y;
	}

	public boolean getEstActif(){
		return this.estActif;
	}

	//setter
	public void setx(int newx){
		this.x = newx;
	}

	public void sety(int newy){
		this.y = newy;
	}
	
	public void setEstActif(boolean b){
		this.estActif = b;
	}

	public void setc(int nc) {
		this.c = nc;
	}

	//toString
	//toString
	public String toString() {
		return "Le fantome est aux coordonnees (" + this.x + ", " + this.y + ")."; 
	}
}