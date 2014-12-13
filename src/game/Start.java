package game;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Start implements ActionListener{
	JFrame Frame = new JFrame();
	JPanel Panel = new JPanel();
	Player one;
	Player two;
	
	Start(){
		Frame.setTitle("ProjectF");
		one = new Player(Color.RED);
		two = new Player(Color.BLUE);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
