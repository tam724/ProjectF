package game;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Overview implements ActionListener {
	Player one;
	Player two;
	private boolean playeroneready = false;
	private boolean playertwoready = false;
	JFrame Frame = new JFrame();
	JPanel Panel = new JPanel();
	JButton ButtonOne = new JButton();
	JButton ButtonTwo = new JButton();
	JButton Save = new JButton();
	JButton ButtonQuit = new JButton();
	int starter;

	Overview(Player one, Player two, Player winner) {
		this.one = one;
		this.two = two;
		if (winner == one){
			starter = field.PLAYER_TWO;
		}
		else if (winner == two){
			starter = field.PLAYER_ONE;
		}

		Frame.setTitle("Project F >> "+one.score+" : "+ two.score);
		Frame.toFront();
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ButtonOne.setBackground(one.color);
		ButtonOne.addActionListener(this);
		setButtonText(ButtonOne, playeroneready, one.score, 1);

		ButtonTwo.setBackground(two.color);
		ButtonTwo.addActionListener(this);
		setButtonText(ButtonTwo, playertwoready, two.score, 2);

		ButtonQuit.setText("Beenden?");
		ButtonQuit.addActionListener(this);
		
		Save.setText("Speichern?");
		Save.addActionListener(this);
		Frame.setSize(400, 400);
		Panel.add(ButtonOne, null);
		Panel.add(ButtonTwo, null);
		Panel.add(ButtonQuit, null);
		Panel.add(Save,null);
		Frame.add(Panel);
		Panel.setFont(Panel.getFont().deriveFont((float) 40));
		Frame.setVisible(true);
	}

	void setButtonText(JButton button, boolean playerready, int score, int player) {
		if (!playerready) {
			if(button == ButtonOne){
			button.setText(one.name+ " : #" + score
					+ " Nochmal?");
			}
			else if(button == ButtonTwo){
				button.setText(two.name+ " : #" + score
						+ " Nochmal?");
			}
		} else {
			button.setText("Rückgängig?");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.ButtonOne) {
			if (playeroneready) {
				playeroneready = false;
			} else {
				playeroneready = true;
			}
			if(playeroneready && playertwoready){
				Frame.dispose();
				new Spiel(one, two,starter);
			}
			setButtonText(ButtonOne, playeroneready, one.score, 1);
			Panel.repaint();
		}
		if (e.getSource() == this.ButtonTwo) {
			if (playertwoready) {
				playertwoready = false;
			} else {
				playertwoready = true;
			}
			if(playeroneready && playertwoready){
				Frame.dispose();
				new Spiel(one, two,starter);
			}
			setButtonText(ButtonTwo, playertwoready, two.score, 2);
			Panel.repaint();
		}
		if(e.getSource()== this.ButtonQuit){
			if(one.score > two.score){
				JOptionPane.showMessageDialog(null, one.name+" hat gewonnen!");
			}
			if(one.score < two.score){
				JOptionPane.showMessageDialog(null, two.name+" hat gewonnen!");
			}
			if(one.score == two.score){
				JOptionPane.showMessageDialog(null, "Gleichstand!");
			}
			Frame.dispose();
			System.exit(0);
		}
		if(e.getSource() == this.Save){
			
		}

	}

}