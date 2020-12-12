package model;

import engine.Cmd;

public class Monstre {
	private int x;
	private int y; 
	
	//constructeur
	public Monstre() {}
		

	//Fais bouger le monstre
	public void bouger(Labyrinthe labyrinthe, Hero hero) {
		if (commande == Cmd.LEFT) {
			this.y = this.y - 1;
			
		} 
		if (commande == Cmd.RIGHT) {
			this.y = this.y + 1;
			
		}
		if (commande == Cmd.UP) {
			this.x = this.x - 1;
			
		}
		if (commande == Cmd.DOWN) {
			this.x = this.x + 1;
			
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

	//setter
	public void setx(int newx){
		this.x = newx;
	}

	public void sety(int newy){
		this.y = newy;
	}

	//toString
	//toString
	public String toString() {
		return "Le monstre est aux coordonnees (" + this.x + ", " + this.y + ")."; 
	}
}
	
	
