package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * afficheur graphique pour le game
 * 
 */
public class PacmanPainter {

	/**
	 * la taille des cases
	 */
	protected static final int WIDTH = 170;
	protected static final int HEIGHT = 170;


	public PacmanPainter() {
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	public void draw(BufferedImage im, Hero hero, Monstre monstre, Labyrinthe l) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		//dessin du labyrinthe
  		int dx = this.WIDTH/17;
  		int dy = this.HEIGHT/17;
		for (int i = 0; i < l.getlabyrinthe().length; i++) {
			for (int j = 0; j < l.getlabyrinthe()[0].length; j++) {
				if (l.getlabyrinthe()[i][j] == 1) crayon.setColor(Color.BLACK);			
				else if (l.getlabyrinthe()[i][j] == 2) crayon.setColor(Color.RED);
				else crayon.setColor(Color.GREEN);
				crayon.fillRect(dx*j, dy*i, dx, dy);
			}
		}
		//dessin du héro
		int x = hero.getx();
		int y = hero.gety();
		crayon.setColor(Color.blue);
		crayon.fillOval(x*dx,y*dy,dx,dy);
		//dessin du monstre
		crayon.setColor(Color.PINK);
		crayon.fillOval(monstre.getx()*dx,monstre.gety()*dy,dx,dy);
		
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

}
