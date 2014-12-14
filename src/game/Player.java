package game;

import java.awt.Color;

public class Player {
	Color color;
	int score;
	int id;
	static int players = 0;
	String name;
	
	Player(Color c, String name){
		this.name = name;
		id = players;
		color = c;
		players++;
	}

}
