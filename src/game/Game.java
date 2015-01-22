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

public class Game extends JFrame implements MouseListener, MouseMotionListener {

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
						if (Feld.getCurrentPlayer() == field.PLAYER_ONE) {
							g.setColor(one.color);
						} else if (Feld.getCurrentPlayer() == field.PLAYER_TWO) {
							g.setColor(two.color);
						}
						g2.setStroke(new BasicStroke(1));
						switch (pointer) {
						case (field.UP_LEFT):
							g2.drawLine(i * x, j * y, i * x - x, j * y - y);
							break;
						case (field.UP):
							g2.drawLine(i * x, j * y, i * x, j * y - y);
							break;
						case (field.UP_RIGHT):
							g2.drawLine(i * x, j * y, i * x + x, j * y - y);
							break;
						case (field.LEFT):
							g2.drawLine(i * x, j * y, i * x - x, j * y);
							break;
						case (field.RIGHT):
							g2.drawLine(i * x, j * y, i * x + x, j * y);
							break;
						case (field.DOWN_LEFT):
							g2.drawLine(i * x, j * y, i * x - x, j * y + y);
							break;
						case (field.DOWN):
							g2.drawLine(i * x, j * y, i * x, j * y + y);
							break;
						case (field.DOWN_RIGHT):
							g2.drawLine(i * x, j * y, i * x + x, j * y + y);
							break;
						}
					}

					// Linien
					g2.setColor(Color.BLACK);
					g2.setStroke(new BasicStroke(4));
					if (Feld.getValue(i, j, 0) == 1) {
						g2.setColor(Color.BLACK);
						g2.drawLine(x * i, y * j, x * i + x, y * j);
					} else if (Feld.getValue(i, j, 0) == 2) {
						g2.setColor(one.color);
						g2.drawLine(x * i, y * j, x * i + x, y * j);
					} else if (Feld.getValue(i, j, 0) == 3) {
						g2.setColor(two.color);
						g2.drawLine(x * i, y * j, x * i + x, y * j);
					}

					if (Feld.getValue(i, j, 1) == 1) {
						g2.setColor(Color.BLACK);
						g2.drawLine(x * i, y * j, x * i, y * j + y);
					} else if (Feld.getValue(i, j, 1) == 2) {
						g2.setColor(one.color);
						g2.drawLine(x * i, y * j, x * i, y * j + y);
					} else if (Feld.getValue(i, j, 1) == 3) {
						g2.setColor(two.color);
						g2.drawLine(x * i, y * j, x * i, y * j + y);
					}

					if (Feld.getValue(i, j, 2) == 1) {
						g2.setColor(Color.BLACK);
						g2.drawLine(x * i + x, y * j, x * i, y * j + y);
					} else if (Feld.getValue(i, j, 2) == 2) {
						g2.setColor(one.color);
						g2.drawLine(x * i + x, y * j, x * i, y * j + y);
					} else if (Feld.getValue(i, j, 2) == 3) {
						g2.setColor(two.color);
						g2.drawLine(x * i + x, y * j, x * i, y * j + y);
					}

					if (Feld.getValue(i, j, 3) == 1) {
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
	int pointer = 0;
	int playerone;
	int playertwo;
	Player one;
	Player two;

	public Game(Player one, Player two, int beginner) {

		this.one = one;
		this.two = two;
		Feld = new field(beginner);
		Frame.setTitle("Project F >> " + one.score + " : " + two.score);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Frame.toFront();
		Frame.addMouseMotionListener(this);
		Frame.addMouseListener(this);
		Frame.setSize(1300, 900);
		Frame.add(Panel);
		Frame.toFront();
		Frame.setVisible(true);
	}

	private int getDirection(int i, int j) {
		int deltaj = j - ((Feld.Bally) * (Panel.getWidth() / 14));
		int deltai = i - ((Feld.Ballx) * (Panel.getHeight() / 10));
		double a = Math.toDegrees(Math.atan((double) deltaj / (double) deltai));
		if (deltaj <= 0) {
			if (a >= 0 && a < 22.5) {
				return field.LEFT;
			} else if (a >= 22.5 && a < 67.5) {
				return field.UP_LEFT;
			} else if (a > 67.5) {
				return field.UP;
			} else if (a <= 0 && a > -22.5) {
				return field.RIGHT;
			} else if (a <= -22.5 && a > -67.5) {
				return field.UP_RIGHT;
			} else if (a < -67.5) {
				return field.UP;
			}
		} else if (deltaj > 0) {
			if (a >= 0 && a < 22.5) {
				return field.RIGHT;
			} else if (a >= 22.5 && a < 67.5) {
				return field.DOWN_RIGHT;
			} else if (a > 67.5) {
				return field.DOWN;
			} else if (a <= 0 && a > -22.5) {
				return field.LEFT;
			} else if (a <= -22.5 && a > -67.5) {
				return field.DOWN_LEFT;
			} else if (a < -67.5) {
				return field.DOWN;
			}
		}
		return 0;
	}

	private void setWinner() {

		if (Feld.isWinner()) {
			if (Feld.getWinner() == field.PLAYER_ONE) {
				JOptionPane
						.showMessageDialog(null, one.name + " hat gewonnen!");
				Frame.dispose();
				one.score++;
				new Overview(one, two, one);
			} else if (Feld.getWinner() == field.PLAYER_TWO) {
				JOptionPane
						.showMessageDialog(null, two.name + " hat gewonnen!");
				Frame.dispose();
				two.score++;
				new Overview(one, two, two);
			}
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
		if (Feld.getCurrentPlayer() == field.PLAYER_ONE) {
			Feld.shoot(getDirection(e.getX(), e.getY()));
			setWinner();
			Panel.repaint();
		} else {
			String AI_shoot = Feld.getBestShoot(field.PLAYER_TWO);
			System.out.println(AI_shoot);
			if (AI_shoot != null) {
				for (int i = 0; i < AI_shoot.length(); i++) {
					Feld.shoot(((int) AI_shoot.charAt(i) - 48));
					setWinner();
					Panel.repaint();
				}
			} else {
				setWinner();
				Panel.repaint();
			}
		}
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
