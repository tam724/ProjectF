package game;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Scanner;
import java.awt.event.*;
import java.math.*;

import javax.swing.*;

public class Game extends JPanel implements MouseMotionListener,MouseListener {
	static field F = new field();
	static int sizey;
	static int sizex;
	static int whosturn = 1;
	static JFrame f = new JFrame();
	static Component A = new Game();
	char direction = 0;

	public Game() {

		addMouseMotionListener(this);
		addMouseListener(this);
	}

	public static char shoot() {
		char direction = 0;
		System.out.print("Welche Richtung? qweadyxc");
		direction = new Scanner(System.in).next().charAt(0);
		while (!(direction == 'q' || direction == 'w' || direction == 'e'
				|| direction == 'a' || direction == 'd' || direction == 'y'
				|| direction == 'x' || direction == 'c')) {
			direction = new Scanner(System.in).next().charAt(0);
			System.out.println("Bitte richtige Richtung eingeben!");
		}
		return direction;
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = sizex / 15;
		int y = sizey / 11;
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 10; j++) {
				Graphics2D g23d = (Graphics2D) g;
				Ellipse2D.Double circlepoint = new Ellipse2D.Double(i * x - 2,
						j * y - 2, 4, 4);
				g23d.fill(circlepoint);
				if (F.isBall(i, j)) {
					Graphics2D g2d = (Graphics2D) g;
					Ellipse2D.Double circle = new Ellipse2D.Double(i * x - 4, j
							* y - 4, 8, 8);
					g2d.fill(circle);
					switch(F.pointer){
					case('q'):
						g.drawLine(i * x - 4,  j* y - 4, i * x - 4 -x,  j* y - 4 -y);
					break;
					case('w'):
						g.drawLine(i * x - 4,  j* y - 4, i * x - 4,  j* y - 4 -y);
					break;
					case('e'):
						g.drawLine(i * x - 4,  j* y - 4, i * x - 4 +x,  j* y - 4 -y);
					break;
					case('a'):
						g.drawLine(i * x - 4,  j* y - 4, i * x - 4 -x,  j* y - 4);
					break;
					case('d'):
						g.drawLine(i * x - 4,  j* y - 4, i * x - 4 +x,  j* y - 4);
					break;
					case('y'):
						g.drawLine(i * x - 4,  j* y - 4, i * x - 4 -x,  j* y - 4 +y);
					break;
					case('x'):
						g.drawLine(i * x - 4,  j* y - 4, i * x - 4 ,  j* y - 4 +y);
					break;
					case('c'):
						g.drawLine(i * x - 4,  j* y - 4, i * x - 4 +x,  j* y - 4 +y);
					break;
					}
				}
				if (F.isGesetzt(i, j, 0)) {
					g.drawLine(x * i, y * j, x * i + x, y * j);
				}
				if (F.isGesetzt(i, j, 1)) {
					g.drawLine(x * i, y * j, x * i, y * j + y);
				}
				if (F.isGesetzt(i, j, 2)) {
					g.drawLine(x * i + x, y * j, x * i, y * j + y);
				}
				if (F.isGesetzt(i, j, 3)) {
					g.drawLine(x * i, y * j, x * i + x, y * j + y);
				}
				
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(1300, 900);
		f.getContentPane().add(new Game());
		sizex = f.getWidth();
		sizey = f.getHeight();
		f.setVisible(true);
		f.add(A);
		f.setVisible(true);
		do {
			Thread.sleep(1000);
		} while (F.isGoooooool() == 0);
		if (F.isGoooooool() == 1) {
			JOptionPane.showMessageDialog(null, "Spieler 2 hat gewonnen");
		} else if (F.isGoooooool() == 2) {
			JOptionPane.showMessageDialog(null, "Spieler 1 hat gewonnen");
		} else {
			System.out.print("");
		}
		f.setVisible(false);
		f.dispose();
	}
	
	public char getDirection(int i, int j){
		int deltaj = j-(F.Ballj*sizex/15);
		int deltai = i-(F.Balli*sizey/11);
		double a = Math.toDegrees(Math.atan((double)deltaj/(double)deltai));
		if(deltaj <= 0){
			if(a >= 0 && a < 22.5){
				return 'a';
			}
			else if(a>=22.5 && a < 67.5){
				return 'q';
			}
			else if(a > 67.5){
				return 'w';
			}
			else if(a<=0 && a > -22.5){
				return 'd';
			}
			else if(a<=-22.5 && a > -67.5){
				return 'e';
			}
			else if(a < -67.5){
				return 'w';
			}
		}
		else if(deltaj > 0){
			if(a >= 0 && a < 22.5){
				return 'd';
			}
			else if(a>=22.5 && a < 67.5){
				return 'c';
			}
			else if(a > 67.5){
				return 'x';
			}
			else if(a<=0 && a > -22.5){
				return 'a';
			}
			else if(a<=-22.5 && a > -67.5){
				return 'y';
			}
			else if(a < -67.5){
				return 'x';
			}
		}
		return 0;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		
		f.remove(A);
		A = new Game();
		F.pointer = getDirection(arg0.getX(),arg0.getY());
		f.add(A);
		f.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		direction = getDirection(arg0.getX(),arg0.getY());
		if (F.isValidShoot(direction)) {
			F.setShoot(direction, 1);
			F.moveBall(direction);
		} else {
		JOptionPane.showMessageDialog(null, "Ungültiger Zug");
		}
		System.out.println(F.isTaken(direction));
		sizex = f.getWidth();
		sizey = f.getHeight();
		f.remove(A);
		A = new Game();
		f.add(A);
		f.setVisible(true);
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}