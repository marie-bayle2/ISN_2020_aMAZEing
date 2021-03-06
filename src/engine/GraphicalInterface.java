package engine;

import javax.swing.JFrame;

import model.Hero;
import model.Monstre;
import model.PacmanController;
import model.PacmanPainter;
import model.Labyrinthe;
import model.Fantome;
import model.Tire;


/**
 * @author Horatiu Cirstea, Vincent Thomas
 *
 * interface graphique avec son controller et son afficheur
 *
 */
public class GraphicalInterface  {

	/**
	 * le Panel pour l'afficheur
	 */
	private DrawingPanel panel;
	
	/**
	 * la construction de l'interface graphique: JFrame avec panel pour le game
	 * 
	 * @param painter l'afficheur a utiliser dans le moteur
	 * @param controller l'afficheur a utiliser dans le moteur
	 * 
	 */
	public GraphicalInterface(PacmanPainter painter, PacmanController controller){
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// attacher le panel contenant l'afficheur du game
		this.panel=new DrawingPanel(painter);
		f.setContentPane(this.panel);
		
		// attacher controller au panel du game
		this.panel.addKeyListener(controller);	
		
		f.pack();
		f.setVisible(true);
		f.getContentPane().setFocusable(true);
		f.getContentPane().requestFocus();
	}
	
	/**
	 * mise a jour du dessin
	 */
	public void paint(Hero hero, Monstre m, Labyrinthe lab, Fantome f, Tire tire) {
		this.panel.drawGame(hero, m, lab, f, tire);
	}
	
}
