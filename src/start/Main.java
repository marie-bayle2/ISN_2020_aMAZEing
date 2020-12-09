package start;

import model.PacmanController;
import model.PacmanGame;
import engine.Cmd;

import java.util.Scanner;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;

/**
 * lancement du moteur avec le jeu
 */
public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		// creation du jeu particulier
		PacmanGame game = new PacmanGame("src/labyrinthe.txt");
		// creation du controller
		PacmanController controller = new PacmanController();
		// creation du controller du monstre
		PacmanController controllerMonstre = new PacmanController();

		//boucle
		while (!game.isFinished()){
			System.out.println(game.hero.toString()); //on affiche la position du h√©ro
			System.out.println(game.monstre.toString()); //on affiche la position du monstre

			//on affiche le jeu
			System.out.println(game.toString());

			//on choisi une commande
			System.out.println("Ecrire commande (L/R/U/D/S)");
			String entry = sc.nextLine(); //on lit la r√©ponse
			//on regarde √† quoi elle correspond
			switch (entry) {
				case "L":
				case "l":
					controller.setCommand(Cmd.LEFT);
					break;
				case "R":
				case "r":
					controller.setCommand(Cmd.RIGHT);
					break;
				case "U":
				case "u":
					controller.setCommand(Cmd.UP);
					break;
				case "D":
				case "d":
					controller.setCommand(Cmd.DOWN);
					break;
				case "S":
				case "s":
					controller.setCommand(Cmd.IDLE);
					break;
				default: //l'utilisateur n'a pas entr√© une commande connue, donc on va "saut√© ce tour"
					System.out.println("Commande inconnue!");
					continue;
			}

			//on regarde si h√©ro peut bouger tel que la commande le demande
			//si ce n'est pas le cas la commande devient IDLE
			switch (controller.getCommand()) {
				case LEFT:
					if (!game.isFree(game.hero.getx(), game.hero.gety()-1)) controller.setCommand(Cmd.IDLE);
					break;
				case RIGHT:
					if (!game.isFree(game.hero.getx(), game.hero.gety()+1)) controller.setCommand(Cmd.IDLE);
					break;
				case UP:
					if (!game.isFree(game.hero.getx()-1, game.hero.gety())) controller.setCommand(Cmd.IDLE);
					break;
				case DOWN:
					if (!game.isFree(game.hero.getx()+1, game.hero.gety())) controller.setCommand(Cmd.IDLE);
					break;
				default:
					break;
			}

			//on fait ex√©cuter la commande au h√©ro
			game.hero.action(controller.getCommand());

			//on fait bouger le monstre
			//on construit une liste de l'ensemble des commandes posibles
			ArrayList<Cmd> cmdPossible = new ArrayList<Cmd>();
			
			
			/*
			cmdPossible.add(Cmd.IDLE); //ne rien faire est forc√©ment une option possible
			if (game.isFree(game.monstre.getx(), game.monstre.gety()-1)) cmdPossible.add(Cmd.LEFT); //teste aller √† gauche
			if (game.isFree(game.monstre.getx(), game.monstre.gety()+1)) cmdPossible.add(Cmd.RIGHT); //teste aller √† droite
			if (game.isFree(game.monstre.getx()-1, game.monstre.gety())) cmdPossible.add(Cmd.UP); //teste aller en haut
			if (game.isFree(game.monstre.getx()+1, game.monstre.gety())) cmdPossible.add(Cmd.DOWN); //teste aller en bas
			//on en choisit une au hasard
			 */
			
			if(game.hero.getx()<game.monstre.getx()) { // Le hÈro est en haut du monstre
				if(game.isFree(game.monstre.getx()-1, game.monstre.gety())) cmdPossible.add(Cmd.UP); //test aller en haut si le hÈro est vers le haut
				else if(game.hero.gety()<game.monstre.gety()) { //Si le hÈro est sur la gauche
					if(game.isFree(game.monstre.getx(), game.monstre.gety()-1)) cmdPossible.add(Cmd.LEFT);//test aller ‡ gauche si le hÈro est vers la gauche
					else {
						if (game.isFree(game.monstre.getx(), game.monstre.gety()+1)) cmdPossible.add(Cmd.RIGHT); //teste aller √† droite
						if (game.isFree(game.monstre.getx()+1, game.monstre.gety())) cmdPossible.add(Cmd.DOWN); //teste aller en bas
					}
				}
				else if(game.hero.gety()>game.monstre.gety()) { //Si le hÈro est sur la droite
					if(game.isFree(game.monstre.getx(), game.monstre.gety()+1)) cmdPossible.add(Cmd.RIGHT);//test aller ‡ gauche si le hÈro est vers la gauche
					else {
						if (game.isFree(game.monstre.getx()+1, game.monstre.gety())) cmdPossible.add(Cmd.DOWN); //teste aller en bas
						if (game.isFree(game.monstre.getx(), game.monstre.gety()-1)) cmdPossible.add(Cmd.LEFT); //teste aller √† gauche
					}
						 
				}
			}
			else if(game.hero.getx()>game.monstre.getx()){ //Si le hÈro est en bas du monstre
				if(game.isFree(game.monstre.getx()+1, game.monstre.gety())) cmdPossible.add(Cmd.DOWN); //test aller en bas si le hÈro est vers le bas
				else if(game.hero.gety()<game.monstre.gety()) { //Si le hÈro est sur la gauche
					if(game.isFree(game.monstre.getx(), game.monstre.gety()-1)) cmdPossible.add(Cmd.LEFT);//test aller ‡ gauche si le hÈro est vers la gauche
					else {
						if (game.isFree(game.monstre.getx(), game.monstre.gety()+1)) cmdPossible.add(Cmd.RIGHT); //teste aller √† droite
						if (game.isFree(game.monstre.getx()-1, game.monstre.gety())) cmdPossible.add(Cmd.UP); //teste aller en haut
					}
				}
				
				else if(game.hero.gety()>game.monstre.gety()) { //Si le hÈro est sur la droite
					if(game.isFree(game.monstre.getx(), game.monstre.gety()+1)) cmdPossible.add(Cmd.RIGHT);//test aller ‡ droite si le hÈro est vers la droite
					else {
						if (game.isFree(game.monstre.getx()-1, game.monstre.gety())) cmdPossible.add(Cmd.UP); //teste aller en haut
						if (game.isFree(game.monstre.getx(), game.monstre.gety()-1)) cmdPossible.add(Cmd.LEFT); //teste aller √† gauche
					}
				}
			}
			else { // Si ils sont sur la mÍme ligne
				if (game.hero.gety()<game.monstre.gety()) { //Si le hÈro est sur la gauche
					if(game.isFree(game.monstre.getx(), game.monstre.gety()-1)) cmdPossible.add(Cmd.LEFT);//test aller ‡ gauche si le hÈro est vers la gauche
					else {
						if (game.isFree(game.monstre.getx()-1, game.monstre.gety())) cmdPossible.add(Cmd.UP); //teste aller en haut
						if (game.isFree(game.monstre.getx()+1, game.monstre.gety())) cmdPossible.add(Cmd.DOWN); //test aller en bas 
					}
				}
				else if (game.hero.gety()>game.monstre.gety()) { //Si le hÈro est sur la droite
					if(game.isFree(game.monstre.getx(), game.monstre.gety()+1)) cmdPossible.add(Cmd.RIGHT);//test aller ‡ droite si le hÈro est vers la droite
					else {
						if (game.isFree(game.monstre.getx()-1, game.monstre.gety())) cmdPossible.add(Cmd.UP); //teste aller en haut
						if (game.isFree(game.monstre.getx()+1, game.monstre.gety())) cmdPossible.add(Cmd.DOWN); //test aller en bas 
					}
				}
			}
			
			controllerMonstre.setCommand(cmdPossible.get((int)(Math.random()*cmdPossible.size())));

			//on fait bouger le monstre
			game.monstre.bouger(controllerMonstre.getCommand());
		}
	}
}
