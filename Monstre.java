package engine;

import java.util.*;

public class Monstre {
	
	public void placer(byte[][] M) {
		int t = 17*17; //Taille du labyrinthe
		int r = (int) (Math.random()*t);
		int x = r/10;
		int y = r%10;
		while(M[x][y]!=0) {
			r = (int) (Math.random()*t);
			x = r/17;
			y = r%17;
		}
		
	}

	public void bouger(byte[][] M, int x, int y) {
		int b;
		int h;
		int d;
		int g;

		ArrayList<Integer> L = new ArrayList<Integer>();
		if(isFree(x,y-1)) { // Est ce qu'on peut aller en bas ?
			L.add(b);}
		if(isFree(x,y+1)) { //Est ce qu'on peut aller en haut ?
			L.add(h);}
		if(isFree(x+1,y)) { // Est ce qu'on peut aller a droite ?
			L.add(d);}
		if(isFree(x-1,y)) { //Est ce qu'on peut aller à gauche ?
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
	
	

