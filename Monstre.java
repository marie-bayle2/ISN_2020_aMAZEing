package engine;

import java.util.*;

public class Monstre {

	public ArrayList<Integer> bouger(int[][] M, int x, int y) {
		int b;
		int h;
		int d;
		int g;
		if(M[x+1][y]!=1) {
			b = 1;}
		else {
			b = 0;}
		if(M[x-1][y]!=1) {
			h = 1;}
		else {
			h = 0;}
		if(M[x][y+1]!=1) {
			d = 1;}
		else {
			d = 0;}
		if(M[x][y-1]!=1) {
			g = 1;}
		else {
			g = 0;}
		ArrayList<Integer> L = new ArrayList<Integer>();
		if(b!=0) {L.add(b);}
		if(h!=0) {L.add(h);}
		if(d!=0) {L.add(d);}
		if(g!=0) {L.add(g);}
		
		int l;
		l=L.size();
		ArrayList<Integer> position = new ArrayList<Integer>();
		int r = (int) (Math.random() * l);
		if(L.get(r)==b) {
			position.add(x+1);
			position.add(y);}
		else if(L.get(r)==h) {
			position.add(x-1);
			position.add(y);}
		else if(L.get(r)==d) {
			position.add(x);
			position.add(y+1);}
		else{
			position.add(x);
			position.add(y-1);}
		return position;
			
		}
}
	
	

