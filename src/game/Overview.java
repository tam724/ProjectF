package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Overview implements ActionListener {
	private int playerone;
	private int playertwo;
	private boolean playeroneready = false;
	private boolean playertwoready = false;
	JFrame Frame = new JFrame();
	JPanel Panel = new JPanel();
	JButton one = new JButton();
	JButton two = new JButton();
	JButton quit = new JButton();
	int starter = 0;

	Overview(int i, int j, int winner) {
		if (winner == 0){
			starter = 1;
		}
		else if (winner == 1){
			starter = 2;
		}
		else if(winner == 2){
			starter = 1;
		}
		this.playerone = i;
		this.playertwo = j;

		one.setBackground(Color.RED);
		one.addActionListener(this);
		setButtonText(one, playeroneready, playerone, 1);

		two.setBackground(Color.BLUE);
		two.addActionListener(this);
		setButtonText(two, playertwoready, playertwo, 2);

		quit.setText("Beenden?");
		Frame.setSize(400, 400);
		Panel.add(one, null);
		Panel.add(two, null);
		Panel.add(quit, null);
		Frame.add(Panel);
		Frame.setVisible(true);
	}

	void setButtonText(JButton button, boolean playerready, int score, int player) {
		if (!playerready) {
			button.setText("Player " + player + " : #" + score
					+ " Nochmal?");
		} else {
			button.setText("Rückgängig?");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.one) {
			if (playeroneready) {
				playeroneready = false;
			} else {
				playeroneready = true;
			}
			if(playeroneready && playertwoready){
				Frame.dispose();
				new Spiel(playerone, playertwo, starter);
			}
			setButtonText(one, playeroneready, playerone, 1);
			Panel.repaint();
		}
		if (e.getSource() == this.two) {
			if (playertwoready) {
				playertwoready = false;
			} else {
				playertwoready = true;
			}
			if(playeroneready && playertwoready){
				Frame.dispose();
				new Spiel(playerone, playertwo, starter);
			}
			setButtonText(two, playertwoready, playertwo, 2);
			Panel.repaint();
		}

	}

}