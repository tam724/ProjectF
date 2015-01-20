package game;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class field {
	
	//DIRECTIONS TO SHOOT
	static final int UP = 0;
	static final int UP_RIGHT = 1;
	static final int RIGHT = 2;
	static final int DOWN_RIGHT = 3;
	static final int DOWN = 4;
	static final int DOWN_LEFT = 5;
	static final int LEFT = 6;
	static final int UP_LEFT = 7;
	
	//VALUES OF THE ARRAY
	static final int FREE = 0;
	static final int BORDER = 1;
	static final int PLAYER_ONE = 2;
	static final int PLAYER_TWO = 3;
	static final int OUT_OF_GAME = 4;

	private int[][][] field;	// [höhe][breite][1-4(0:_, 1:|, 2:/,3:\)]
	int Ballx = 7;
	int Bally = 5;
	private int player = 2;
	private int prev_player = 0;

	private Player one;
	private Player two;
	private static field testField;
	private static int max_turn_quality = 0;
	private static int[] quality_of_direction = {0,-1,-1,-1,0,1,1,1};
	public static ArrayList<String> pList = new ArrayList<String>();
	// Setzen der Umrandung des Spielfeldes
	public field(Player beginner, Player second) {
		beginner.intern_id = 2;
		one = beginner;
		second.intern_id = 3;
		two = second;

		field = new int[][][] {
				{ { 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 4, 4, 4, 4 },
						{ 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 4, 4, 4, 4 },
						{ 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 4, 4, 4, 4 },
						{ 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 4, 4, 4, 4 },
						{ 4, 4, 4, 4 }, { 4, 4, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 1, 1, 0, 0 },
						{ 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 },
						{ 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 },
						{ 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 },
						{ 4, 1, 4, 4 }, { 4, 4, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 0, 1, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 4, 1, 4, 4 }, { 4, 4, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 0, 1, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 4, 1, 4, 4 }, { 4, 4, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 2, 2, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 3, 0, 0, 0 }, { 4, 3, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 0, 2, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 4, 3, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 2, 4, 4, 4 }, { 0, 1, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 3, 1, 4, 4 }, { 4, 4, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 0, 1, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 4, 1, 4, 4 }, { 4, 4, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 0, 1, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 4, 1, 4, 4 }, { 4, 4, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 1, 4, 4, 4 },
						{ 1, 4, 4, 4 }, { 1, 4, 4, 4 }, { 1, 4, 4, 4 },
						{ 1, 4, 4, 4 }, { 1, 4, 4, 4 }, { 1, 4, 4, 4 },
						{ 1, 4, 4, 4 }, { 1, 4, 4, 4 }, { 1, 4, 4, 4 },
						{ 4, 4, 4, 4 }, { 4, 4, 4, 4 } } };

	}

	public field(field toCopy) {
		this.Ballx = toCopy.Ballx;
		this.Bally = toCopy.Bally;
		this.player = toCopy.player;
		this.field = new int[10][14][4];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 14; j++) {
				for (int k = 0; k < 4; k++) {

					this.field[i][j][k] = toCopy.field[i][j][k];
				}
			}
		}
	}

	// Gibt Wert des Feldes zurück
	public int getValue(int i, int j, int k) {
		return field[j][i][k];
	}

	// Liegt der Ball auf dem Punkt (i,j)
	public boolean isBall(int i, int j) {
		if (Ballx == i && Bally == j)
			return true;
		return false;
	}

	// Ist in Schussrichtung schon ein Strich gezogen?
	private boolean isValidShoot(int direction) { //
		if ((direction == UP_LEFT && 0 != this.getValue(Ballx - 1, Bally - 1, 3))
				|| (direction == UP && 0 != this.getValue(Ballx, Bally - 1, 1))
				|| (direction == UP_RIGHT && 0 != this.getValue(Ballx, Bally - 1, 2))
				|| (direction == LEFT && 0 != this.getValue(Ballx - 1, Bally, 0))
				|| (direction == RIGHT && 0 != this.getValue(Ballx, Bally, 0))
				|| (direction == DOWN_LEFT && 0 != this.getValue(Ballx - 1, Bally, 2))
				|| (direction == DOWN && 0 != this.getValue(Ballx, Bally, 1))
				|| (direction == DOWN_RIGHT && 0 != this.getValue(Ballx, Bally, 3))) {
			return false;
		}
		return true;
	}

	// Ball wird in angegebene Richtung bewegt und der Strich wird gesetzt
	public boolean shoot(int direction) {
		if (!isValidShoot(direction)) {
			JOptionPane.showMessageDialog(null, "Ungültiger Zug!");
			return false;

		} else {
			switch (direction) { // qweadyxc
			case (UP_LEFT):
				field[Bally - 1][Ballx - 1][3] = player;
				Ballx -= 1;
				Bally -= 1;
				break;
			case (UP):
				field[Bally - 1][Ballx][1] = player;
				Bally -= 1;
				break;
			case (UP_RIGHT):
				field[Bally - 1][Ballx][2] = player;
				Ballx += 1;
				Bally -= 1;
				break;
			case (LEFT):
				field[Bally][Ballx - 1][0] = player;
				Ballx -= 1;
				break;
			case (RIGHT):
				field[Bally][Ballx][0] = player;
				Ballx += 1;
				break;
			case (DOWN_LEFT):
				field[Bally][Ballx - 1][2] = player;
				Ballx -= 1;
				Bally += 1;
				break;
			case (DOWN):
				field[Bally][Ballx][1] = player;
				Bally += 1;
				break;
			case (DOWN_RIGHT):
				field[Bally][Ballx][3] = player;
				Ballx += 1;
				Bally += 1;
				break;
			}
			prev_player = player;
			again(direction);
			return true;
		}
	}

	public boolean goBack(int direction, int tempPlayer) {
		switch (direction) { // qweadyxc
		case (UP_LEFT):
			Ballx += 1;
			Bally += 1;
			field[Bally - 1][Ballx - 1][3] = 0;

			break;
		case (UP):
			Bally += 1;

			field[Bally - 1][Ballx][1] = 0;
			break;
		case (UP_RIGHT):
			Ballx -= 1;
			Bally += 1;
			field[Bally - 1][Ballx][2] = 0;

			break;
		case (LEFT):
			Ballx += 1;
			field[Bally][Ballx - 1][0] = 0;

			break;
		case (RIGHT):
			Ballx -= 1;
			field[Bally][Ballx][0] = 0;

			break;
		case (DOWN_LEFT):
			Ballx += 1;
			Bally -= 1;
			field[Bally][Ballx - 1][2] = 0;

			break;
		case (DOWN):
			Bally -= 1;
			field[Bally][Ballx][1] = 0;

			break;
		case (DOWN_RIGHT):
			Ballx -= 1;
			Bally -= 1;
			field[Bally][Ballx][3] = 0;

			break;
		}
		player = 3;
		return true;
	}

	// Testet ob der Spieler nochmal ziehen kann
	private void again(int direction) {
		switch (direction) { // qweadyxc
		case (UP_LEFT):
			if (field[Bally][Ballx][0] != 0 || field[Bally][Ballx][1] != 0
					|| field[Bally][Ballx - 1][2] != 0
					|| field[Bally][Ballx - 1][0] != 0
					|| field[Bally - 1][Ballx][2] != 0
					|| field[Bally - 1][Ballx][1] != 0
					|| field[Bally - 1][Ballx - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case (UP):
			if (field[Bally][Ballx][0] != 0 || field[Bally][Ballx][3] != 0
					|| field[Bally][Ballx - 1][2] != 0
					|| field[Bally][Ballx - 1][0] != 0
					|| field[Bally - 1][Ballx][2] != 0
					|| field[Bally - 1][Ballx][1] != 0
					|| field[Bally - 1][Ballx - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case (UP_RIGHT):
			if (field[Bally][Ballx][0] != 0 || field[Bally][Ballx][1] != 0
					|| field[Bally][Ballx][3] != 0
					|| field[Bally][Ballx - 1][0] != 0
					|| field[Bally - 1][Ballx][2] != 0
					|| field[Bally - 1][Ballx][1] != 0
					|| field[Bally - 1][Ballx - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case (LEFT):
			if (field[Bally][Ballx][1] != 0 || field[Bally][Ballx][3] != 0
					|| field[Bally][Ballx - 1][2] != 0
					|| field[Bally][Ballx - 1][0] != 0
					|| field[Bally - 1][Ballx][2] != 0
					|| field[Bally - 1][Ballx][1] != 0
					|| field[Bally - 1][Ballx - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case (RIGHT):
			if (field[Bally][Ballx][0] != 0 || field[Bally][Ballx][1] != 0
					|| field[Bally][Ballx][3] != 0
					|| field[Bally][Ballx - 1][2] != 0
					|| field[Bally - 1][Ballx][2] != 0
					|| field[Bally - 1][Ballx][1] != 0
					|| field[Bally - 1][Ballx - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case (DOWN_LEFT):
			if (field[Bally][Ballx][0] != 0 || field[Bally][Ballx][1] != 0
					|| field[Bally][Ballx][3] != 0
					|| field[Bally][Ballx - 1][2] != 0
					|| field[Bally][Ballx - 1][0] != 0
					|| field[Bally - 1][Ballx][1] != 0
					|| field[Bally - 1][Ballx - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case (DOWN):
			if (field[Bally][Ballx][0] != 0 || field[Bally][Ballx][1] != 0
					|| field[Bally][Ballx][3] != 0
					|| field[Bally][Ballx - 1][2] != 0
					|| field[Bally][Ballx - 1][0] != 0
					|| field[Bally - 1][Ballx][2] != 0
					|| field[Bally - 1][Ballx - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case (DOWN_RIGHT):
			if (field[Bally][Ballx][0] != 0 || field[Bally][Ballx][1] != 0
					|| field[Bally][Ballx][3] != 0
					|| field[Bally][Ballx - 1][2] != 0
					|| field[Bally][Ballx - 1][0] != 0
					|| field[Bally - 1][Ballx][2] != 0
					|| field[Bally - 1][Ballx][1] != 0) {
				return;
			} else {
				break;
			}
		}
		if (player == 2) {
			player = 3;
		} else if (player == 3) {
			player = 2;
		}
	}

	// Testet ob der Ball im Tor ist
	public boolean isWinner(Player test) {

		if (Ballx == 1) {
			two.intern_winner= true;
		}
		if (Ballx == 13) {
			one.intern_winner=true;
		}
		if (field[Bally][Ballx][0] != 0 && field[Bally][Ballx][1] != 0
				&& field[Bally][Ballx][3] != 0
				&& field[Bally][Ballx - 1][2] != 0
				&& field[Bally][Ballx - 1][0] != 0
				&& field[Bally - 1][Ballx][2] != 0
				&& field[Bally - 1][Ballx][1] != 0
				&& field[Bally - 1][Ballx - 1][3] != 0) {
			if (player == 2) {
				one.intern_winner=true;
			}
			if (player == 3) {
				two.intern_winner = true;
			}
		}
		if(test == one && one.intern_winner==true){
			return true;
		}
		else if(test == two && two.intern_winner == true){
			return true;
		}
		return false;
	}

	public int getPlayer() {
		return player;
	}
	public int getPrev_Player() {
		return prev_player;
	}

	// KI
	public String getBestShoot() {
		String AI_shoot;

		testField = new field(this);
		pList.clear();
		max_turn_quality = -30;
		testDirections("", 0);
		Random random = new Random();
		AI_shoot = pList.get(random.nextInt((pList.size()-1)-0+1));
		System.out.println(max_turn_quality);
		System.out.println(pList.toString());
		return AI_shoot;
	}

	private void testDirections(String turn, int quality) {
		int temp_quality;
		int ball_quality = Ballx;
		boolean goal = false;
		for(int i = 0; i<8;i++){
			temp_quality = quality;
			//Durchläuft alle 8 Richtungen
			if (testField.isValidShoot(i)) {
				//Wenn ich in diese Richtung spielen kann
				testField.shoot(i);
				turn = turn + i;
				temp_quality += quality_of_direction[i];
				if(ball_quality-temp_quality == 1 || goal == true){
					pList.clear();
					pList.add(turn);
					System.out.println("Ich kann ein Tor schießen");
					return;
				}
				if(ball_quality-temp_quality == 13){
					System.out.println("Oh nein, ich schieße kein Eigentor!");
					return;
				}
				if (testField.player == 3) {
					//Wenn der Spieler nochmal an der Reihe ist -> Rekursion
					testDirections(turn, temp_quality);
				} else {
					//Wenn der Spieler nicht mehr an der Reihe ist -> Maximum testen
					if(max_turn_quality < temp_quality){
						//Wenn aktuell getesteter Zug besser als vorherige ist
						pList.clear();
						pList.add(turn);
						max_turn_quality = temp_quality;
					}
					else if(max_turn_quality == temp_quality){
						//Wenn der beste und der aktuelle gleich gut sind
						pList.add(turn);
					}
					
				}
				turn = turn.substring(0, turn.length() - 1);
				testField.goBack(i,3);
			}
		}
	}
}