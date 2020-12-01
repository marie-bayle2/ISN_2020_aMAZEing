package engine;

import java.util.*;

public class Monstre {
	
	public void placer() {
		int t = 17*17; //Taille du labyrinthe
		int r = (int) (Math.random()*t);
		int x = r/10;
		int y = r%10;
		while(PacmanGame.PacmanGame.isFree(x,y)==false) {
			r = (int) (Math.random()*t);
			x = r/17;
			y = r%17;
		}
		
	}

	public void bouger(int x, int y) {
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
}
	
	

