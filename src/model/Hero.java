package model;

import engine.Cmd;

public class Hero {
	
	private int x;
	private int y;
	private int vie;
	private boolean shield;
	
	public Hero() {
		this.x = 1;
		this.y = 1;
		this.vie = 3;
		this.shield = false;
	}
	
	public Hero(int x, int y) {
		this.x = x;
		this.y = y;
		this.vie = 3;
		this.shield = false;
	}
	
	
	
	//Fait faire une action au héro (pour l'instant le fait juste bouger)
	public void action(Labyrinthe labyrinthe, Cmd commande) {
		if (commande == Cmd.LEFT) {
			if (labyrinthe.isFree(this.x-1, this.y)) this.x = this.x - 1;	
			
		} 
		if (commande == Cmd.RIGHT) {
			if (labyrinthe.isFree(this.x+1, this.y)) this.x = this.x + 1;
			
		}
		if (commande == Cmd.UP) {
			if (labyrinthe.isFree(this.x, this.y-1)) this.y = this.y - 1;
			
		}
		if (commande == Cmd.DOWN) {
			if (labyrinthe.isFree(this.x, this.y+1)) this.y = this.y + 1;
			
		}
	}

	//getter
	public int getx(){
		return this.x;
	}

	public int gety(){
		return this.y;
	}

	public int getVie(){
		return this.vie;
	}

	public boolean getShield(){
		return this.shield;
	}

	//setter
	public void setVie(int nVie){
		this.vie = nVie;
	}

	public void setShield(boolean nShield){
		this.shield = nShield;
	}

	//toString
	public String toString() {
		return "Le hero est aux coordonnees (" + this.x + ", " + this.y + ")."; 
	}

}
