package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			int x = Panel.getWidth() / 14;
			int y = Panel.getHeight() / 10;
			for (int i = 0; i < 14; i++) {
				for (int j = 0; j < 10; j++) {
					if (Feld.isBall(i, j)) {
						
						// Ball
						Ellipse2D.Double circlepoint = new Ellipse2D.Double(i
								* x - 4, j * y - 4, 8, 8);
						g2.fill(circlepoint);

						// Zeiger
						if (Feld.getPlayer() == 2) {
							g.setColor(one.color);
						} else if (Feld.getPlayer() == 3) {
							g.setColor(two.color);
						}
						g2.setStroke(new BasicStroke(1));
						switch (pointer) {
						case ('q'):
							g2.drawLine(i * x, j * y, i * x - x, j * y - y);
							break;
						case ('w'):
							g2.drawLine(i * x, j * y, i * x, j * y - y);
							break;
						case ('e'):
							g2.drawLine(i * x, j * y, i * x + x, j * y - y);
							break;
						case ('a'):
							g2.drawLine(i * x, j * y, i * x - x, j * y);
							break;
						case ('d'):
							g2.drawLine(i * x, j * y, i * x + x, j * y);
							break;
						case ('y'):
							g2.drawLine(i * x, j * y, i * x - x, j * y + y);
							break;
						case ('x'):
							g2.drawLine(i * x, j * y, i * x, j * y + y);
							break;
						case ('c'):
							g2.drawLine(i * x, j * y, i * x + x, j * y + y);
							break;
						}
					}
					
					// Linien
					g2.setColor(Color.BLACK);
					g2.setStroke(new BasicStroke(4));
					if (Feld.getValue(i, j, 0) == 1 ) {
						g2.setColor(Color.BLACK);
						g2.drawLine(x * i, y * j, x * i + x, y * j);
					} else if (Feld.getValue(i, j, 0) == 2) {
						g2.setColor(one.color);
						g2.drawLine(x * i, y * j, x * i + x, y * j);
					} else if (Feld.getValue(i, j, 0) == 3) {
						g2.setColor(two.color);
						g2.drawLine(x * i, y * j, x * i + x, y * j);
					}

					if (Feld.getValue(i, j, 1) == 1 ) {
						g2.setColor(Color.BLACK);
						g2.drawLine(x * i, y * j, x * i, y * j + y);
					} else if (Feld.getValue(i, j, 1) == 2) {
						g2.setColor(one.color);
						g2.drawLine(x * i, y * j, x * i, y * j + y);
					} else if (Feld.getValue(i, j, 1) == 3) {
						g2.setColor(two.color);
						g2.drawLine(x * i, y * j, x * i, y * j + y);
					}

					if (Feld.getValue(i, j, 2) == 1 ) {
						g2.setColor(Color.BLACK);
						g2.drawLine(x * i + x, y * j, x * i, y * j + y);
					} else if (Feld.getValue(i, j, 2) == 2) {
						g2.setColor(one.color);
						g2.drawLine(x * i + x, y * j, x * i, y * j + y);
					} else if (Feld.getValue(i, j, 2) == 3) {
						g2.setColor(two.color);
						g2.drawLine(x * i + x, y * j, x * i, y * j + y);
					}

					if (Feld.getValue(i, j, 3) == 1 ) {
						g2.setColor(Color.BLACK);
						g2.drawLine(x * i, y * j, x * i + x, y * j + y);
					} else if (Feld.getValue(i, j, 3) == 2) {
						g2.setColor(one.color);
						g2.drawLine(x * i, y * j, x * i + x, y * j + y);
					} else if (Feld.getValue(i, j, 3) == 3) {
						g2.setColor(two.color);
						g2.drawLine(x * i, y * j, x * i + x, y * j + y);
					}
					g2.setColor(Color.BLACK);

					// Punkt
					Ellipse2D.Double circle = new Ellipse2D.Double(i * x - 1, j
							* y - 1, 2, 2);
					g2.fill(circle);
				}
			}
		}
	};
	char pointer = 0;
	int playerone;
	int playertwo;
	Player one;
	Player two;

	public Spiel(Player one, Player two, int starter) {

		this.one = one;
		this.two = two;
		Feld = new field(starter);
		Frame.setTitle("Project F >> "+one.score+" : "+ two.score);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.toFront();
		Frame.addMouseMotionListener(this);
		Frame.addMouseListener(this);
		Frame.setSize(1300, 900);
		Frame.add(Panel);
		Frame.toFront();
		Frame.setVisible(true);
	}

	private char getDirection(int i, int j) {
		int deltaj = j - ((Feld.Ballj) * (Panel.getWidth() / 14));
		int deltai = i - ((Feld.Balli) * (Panel.getHeight() / 10));
		double a = Math.toDegrees(Math.atan((double) deltaj / (double) deltai));
		if (deltaj <= 0) {
			if (a >= 0 && a < 22.5) {
				return 'a';
			} else if (a >= 22.5 && a < 67.5) {
				return 'q';
			} else if (a > 67.5) {
				return 'w';
			} else if (a <= 0 && a > -22.5) {
				return 'd';
			} else if (a <= -22.5 && a > -67.5) {
				return 'e';
			} else if (a < -67.5) {
				return 'w';
			}
		} else if (deltaj > 0) {
			if (a >= 0 && a < 22.5) {
				return 'd';
			} else if (a >= 22.5 && a < 67.5) {
				return 'c';
			} else if (a > 67.5) {
				return 'x';
			} else if (a <= 0 && a > -22.5) {
				return 'a';
			} else if (a <= -22.5 && a > -67.5) {
				return 'y';
			} else if (a < -67.5) {
				return 'x';
			}
		}
		return 0;
	}

	private void setWinner() {
		if (Feld.isWinner() != 0) {
			Panel.repaint();
			
			if (Feld.isWinner() == 1) {
				JOptionPane.showMessageDialog(null, one.name
						+ " hat gewonnen!");
				one.score++;
			} else if (Feld.isWinner() == 2) {
				JOptionPane.showMessageDialog(null, two.name
						+ " hat gewonnen!");
				two.score++;
			}
			Frame.dispose();
			new Overview(one, two, Feld.isWinner());
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		pointer = getDirection(e.getX(), e.getY());
		Panel.repaint();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Feld.shoot(getDirection(e.getX(), e.getY()));
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
