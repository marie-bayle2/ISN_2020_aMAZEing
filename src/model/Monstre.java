package model;

import java.util.ArrayList;

import engine.Cmd;

public class Monstre {
	private int x;
	private int y; 
	
	//constructeur
	public Monstre() {}
	
	
	public Cmd OuBouger(Labyrinthe labyrinthe, Hero hero) {
		
		Cmd commandeDuMonstre;
		
		ArrayList<Cmd> cmdPossible = new ArrayList<Cmd>();
		if(hero.getx()<this.x) { // Le h�ro est en haut du monstre
			if(labyrinthe.isFree(this.x-1,this.y)) cmdPossible.add(Cmd.UP); //test aller en haut si le h�ro est vers le haut
			else if(hero.gety()<this.y) { //Si le h�ro est sur la gauche
				if(labyrinthe.isFree(this.x,this.y-1)) cmdPossible.add(Cmd.LEFT);//test aller � gauche si le h�ro est vers la gauche
				else {
					if (labyrinthe.isFree(this.x,this.y+1)) cmdPossible.add(Cmd.RIGHT); //teste aller à droite
					if (labyrinthe.isFree(this.x+1,this.y)) cmdPossible.add(Cmd.DOWN); //teste aller en bas
				}
			}
			else if(hero.gety()>this.y) { //Si le h�ro est sur la droite
				if(labyrinthe.isFree(this.x,this.y+1)) cmdPossible.add(Cmd.RIGHT);//test aller � gauche si le h�ro est vers la gauche
				else {
					if (labyrinthe.isFree(this.x+1,this.y)) cmdPossible.add(Cmd.DOWN); //teste aller en bas
					if (labyrinthe.isFree(this.x,this.y-1)) cmdPossible.add(Cmd.LEFT); //teste aller à gauche
				}
					 
			}
		}
		else if(hero.getx()>this.x){ //Si le h�ro est en bas du monstre
			if(labyrinthe.isFree(this.x+1,this.y)) cmdPossible.add(Cmd.DOWN); //test aller en bas si le h�ro est vers le bas
			else if(hero.gety()<this.y) { //Si le h�ro est sur la gauche
				if(labyrinthe.isFree(this.x,this.y-1)) cmdPossible.add(Cmd.LEFT);//test aller � gauche si le h�ro est vers la gauche
				else {
					if (labyrinthe.isFree(this.x,this.y+1)) cmdPossible.add(Cmd.RIGHT); //teste aller à droite
					if (labyrinthe.isFree(this.x-1,this.y)) cmdPossible.add(Cmd.UP); //teste aller en haut
				}
			}
			
			else if(hero.gety()>this.y) { //Si le h�ro est sur la droite
				if(labyrinthe.isFree(this.x,this.y+1)) cmdPossible.add(Cmd.RIGHT);//test aller � droite si le h�ro est vers la droite
				else {
					if (labyrinthe.isFree(this.x-1,this.y)) cmdPossible.add(Cmd.UP); //teste aller en haut
					if (labyrinthe.isFree(this.x,this.y-1)) cmdPossible.add(Cmd.LEFT); //teste aller à gauche
				}
			}
		}
		else { // Si ils sont sur la m�me ligne
			if (hero.gety()<this.y) { //Si le h�ro est sur la gauche
				if(labyrinthe.isFree(this.x,this.y-1)) cmdPossible.add(Cmd.LEFT);//test aller � gauche si le h�ro est vers la gauche
				else {
					if (labyrinthe.isFree(this.x-1,this.y)) cmdPossible.add(Cmd.UP); //teste aller en haut
					if (labyrinthe.isFree(this.x+1,this.y)) cmdPossible.add(Cmd.DOWN); //test aller en bas 
				}
			}
			else if (hero.gety()>this.y) { //Si le h�ro est sur la droite
				if(labyrinthe.isFree(this.x,this.y+1)) cmdPossible.add(Cmd.RIGHT);//test aller � droite si le h�ro est vers la droite
				else {
					if (labyrinthe.isFree(this.x-1,this.y)) cmdPossible.add(Cmd.UP); //teste aller en haut
					if (labyrinthe.isFree(this.x+1,this.y)) cmdPossible.add(Cmd.DOWN); //test aller en bas 
				}
			}
		}
		
		return commandeDuMonstre = cmdPossible.get((int)(Math.random()*cmdPossible.size()));
	}

	//Fais bouger le monstre
	public void bouger(Cmd commande) {
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
	
	

