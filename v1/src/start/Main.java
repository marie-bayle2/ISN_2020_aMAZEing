package start;

import model.PacmanPainter;
import engine.GameEngineGraphical;
import model.PacmanController;
import model.PacmanGame;

/**
 * lancement du moteur avec le jeu
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {

		// creation du jeu particulier
		PacmanGame game = new PacmanGame("helpFilePacman.txt");
		PacmanController controller = new PacmanController();
	}

	//ouvre un fichier txt contenant le labyrinthe et renvoie un tableau à deux dimensions
	//tel que tableau[i][j] est le nombre sur la i-ème ligne et j-ème colonne
	private static int[][] ouvrirLab(String nomFichier) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(nomFichier));
		String line;
		int dimx = 17;
		int dimy = 17;
		int lab[][] = new int[dimx][dimy];
		int i = 0;
		while ((line = in.readLine()) != null) {
			int j = 0;
			while (j < dimx) {
				lab[i][j] = Character.getNumericValue(line.charAt(j));
				j++;
			}
			i++;
		}
		in.close();
		return lab;
	}

	private static String toString(int [][] tab) {
		String txt = "";
		for (int i = 0; i < tab.length; i++) {
			String line = "";
			for (int j = 0; j < tab[i].length; j++) {
				line = line + tab[i][j];
			}
			txt += line;
			txt += "\n";
		}
		return txt;
	}

}
