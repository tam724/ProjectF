package game;

import java.awt.Color;

public class Player {
	Color color;
	int score;
	int intern_id;
	boolean intern_winner = false;
	String name;
	
	Player(Color c, String name){
		this.name = name;
		color = c;
	}

}
