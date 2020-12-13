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
	 * @param gamePainter
	 *            afficheur a utiliser
	 * @param gameController
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
		while (!this.game.isFinished()) {
			// demande controle utilisateur
			Cmd c = this.controller.getCommand();
			// fait evoluer le game
			hero = this.game.evolve(labyrinthe,c);
			monstre = this.game.evolveM(labyrinthe);
			// affiche le game
			this.gui.paint(hero, monstre, labyrinthe);
			// met en attente
			Thread.sleep(100);
		}
	}

}
