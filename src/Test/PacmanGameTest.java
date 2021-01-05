package Test;

import static org.junit.Assert.*;

public class PacmanGameTest {

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @org.junit.Test
    public void evolve() {
    }

    @org.junit.Test
    public void isFinished() {
     	//le hero tombe sur le tresor
    	int heros=this.labyrinthe.TRESOR;
    	assertEquals("erreur sur trouver le tresors",heros.isFinished(),True);
    	//le hero tombe sur un monstre
   
    }
}