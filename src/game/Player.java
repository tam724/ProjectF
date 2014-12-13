package game;

import java.awt.Color;

public class Player {
	Color color;
	int score;
	int id;
	static int players = 0;
	
	Player(Color c){
		id = players;
		color = c;
		players++;
	}

}
