import engine.Cmd;
import model.PacmanGame;

public class Hero {
	
	int x = 1;     
	int y = 1;
	
	public Hero () {
	
	}
	
	public Hero (int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	public void action(Cmd commande) {
		if (commande == Cmd.LEFT) {
			if (PacmanGame.isFree(x-1,y)) {
				this.x = this.x - 1;
			}
			
		} 
		if (commande == Cmd.RIGHT) {
			if (PacmanGame.isFree(x+1,y)) {
				this.x = this.x + 1;
			}
			
		}
		if (commande == Cmd.UP) {
			if (PacmanGame.isFree(x,y-1)) {
				this.y = this.y - 1;
			}
			
		}
		if (commande == Cmd.DOWN) {
			if (PacmanGame.isFree(x,y+1)) {
				this.y = this.y + 1;
			}
			
		}
		if (commande == Cmd.IDLE) {
			
		}
		
	}

}