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
		// creation de l'interface graphique
		this.gui = new GraphicalInterface(this.painter,this.controller);

		// boucle de game
		int compteur = 0;
		while (!this.game.isFinished()) {
			// demande controle utilisateur
			Cmd c = this.controller.getCommand();
			// fait evoluer le game
			this.game.evolve(c);

			//evoluer monstre
			//on le fait evoluer une fois sur deux pour qu'il ai une vitesse raisonable
			if (compteur%3 == 0) this.game.evolveM();
			// affiche le game
			this.gui.paint(this.game.getHero(), this.game.getMonstre(), this.game.getLabyrinthe());
			// met en attente
			Thread.sleep(100);
			//incremente le comtpeur
			compteur++;
		}
		//affiche une derniere fois l'image (pour avoir les 3 coeurs vides)
		this.gui.paint(this.game.getHero(), this.game.getMonstre(), this.game.getLabyrinthe());
	}

}
