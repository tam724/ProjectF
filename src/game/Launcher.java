package game;

import java.awt.Color;

public class Launcher{
	
	public static void main(String[] args){
		Player one = new Player(Color.ORANGE, "tam");
		Player two = new Player(Color.GREEN, "second");
		//new Overview(one, two,0);
		new Start();
	}

}
