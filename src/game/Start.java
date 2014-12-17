package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Start implements ActionListener {
	JFrame Frame = new JFrame();
	JPanel Panel = new JPanel();
	Player one;
	Player two;
	JButton ColorButtonOne = new JButton();
	JButton ColorButtonTwo = new JButton();
	JTextField NameOne = new JTextField();
	boolean oneOk = false;
	boolean twoOk = false;
	JTextField NameTwo = new JTextField();
	JButton NameOneOk = new JButton();
	JButton NameTwoOk = new JButton();

	Start() {
		Frame.setTitle("ProjectF");
		Frame.toFront();
		one = new Player(Color.RED, "tam");
		two = new Player(Color.BLUE, "second");

		NameOne.setText("Player 1");
		NameOne.setAlignmentX(0.0f);
		ColorButtonOne.setBackground(Color.RED);
		ColorButtonOne.addActionListener(this);
		ColorButtonOne.setText("Farbe auswählen");
		NameOneOk.setText("Ok?");
		NameOneOk.addActionListener(this);

		NameTwo.setText("Player 2");
		ColorButtonTwo.setBackground(Color.BLUE);
		ColorButtonTwo.addActionListener(this);
		ColorButtonTwo.setText("Farbe auswählen");
		NameTwoOk.setText("Ok?");
		NameTwoOk.addActionListener(this);

		Panel.add(NameOne);
		Panel.add(ColorButtonOne);
		Panel.add(NameOneOk);
		
		Panel.add(NameTwo);
		Panel.add(ColorButtonTwo);
		Panel.add(NameTwoOk);

		Frame.add(Panel);
		Frame.setSize(600, 100);
		Frame.setVisible(true);
		;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == NameOneOk) {
			one.name = NameOne.getText();
			one.color = ColorButtonOne.getBackground();
			NameOne.setEnabled(false);
			Panel.remove(NameOneOk);
			Panel.remove(ColorButtonOne);
			oneOk = true;
			if(oneOk && twoOk){
				Frame.dispose();
				new Spiel(one, two, 1);
			}
		}
		if (e.getSource() == NameTwoOk) {
			two.name = NameTwo.getText();
			two.color = ColorButtonTwo.getBackground();
			NameTwo.setEnabled(false);
			Panel.remove(NameTwoOk);
			Panel.remove(NameTwoOk);
			twoOk = true;
			if(oneOk && twoOk){
				Frame.dispose();
				new Spiel(one, two, 1);
			}
		}
		if (e.getSource() == ColorButtonOne) {
			if (ColorButtonOne.getBackground() == Color.RED)
				ColorButtonOne.setBackground(Color.GREEN);
			else if (ColorButtonOne.getBackground() == Color.GREEN)
				ColorButtonOne.setBackground(Color.BLUE);
			else if (ColorButtonOne.getBackground() == Color.BLUE)
				ColorButtonOne.setBackground(Color.ORANGE);
			else if (ColorButtonOne.getBackground() == Color.ORANGE)
				ColorButtonOne.setBackground(Color.CYAN);
			else if (ColorButtonOne.getBackground() == Color.CYAN)
				ColorButtonOne.setBackground(Color.GRAY);
			else if (ColorButtonOne.getBackground() == Color.GRAY)
				ColorButtonOne.setBackground(Color.PINK);
			else if (ColorButtonOne.getBackground() == Color.PINK)
				ColorButtonOne.setBackground(Color.LIGHT_GRAY);
			else if (ColorButtonOne.getBackground() == Color.LIGHT_GRAY)
				ColorButtonOne.setBackground(Color.YELLOW);
			else if (ColorButtonOne.getBackground() == Color.YELLOW)
				ColorButtonOne.setBackground(Color.RED);
		}
		if (e.getSource() == ColorButtonTwo) {
			if (ColorButtonTwo.getBackground() == Color.RED)
				ColorButtonTwo.setBackground(Color.GREEN);
			else if (ColorButtonTwo.getBackground() == Color.GREEN)
				ColorButtonTwo.setBackground(Color.BLUE);
			else if (ColorButtonTwo.getBackground() == Color.BLUE)
				ColorButtonTwo.setBackground(Color.ORANGE);
			else if (ColorButtonTwo.getBackground() == Color.ORANGE)
				ColorButtonTwo.setBackground(Color.CYAN);
			else if (ColorButtonTwo.getBackground() == Color.CYAN)
				ColorButtonTwo.setBackground(Color.GRAY);
			else if (ColorButtonTwo.getBackground() == Color.GRAY)
				ColorButtonTwo.setBackground(Color.PINK);
			else if (ColorButtonTwo.getBackground() == Color.PINK)
				ColorButtonTwo.setBackground(Color.LIGHT_GRAY);
			else if (ColorButtonTwo.getBackground() == Color.LIGHT_GRAY)
				ColorButtonTwo.setBackground(Color.YELLOW);
			else if (ColorButtonTwo.getBackground() == Color.YELLOW)
				ColorButtonTwo.setBackground(Color.RED);
		}

	}
}
