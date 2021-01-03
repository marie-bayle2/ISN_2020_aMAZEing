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
	protected static final int WIDTH = 840;
	protected static final int HEIGHT = 440+40;


	public PacmanPainter() {
	}

	/**
	 * methode  redefinie de Afficheur retourne une image du jeu
	 */
	public void draw(BufferedImage im, Hero hero, Monstre monstre, Labyrinthe l, Fantome fantome) {
		Graphics2D crayon = (Graphics2D) im.getGraphics();
		//dessin du labyrinthe
  		int dx = 20;
  		int dy = 20;
  		try {
  			Image img_mur = ImageIO.read(new File("src/mur.png"));
  			Image img_tresor = ImageIO.read(new File("src/piece.png"));
  			Image img_sol = ImageIO.read(new File("src/mur_blanc.png"));
  			Image img_piege1 = ImageIO.read(new File("src/eau.png"));
  			Image img_piege2 = ImageIO.read(new File("src/boue.png"));
			for (int i = 0; i < l.getlabyrinthe().length; i++) {
				for (int j = 0; j < l.getlabyrinthe()[0].length; j++) {
					if (l.getlabyrinthe()[i][j] == l.MUR) { //mur
						crayon.drawImage(img_mur, dx*j, dy*i, dx, dy, null);
						
					}		
					else if (l.getlabyrinthe()[i][j] == l.TRESOR) { //tresor
						crayon.drawImage(img_tresor, dx*j, dy*i, dx, dy, null);
						
					}
					else if (l.getlabyrinthe()[i][j] == l.PIEGE1) { //piege 1
						crayon.drawImage(img_piege1, dx*j, dy*i, dx, dy, null);
					}
					else if (l.getlabyrinthe()[i][j] == l.PIEGE2) { //piege 2
						crayon.drawImage(img_piege2, dx*j, dy*i, dx, dy, null);
					}
					else {
						crayon.drawImage(img_sol, dx*j, dy*i, dx, dy, null);
					}
				}
			}
		} catch (IOException e) {
			System.out.println("Error.");
		}

		//dessin du héro
		int x = hero.getx();
		int y = hero.gety();
		try {
			Image img = ImageIO.read(new File("src/smiley.png"));
			crayon.drawImage(img, x*dx,y*dy,dx,dy, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//dessin du monstre
		try {
			Image img = ImageIO.read(new File("src/monstre2.png"));
			crayon.drawImage(img, monstre.getx()*dx,monstre.gety()*dy,dx,dy, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//dessin du fantome
		try {
			Image img = ImageIO.read(new File("src/fantome.png"));
			crayon.drawImage(img, fantome.getx()*dx, fantome.gety()*dy,dx,dy, null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//vie du héro
		if (hero.getVie() == 3) {
			try {
				Image img = ImageIO.read(new File("src/coeur.jpg"));
				crayon.drawImage(img, 15*dx, this.HEIGHT - 40, 40, 40, null);
				crayon.drawImage(img, 19*dx, this.HEIGHT - 40, 40, 40, null);
				crayon.drawImage(img, 23*dx, this.HEIGHT - 40, 40, 40, null);
			} catch (IOException e) {
				e.printStackTrace();
			} 

		}
		else if (hero.getVie() == 2) {
			try {
				Image img1 = ImageIO.read(new File("src/coeur.jpg"));
				Image img2 = ImageIO.read(new File("src/coeur_vide.jpg"));
				crayon.drawImage(img1, 15*dx, this.HEIGHT - 40, 40, 40, null);
				crayon.drawImage(img1, 19*dx, this.HEIGHT - 40, 40, 40, null);
				crayon.drawImage(img2, 23*dx, this.HEIGHT - 40, 40, 40, null);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		else if (hero.getVie() == 1) {
			try {
				Image img1 = ImageIO.read(new File("src/coeur.jpg"));
				Image img2 = ImageIO.read(new File("src/coeur_vide.jpg"));
				crayon.drawImage(img1, 15*dx, this.HEIGHT - 40, 40, 40, null);
				crayon.drawImage(img2, 19*dx, this.HEIGHT - 40, 40, 40, null);
				crayon.drawImage(img2, 23*dx, this.HEIGHT - 40, 40, 40, null);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		else {
			try {
				Image img = ImageIO.read(new File("src/coeur_vide.jpg"));
				crayon.drawImage(img, 15*dx, this.HEIGHT - 40, 40, 40, null);
				crayon.drawImage(img, 19*dx, this.HEIGHT - 40, 40, 40, null);
				crayon.drawImage(img, 23*dx, this.HEIGHT - 40, 40, 40, null);
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
