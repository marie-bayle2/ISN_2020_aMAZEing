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

	/**
	 * appelle constructeur parent
	 * 
	 * @param game
	 *            le jeutest a afficher
	 */
	public PacmanPainter() {
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	public void draw(BufferedImage im, Hero hero) {
		//dessin du labyrinthe
		
		//dessin du héro
		int x = hero.getx();
		int y = hero.gety();
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		crayon.setColor(Color.blue);
		crayon.fillOval(x*10,y*10,10,10);
		//dessin du monstre
		
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

}
