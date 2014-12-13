package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Spiel extends JFrame implements MouseListener, MouseMotionListener {
	
	private static final long serialVersionUID = 1L;
	field Feld;
	JFrame Frame = new JFrame();
	JPanel Panel = new JPanel() {
		private static final long serialVersionUID = 1L;

		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			int x = Frame.getWidth() / 15;
			int y = Frame.getHeight() / 11;
			for (int i = 0; i < 14; i++) {
				for (int j = 0; j < 10; j++) {
					Graphics2D g2d = (Graphics2D) g;
					Ellipse2D.Double circlepoint = new Ellipse2D.Double(i * x
							- 2, j * y - 2, 4, 4);
					g2d.fill(circlepoint);
					if (Feld.isBall(i, j)) {
						Ellipse2D.Double circle = new Ellipse2D.Double(i * x
								- 4, j * y - 4, 8, 8);
						g2d.fill(circle);
						if (Feld.getPlayer() == 2) {
							g.setColor(Color.RED);
						} else if (Feld.getPlayer() == 3) {
							g.setColor(Color.BLUE);
						}
						switch (pointer) {
						case ('q'):
							g.drawLine(i * x, j * y, i * x - x, j * y - y);
							break;
						case ('w'):
							g.drawLine(i * x, j * y, i * x, j * y - y);
							break;
						case ('e'):
							g.drawLine(i * x, j * y, i * x + x, j * y - y);
							break;
						case ('a'):
							g.drawLine(i * x, j * y, i * x - x, j * y);
							break;
						case ('d'):
							g.drawLine(i * x, j * y, i * x + x, j * y);
							break;
						case ('y'):
							g.drawLine(i * x, j * y, i * x - x, j * y + y);
							break;
						case ('x'):
							g.drawLine(i * x, j * y, i * x, j * y + y);
							break;
						case ('c'):
							g.drawLine(i * x, j * y, i * x + x, j * y + y);
							break;
						}
						g.setColor(Color.BLACK);
					}

					if (Feld.getValue(i, j, 0) == 1) {
						g.setColor(Color.BLACK);
						g.drawLine(x * i, y * j, x * i + x, y * j);
					} else if (Feld.getValue(i, j, 0) == 2) {
						g.setColor(Color.RED);
						g.drawLine(x * i, y * j, x * i + x, y * j);
					} else if (Feld.getValue(i, j, 0) == 3) {
						g.setColor(Color.BLUE);
						g.drawLine(x * i, y * j, x * i + x, y * j);
					}

					if (Feld.getValue(i, j, 1) == 1) {
						g.setColor(Color.BLACK);
						g.drawLine(x * i, y * j, x * i, y * j + y);
					} else if (Feld.getValue(i, j, 1) == 2) {
						g.setColor(Color.RED);
						g.drawLine(x * i, y * j, x * i, y * j + y);
					} else if (Feld.getValue(i, j, 1) == 3) {
						g.setColor(Color.BLUE);
						g.drawLine(x * i, y * j, x * i, y * j + y);
					}

					if (Feld.getValue(i, j, 2) == 1) {
						g.setColor(Color.BLACK);
						g.drawLine(x * i + x, y * j, x * i, y * j + y);
					} else if (Feld.getValue(i, j, 2) == 2) {
						g.setColor(Color.RED);
						g.drawLine(x * i + x, y * j, x * i, y * j + y);
					} else if (Feld.getValue(i, j, 2) == 3) {
						g.setColor(Color.BLUE);
						g.drawLine(x * i + x, y * j, x * i, y * j + y);
					}

					if (Feld.getValue(i, j, 3) == 1) {
						g.setColor(Color.BLACK);
						g.drawLine(x * i, y * j, x * i + x, y * j + y);
					} else if (Feld.getValue(i, j, 3) == 2) {
						g.setColor(Color.RED);
						g.drawLine(x * i, y * j, x * i + x, y * j + y);
					} else if (Feld.getValue(i, j, 3) == 3) {
						g.setColor(Color.BLUE);
						g.drawLine(x * i, y * j, x * i + x, y * j + y);
					}

					g.setColor(Color.BLACK);
				}
			}
		}
	};
	char pointer = 0;
	int playerone; 
	int playertwo;
	
	public Spiel(int playerone, int playertwo, int starter) {

		Feld = new field(starter);
		this.playerone = playerone;
		this.playertwo = playertwo;
		Frame.addMouseMotionListener(this);
		Frame.addMouseListener(this);
		Frame.setSize(1300, 900);
		Frame.add(Panel);
		Frame.toFront();
		Frame.setVisible(true);
	}
	
	private char getDirection(int i, int j){
		int deltaj = j-(Feld.Ballj*(Frame.getWidth()/15));
		int deltai = i-(Feld.Balli*(Frame.getHeight()/11));
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

	private void setWinner(){
		if(Feld.isWinner() != 0){
			JOptionPane.showMessageDialog(null, "Spieler "+Feld.isWinner()+" hat gewonnen!");
			if(Feld.isWinner() == 1){
				playerone++;
			}
			else if(Feld.isWinner() == 2){
				playertwo++;
			}
			Frame.dispose();
			new Overview(playerone, playertwo, Feld.isWinner());
			
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		 pointer = getDirection(e.getX(),e.getY());
		 Panel.repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Feld.shoot(getDirection(e.getX(),e.getY()));
		setWinner();
		Panel.repaint();

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

}
