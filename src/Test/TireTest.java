package test;

import model.Labyrinthe;
import model.Monstre;
import model.Tire;
import engine.Cmd;

import java.io.IOException;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.Assert;

public class TireTest {
	public Labyrinthe l;
	public Tire tire;
	public Monstre monstre;

	@org.junit.Before
    public void avantTest() throws IOException {
        System.out.println(" --- Avant test ---\n");
        l = new Labyrinthe("src/labyrinthe3.txt");
        monstre = new Monstre();
    }

    @Test
    public void testConstructeur() {
    	System.out.println("# Test du constructeur #");
    	//verif des quatres dir sur mur et verifie si le monstre est bien pas detectee
    	tire = new Tire(l, monstre, Cmd.T_LEFT, 1, 1);
    	int[] c = tire.getCoords();
    	Assert.assertTrue(c[0] == 1 && c[1] == 1 && c[2] == 1 && c[3] == 1);
    	Assert.assertTrue(tire.getToucheMonstre() == false);

    	tire = new Tire(l, monstre, Cmd.T_DOWN, 1, 1);
    	c = tire.getCoords();
    	Assert.assertTrue(c[0] == 1 && c[1] == 1 && c[2] == 1 && c[3] == 1);
    	Assert.assertTrue(tire.getToucheMonstre() == false);

    	tire = new Tire(l, monstre, Cmd.T_UP, 1, 1);
    	c = tire.getCoords();
    	Assert.assertTrue(c[0] == 1 && c[1] == 1 && c[2] == 1 && c[3] == 1);
    	Assert.assertTrue(tire.getToucheMonstre() == false);

    	tire = new Tire(l, monstre, Cmd.T_RIGHT, 1, 1);
    	c = tire.getCoords();
    	Assert.assertTrue(c[0] == 1 && c[1] == 1 && c[2] == 5 && c[3] == 1);
    	Assert.assertTrue(tire.getToucheMonstre() == false);


    	//verif des quatres dir sur monstre avec test si le monstre est detectee
    	monstre.setx(1);
    	monstre.sety(1);
    	tire = new Tire(l, monstre, Cmd.T_LEFT, 2, 1);
    	c = tire.getCoords();
    	Assert.assertTrue(c[0] == 2 && c[1] == 1 && c[2] == 1 && c[3] == 1);
    	Assert.assertTrue(tire.getToucheMonstre() == true);

    	monstre.setx(2);
    	monstre.sety(1);
    	tire = new Tire(l, monstre, Cmd.T_RIGHT, 1, 1);
    	c = tire.getCoords();
    	Assert.assertTrue(c[0] == 1 && c[1] == 1 && c[2] == 2 && c[3] == 1);
    	Assert.assertTrue(tire.getToucheMonstre() == true);

    	monstre.setx(5);
    	monstre.sety(2);
    	tire = new Tire(l, monstre, Cmd.T_DOWN, 5, 1);
    	c = tire.getCoords();
    	Assert.assertTrue(c[0] == 5 && c[1] == 1 && c[2] == 5 && c[3] == 2);
    	Assert.assertTrue(tire.getToucheMonstre() == true);

    	monstre.setx(5);
    	monstre.sety(2);
    	tire = new Tire(l, monstre, Cmd.T_DOWN, 5, 1);
    	c = tire.getCoords();
    	Assert.assertTrue(c[0] == 5 && c[1] == 1 && c[2] == 5 && c[3] == 2);
    	Assert.assertTrue(tire.getToucheMonstre() == true);

    	monstre.setx(5);
    	monstre.sety(1);
    	tire = new Tire(l, monstre, Cmd.T_UP, 5, 2);
    	c = tire.getCoords();
    	Assert.assertTrue(c[0] == 5 && c[1] == 2 && c[2] == 5 && c[3] == 1);
    	Assert.assertTrue(tire.getToucheMonstre() == true);

    	System.out.println("La methode est correcte.\n\n");
    }


}