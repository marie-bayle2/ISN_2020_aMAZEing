package engine;

import java.io.IOException;

import model.Hero;
import model.Labyrinthe;
import model.Monstre;
import model.PacmanController;
import model.PacmanGame;
import model.PacmanPainter;

/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * moteur de game generique.
 * On lui passe un game et un afficheur et il permet d'executer un game.
 */
public class GameEngineGraphical {
	
	private Hero hero;
	private Monstre monstre;
	private Labyrinthe labyrinthe;

	/**
	 * le game a executer
	 */
	private PacmanGame game;

	/**
	 * l'afficheur a utiliser pour le rendu
	 */
	private PacmanPainter painter;

	/**
	 * le controlleur a utiliser pour recuperer les commandes
	 */
	private PacmanController controller;

	/**
	 * l'interface graphique
	 */
	private GraphicalInterface gui;

	/**
	 * construit un moteur
	 * 
	 * @param game
	 *            game a lancer
	 * @param painter
	 *            afficheur a utiliser
	 * @param controller
	 *            controlleur a utiliser
	 *            
	 */
	public GameEngineGraphical(PacmanGame game, PacmanPainter painter, PacmanController controller) {
		// creation du game
		this.game = game;
		this.painter = painter;
		this.controller = controller;
	}

	/**
	 * permet de lancer le game
	 * @throws IOException
	 */
	public void run() throws InterruptedException, IOException {
		// creation du labyrinthe
		labyrinthe = new Labyrinthe("src/labyrinthe.txt");

		// creation de l'interface graphique
		this.gui = new GraphicalInterface(this.painter,this.controller);

		// boucle de game
		int compteur = 0;
		while (!this.game.isFinished(labyrinthe)) {
			// demande controle utilisateur
			Cmd c = this.controller.getCommand();
			// fait evoluer le game
			hero = this.game.evolve(labyrinthe,c);
			//evoluer monstre
			//on place le monstre de maniere random au debut
			if (compteur == 0) monstre = this.game.placeMonstre(hero, labyrinthe);
			//on le fait evoluer une fois sur deux pour qu'il ai une vitesse raisonable
			else if (compteur%2 == 0) monstre = this.game.evolveM(labyrinthe, hero);
			// affiche le game
			this.gui.paint(hero, monstre, labyrinthe);
			// met en attente
			Thread.sleep(100);
			//incremente le comtpeur
			compteur++;
		}
		//affiche une derniere fois l'image (pour avoir les 3 coeurs vides)
		this.gui.paint(hero, monstre, labyrinthe);
	}

}
