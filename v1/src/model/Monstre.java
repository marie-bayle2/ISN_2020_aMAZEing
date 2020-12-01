package engine;
import model.PacmanGame;

import java.util.*;

public class Monstre {
	private int x;
	private int y; 
	
	//place un monstre de manière aléatoire sur le labyrinthe de largeur l
	//et de hauteur h
	public Monstre(int l, int h) {
		do {
			this.x = (int)(1 + Math.random()*l); //entre 1 et l-1
			this.y = (int)(1 + Math.random()*h); //entre 1 et l-1
		} while(PacmanGame.isFree(this.x, this.y) == false);
	}

	//Fais bouger aléatoiremet le monstre
	public void bouger() {
		int b;
		int h;
		int d;
		int g;

		ArrayList<Integer> L = new ArrayList<Integer>();
		if(PacmanGame.isFree(x,y-1)) { // Est ce qu'on peut aller en bas ?
			L.add(b);}
		if(PacmanGame.isFree(x,y+1)) { //Est ce qu'on peut aller en haut ?
			L.add(h);}
		if(PacmanGame.isFree(x+1,y)) { // Est ce qu'on peut aller a droite ?
			L.add(d);}
		if(PacmanGame.isFree(x-1,y)) { //Est ce qu'on peut aller à gauche ?
			L.add(g);}
		
		int l=L.size();
		int r = (int) (Math.random() * l);
		if(L.get(r)==b) {
			y=y+1;}
		else if(L.get(r)==h) {
			y=y-1;}
		else if(L.get(r)==d) {
			x=x+1;}
		else{
			x=x-1;}
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
}
	
	

