import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
		System.out.print (toString(ouvrirLab ("src\\labyrinthe.txt")));
	}
	
	private static byte[][] ouvrirLab (String nomFichier) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader(nomFichier));
		String line;
		byte dimx = 17;
		byte dimy = 17;
		byte lab[][] = new byte[dimx][dimy];
		byte i = 0;
		while ((line = in.readLine()) != null) {
			byte j = 0;
			while (j < dimx) {
				lab[i][j] = (byte) (line.charAt(j)-48);
				j++;
			}
			i++;
		}
		in.close();
		return lab;
	}

	private static String toString(byte [][] tab) {
		String txt = "";
		for (byte i = 0; i < tab.length; i++) {
			String line = "";
			for (byte j = 0; j < tab[i].length; j++) {
				line = line + tab[i][j];
			}
			txt += line;
			txt += "\n";
		}
		return txt;
	}
}
