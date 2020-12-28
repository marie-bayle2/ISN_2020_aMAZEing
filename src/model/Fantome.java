package model;

import java.util.ArrayList;

public class Fantome {
	private int x;
	private int y; 
	
	//constructeur
	public Fantome() {
	}
	
	public static int c;
	
	public void bouger(Labyrinthe labyrinthe){

		if(this.x == 1){
			c=1;
			this.x = this.x + 1;
		}
		else if(this.x == labyrinthe.height-1) {
			c=0;
			this.x = this.x - 1;

		}
		else {
			if(c==1) {
				this.x = this.x + 1;}
			else {
				this.x = this.x - 1;
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
		return "Le fantome est aux coordonnees (" + this.x + ", " + this.y + ")."; 
	}
}