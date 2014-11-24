package game;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class Game extends JPanel {
	static field F = new field();
	static int sizey;
	static int sizex;



	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = sizex/15;
		int y = sizey/11;
		System.out.println(x + " "+y);
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 10; j++) {
				g.drawLine(x * i + 25, y * j + 20, x * i + 25,
						y * j + 30);
				g.drawLine(x * i + 20, y * j + 25, x * i + 30,
						y * j + 25);
				g.drawLine(x * i+20, y * j+20, x * i + 30, y * j + 30);
				g.drawLine(x * i + 30, y * j+20, x * i+20, y * j + 30);
				if(F.isBall(i, j)){
					Graphics2D g2d = (Graphics2D)g;
					Ellipse2D.Double circle = new Ellipse2D.Double(i*x+17, j*y+17, 20, 20);
					g2d.fill(circle);
				}
				if (F.isGesetzt(i, j, 0)) {
					g.drawLine(x * i + 50, y * j + 25, x * i + 100,
							y * j + 25);
				}
				if (F.isGesetzt(i, j, 1)) {
					g.drawLine(x * i + 25, y * j + 50, x * i + 25,
							y * j + 100);
				}
				if (F.isGesetzt(i, j, 2)) {
					g.drawLine(x * i + 50, y * j + 100, x * i + 100,
							y * j + 50);
				}
				if (F.isGesetzt(i, j, 3)) {
					g.drawLine(x * i + 50, y * j + 50, x * i + 100,
							y * j + 100);
				}
			}
		}
	}

	public static void main(String[] args) {
		int whosturn = 1;
		JFrame f = new JFrame();

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1300, 900);
		sizex = f.getWidth();
		sizey = f.getHeight();
		f.setVisible(true);
		Component A = new Game();
		do{
			f.add(A);
			f.setVisible(true);
			System.out.println("Player " + whosturn);
			char direction = F.shoot();

			if (F.isValidShoot(direction)) {
				F.moveball(direction);
			} else {
				System.out.println("Ungültiger Zug!");
				continue;
			}
			if(F.nochmal()){
				
			}
			else{
				if(whosturn == 1)whosturn = 2;
				else whosturn = 1;
			}
			sizex = f.getWidth();
			sizey = f.getHeight();
			f.remove(A);
			A = new Game();
		}
		while((!F.isEnd())||F.isGoooooool()==0);
		if(F.isGoooooool()==1){
			System.out.println("Player 1 hat gewonnen");
		}
		else if(F.isGoooooool()==2){
			System.out.println("Player 2 hat gewonnen");
		}
		else{
			System.out.print("");
		}
		return;
	}
}