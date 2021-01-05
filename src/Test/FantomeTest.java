package test;

import model.Labyrinthe;
import model.Fantome;

import java.io.IOException;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.Assert;

public class FantomeTest {
    public Fantome f;
    public Labyrinthe l;

    @org.junit.Before
    public void avantTest() throws IOException{
        System.out.println(" --- Avant test ---\n");
        l = new Labyrinthe("src/labyrinthe3.txt");
        f = new Fantome(l);
    }

    @Test
    public void testBouger() {
        System.out.println("# Test de bouger #");
        f.sety(1);
        f.bouger(l);
        Assert.assertTrue(f.gety() == 2);

        f.sety(l.getHeight() - 2);
        f.bouger(l);
        Assert.assertTrue(f.gety() == l.getHeight() - 3);

        f.setc(1);
        int old_y = 8;
        f.sety(old_y);
        f.bouger(l);
        Assert.assertTrue(f.gety() == old_y + 1);

        f.setc(0);
        old_y = 8;
        f.sety(old_y);
        f.bouger(l);
        Assert.assertTrue(f.gety() == old_y - 1);

        int old_x = f.getx();
        f.bouger(l);
        Assert.assertTrue(f.getx() == old_x);
        System.out.println("La methode est correcte.\n\n");
    }

}