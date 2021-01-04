package model;

import engine.Cmd;

public class Tire {
	private Cmd direction;
	private int x0;
	private int y0;
	private int x1;
	private int y1;
	private boolean toucheMonstre;

	public Tire(Labyrinthe lab, Monstre monstre, Cmd dir, int x, int y){
		this.direction = dir;
		this.x0 = x;
		this.y0 = y;
		this.toucheMonstre = false;
		//on cherche ou le tire va s'arreter
		int[][] l = lab.getlabyrinthe();
		if (this.direction == Cmd.T_RIGHT) {
			this.y1 = this.y0;
			int i = this.x0;
			this.x1 = i;
			while (i < lab.getWidth() - 1 && l[this.y0][i+1] != 1) {
				if (this.y1 == monstre.gety() && i + 1 == monstre.getx()) {
					this.x1 = i + 1;
					this.toucheMonstre = true;
					break;
				}				
				i++;
				this.x1 = i;
			}
			
		}
		else if (this.direction == Cmd.T_LEFT) {
			this.y1 = this.y0;
			int i = this.x0;
			this.x1 = i;
			while (i > 0 && l[this.y0][i-1] != 1) {
				if (this.y1 == monstre.gety() && i - 1 == monstre.getx()) {
					this.x1 = i - 1;
					this.toucheMonstre = true;
					break;
				}
				i--;
				this.x1 = i;
			}

		}
		else if (this.direction == Cmd.T_DOWN) {
			this.x1 = this.x0;
			int i = this.y0;
			this.y1 = i;
			while (i < lab.getHeight() - 1 && l[i+1][this.x0] != 1) {
				if (this.x1 == monstre.getx() && i + 1 == monstre.gety()) {
					this.y1 = i + 1;
					this.toucheMonstre = true;
					break;
				}
				i++;
				this.y1 = i;
			}
		}
		else if (this.direction == Cmd.T_UP) {
			this.x1 = this.x0;
			int i = this.y0;
			this.y1 = i;
			while (i > 0 && l[i-1][this.x0] != 1) {
				if (this.x1 == monstre.getx() && i - 1 == monstre.gety()) {
					this.y1 = i - 1;
					this.toucheMonstre = true;
					break;
				}
				i--;
				this.y1 = i;			
			}
		}
	}

	//getter
	public boolean getToucheMonstre() {
		return this.toucheMonstre;
	}

	public int[] getCoords(){
		int c[] = {this.x0, this.y0, this.x1, this.y1};
		return c;
	}
}