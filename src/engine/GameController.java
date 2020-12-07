package engine;

/**
 * @author Horatiu Cirstea
 * 
 * controleur qui envoie des commandes au jeu 
 * 
 */
public interface GameController {

	/**
	 * quand on demande les commandes, le controleur retourne la commande en
	 * cours
	 * 
	 * @return commande faite par le joueur
	 */
	public Cmd getCommand();

}
