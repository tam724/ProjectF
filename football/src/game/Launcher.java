package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Launcher {
	public static void main(String[] args){
		
		Player Left = new Player(1);
		Player Right = new Player(2);
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		JPanel p = new JPanel();
		f.setSize(600, 600);
		f.add(p);
		while (true){
			if (!Left.ok && !Right.ok){
				JButton Player1 = new JButton();
				JButton Player2 = new JButton();
				Player1.setText("Player 1 Ready?");
				Player2.setText("Player 2 Ready?");
				Player1.addActionListener(new ActionListener() {
					  public void actionPerformed(ActionEvent evt) {
						    Left.setOk();
						  }
						});
				p.add(Player1);
				p.add(Player2);
				f.setVisible(true);
			}
			if (Left.ok && Right.ok){
				
			}
		}
	
	}
}
