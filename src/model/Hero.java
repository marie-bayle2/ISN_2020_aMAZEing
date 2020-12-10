package model;

import engine.Cmd;

public class Hero {
	
	private int x;
	private int y;
	
	public Hero() {
		this.x = 1;
		this.y = 1;
	}
	
	public Hero(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	
	//Fait faire une action au héro (pour l'instant le fait juste bouger)
	public void action(Labyrinthe labyrinthe, Cmd commande) {
		if (commande == Cmd.LEFT) {
			if (labyrinthe.isFree(this.x-1, this.y)) this.x = this.x - 1;	
			
		} 
		if (commande == Cmd.RIGHT) {
			this.x = this.x + 1;
			
		}
		if (commande == Cmd.UP) {
			this.y = this.y - 1;
			
		}
		if (commande == Cmd.DOWN) {
			this.y = this.y + 1;
			
		}
		if (commande == Cmd.IDLE) {}	
	}

	//getter
	public int getx(){
		return this.x;
	}

	public int gety(){
		return this.y;
	}

	//toString
	public String toString() {
		return "Le hero est aux coordonnees (" + this.x + ", " + this.y + ")."; 
	}

}
