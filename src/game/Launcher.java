package game;

import java.awt.Color;

public class Launcher{
	
	public static void main(String[] args){
		Player one = new Player(Color.ORANGE);
		Player two = new Player(Color.GREEN);
		new Overview(one, two,0);
	}

}
