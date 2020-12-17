package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;


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
	protected static final int WIDTH = 170*2;
	protected static final int HEIGHT = 200*2;


	public PacmanPainter() {
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	public void draw(BufferedImage im, Hero hero, Monstre monstre, Labyrinthe l) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		//dessin du labyrinthe
  		int dx = this.WIDTH/17;
  		int dy = (this.HEIGHT-20*2)/17;
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

		//vie du héro
		if (hero.getVie() == 3) {
			try {
				Image img = ImageIO.read(new File("src/coeur.jpg"));
				crayon.drawImage(img, 3*dx, this.HEIGHT - 20*2, 20*2, 20*2, null);
				crayon.drawImage(img, 7*dx, this.HEIGHT - 20*2, 20*2, 20*2, null);
				crayon.drawImage(img, 11*dx, this.HEIGHT - 20*2, 20*2, 20*2, null);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		else if (hero.getVie() == 2) {
			try {
				Image img1 = ImageIO.read(new File("src/coeur.jpg"));
				Image img2 = ImageIO.read(new File("src/coeur_vide.jpg"));
				crayon.drawImage(img1, 3*dx, this.HEIGHT - 20*2, 20*2, 20*2, null);
				crayon.drawImage(img1, 7*dx, this.HEIGHT - 20*2, 20*2, 20*2, null);
				crayon.drawImage(img2, 11*dx, this.HEIGHT - 20*2, 20*2, 20*2, null);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		else if (hero.getVie() == 1) {
			try {
				Image img1 = ImageIO.read(new File("src/coeur.jpg"));
				Image img2 = ImageIO.read(new File("src/coeur_vide.jpg"));
				crayon.drawImage(img1, 3*dx, this.HEIGHT - 20*2, 20*2, 20*2, null);
				crayon.drawImage(img2, 7*dx, this.HEIGHT - 20*2, 20*2, 20*2, null);
				crayon.drawImage(img2, 11*dx, this.HEIGHT - 20*2, 20*2, 20*2, null);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		else {
			try {
				Image img = ImageIO.read(new File("src/coeur_vide.jpg"));
				crayon.drawImage(img, 3*dx, this.HEIGHT - 20*2, 20*2, 20*2, null);
				crayon.drawImage(img, 7*dx, this.HEIGHT - 20*2, 20*2, 20*2, null);
				crayon.drawImage(img, 11*dx, this.HEIGHT - 20*2, 20*2, 20*2, null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public int getWidth() {
		return WIDTH;
	}

	public int getHeight() {
		return HEIGHT;
	}

}
