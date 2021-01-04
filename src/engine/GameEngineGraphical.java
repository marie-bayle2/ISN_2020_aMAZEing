package engine;

import java.io.IOException;

import model.Hero;
import model.Labyrinthe;
import model.Monstre;
import model.PacmanController;
import model.PacmanGame;
import model.PacmanPainter;
import model.Fantome;
import model.Tire;

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
		int dureeShield = -1;
		int ancienneVie = this.game.getHero().getVie();
		Tire tire = null;
		while (!this.game.isFinished()) {
			//gestion du bouclier
			if (ancienneVie != this.game.getHero().getVie()){//le hero s'est fait attquer
				ancienneVie = this.game.getHero().getVie();
				dureeShield = 10; //on ajoute une seconde de shield
				this.game.getHero().setShield(true);
			}

			if (dureeShield > 0) dureeShield--;
			else if (dureeShield == 0) {
				this.game.getHero().setShield(false);
				dureeShield = -1;
			}
			// demande controle utilisateur
			Cmd c = this.controller.getCommand();
			if (c.toString().charAt(0) == 'T') { //alors on tire
				tire = new Tire(this.game.getLabyrinthe(), this.game.getMonstre(), c, this.game.getHero().getx(), this.game.getHero().gety());
			}
			// fait evoluer le game
			this.game.evolve(c, compteur, tire);
			// affiche le game
			this.gui.paint(this.game.getHero(), this.game.getMonstre(), this.game.getLabyrinthe(), this.game.getFantome(), tire);
			// met en attente
			Thread.sleep(100);
			//incremente le comtpeur
			compteur++;
			tire = null;

		}
		//affiche une derniere fois l'image (pour avoir les 3 coeurs vides)
		this.gui.paint(this.game.getHero(), this.game.getMonstre(), this.game.getLabyrinthe(), this.game.getFantome(), tire);
	}

}
