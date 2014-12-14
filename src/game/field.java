package game;

import javax.swing.JOptionPane;

public class field {
	// [höhe][breite][1-4(0:_, 1:|, 2:/,3:\)]
	// 0:frei, 1:Spielfeldrand, 2:Spieler 1,
	// 3:Spieler 2, 4:Außerhalb des Spielfeldes
	int Balli = 7;
	int Ballj = 5;
	private int player = 0;
	private int[][][] field;

	// Setzen der Umrandung des Spielfeldes
	public field(int first) {
		if (first == 1) {
			player = 2;
		}
		if (first == 2) {
			player = 3;
		};
		
		field = new int[][][]
		{{{4,4,4,4},{4,4,4,4},{4,4,4,4},{4,4,4,4},{4,4,4,4},{4,4,4,4},{4,4,4,4},{4,4,4,4},{4,4,4,4},{4,4,4,4},{4,4,4,4},{4,4,4,4},{4,4,4,4},{4,4,4,4
		}},
		{{4,4,4,4},{4,4,4,4},{1,1,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0},{1,0,0,0},{4,1,4,4},{4,4,4,4
		}},
		{{4,4,4,4},{4,4,4,4},{0,1,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{4,1,4,4},{4,4,4,4
		}},
		{{4,4,4,4},{4,4,4,4},{0,1,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{4,1,4,4},{4,4,4,4
		}},
		{{4,4,4,4},{1,2,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{1,0,0,0},{4,3,4,4
		}},
		{{4,4,4,4},{0,2,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{4,3,4,4
		}},
		{{4,4,4,4},{1,4,4,4},{0,1,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{1,1,4,4},{4,4,4,4
		}},
		{{4,4,4,4},{4,4,4,4},{0,1,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{4,1,4,4},{4,4,4,4
		}},
		{{4,4,4,4},{4,4,4,4},{0,1,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0},{4,1,4,4},{4,4,4,4
		}},
		{{4,4,4,4},{4,4,4,4},{1,4,4,4},{1,4,4,4},{1,4,4,4},{1,4,4,4},{1,4,4,4},{1,4,4,4},{1,4,4,4},{1,4,4,4},{1,4,4,4},{1,4,4,4},{4,4,4,4},{4,4,4,4
		}}};
		
	}

	// Gibt Wert des Feldes zurück
	public int getValue(int i, int j, int k) {
		return field[j][i][k];
	}

	// Liegt der Ball auf dem Punkt (i,j)
	public boolean isBall(int i, int j) {
		if (Balli == i && Ballj == j)
			return true;
		return false;
	}

	// Ist in Schussrichtung schon ein Strich gezogen?
	private boolean isValidShoot(char direction) { //
		if ((direction == 'q' && 0 != this.getValue(Balli - 1, Ballj - 1, 3))
				|| (direction == 'w' && 0 != this.getValue(Balli, Ballj - 1, 1))
				|| (direction == 'e' && 0 != this.getValue(Balli, Ballj - 1, 2))
				|| (direction == 'a' && 0 != this.getValue(Balli - 1, Ballj, 0))
				|| (direction == 'd' && 0 != this.getValue(Balli, Ballj, 0))
				|| (direction == 'y' && 0 != this.getValue(Balli - 1, Ballj, 2))
				|| (direction == 'x' && 0 != this.getValue(Balli, Ballj, 1))
				|| (direction == 'c' && 0 != this.getValue(Balli, Ballj, 3))) {
			JOptionPane.showMessageDialog(null, "Ungültiger Zug!");
			return false;
		}
		return true;
	}

	// Ball wird in angegebene Richtung bewegt und der Strich wird gesetzt
	public boolean shoot(char direction) {
		if (!isValidShoot(direction)) {
			return false;

		} else {
			switch (direction) { // qweadyxc
			case ('q'):
				field[Ballj - 1][Balli - 1][3] = player;
				Balli -= 1;
				Ballj -= 1;
				break;
			case ('w'):
				field[Ballj - 1][Balli][1] = player;
				Ballj -= 1;
				break;
			case ('e'):
				field[Ballj - 1][Balli][2] = player;
				Balli += 1;
				Ballj -= 1;
				break;
			case ('a'):
				field[Ballj][Balli - 1][0] = player;
				Balli -= 1;
				break;
			case ('d'):
				field[Ballj][Balli][0] = player;
				Balli += 1;
				break;
			case ('y'):
				field[Ballj][Balli - 1][2] = player;
				Balli -= 1;
				Ballj += 1;
				break;
			case ('x'):
				field[Ballj][Balli][1] = player;
				Ballj += 1;
				break;
			case ('c'):
				field[Ballj][Balli][3] = player;
				Balli += 1;
				Ballj += 1;
				break;
			}
			again(direction);
			return true;
		}
	}

	// Testet ob der Spieler nochmal ziehen kann
	private void again(char direction) {
		switch (direction) { // qweadyxc
		case ('q'):
			if (field[Ballj][Balli][0] != 0 || field[Ballj][Balli][1] != 0
					|| field[Ballj][Balli - 1][2] != 0
					|| field[Ballj][Balli - 1][0] != 0
					|| field[Ballj - 1][Balli][2] != 0
					|| field[Ballj - 1][Balli][1] != 0
					|| field[Ballj - 1][Balli - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case ('w'):
			if (field[Ballj][Balli][0] != 0 || field[Ballj][Balli][3] != 0
					|| field[Ballj][Balli - 1][2] != 0
					|| field[Ballj][Balli - 1][0] != 0
					|| field[Ballj - 1][Balli][2] != 0
					|| field[Ballj - 1][Balli][1] != 0
					|| field[Ballj - 1][Balli - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case ('e'):
			if (field[Ballj][Balli][0] != 0 || field[Ballj][Balli][1] != 0
					|| field[Ballj][Balli][3] != 0
					|| field[Ballj][Balli - 1][0] != 0
					|| field[Ballj - 1][Balli][2] != 0
					|| field[Ballj - 1][Balli][1] != 0
					|| field[Ballj - 1][Balli - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case ('a'):
			if (field[Ballj][Balli][1] != 0 || field[Ballj][Balli][3] != 0
					|| field[Ballj][Balli - 1][2] != 0
					|| field[Ballj][Balli - 1][0] != 0
					|| field[Ballj - 1][Balli][2] != 0
					|| field[Ballj - 1][Balli][1] != 0
					|| field[Ballj - 1][Balli - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case ('d'):
			if (field[Ballj][Balli][0] != 0 || field[Ballj][Balli][1] != 0
					|| field[Ballj][Balli][3] != 0
					|| field[Ballj][Balli - 1][2] != 0
					|| field[Ballj - 1][Balli][2] != 0
					|| field[Ballj - 1][Balli][1] != 0
					|| field[Ballj - 1][Balli - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case ('y'):
			if (field[Ballj][Balli][0] != 0 || field[Ballj][Balli][1] != 0
					|| field[Ballj][Balli][3] != 0
					|| field[Ballj][Balli - 1][2] != 0
					|| field[Ballj][Balli - 1][0] != 0
					|| field[Ballj - 1][Balli][1] != 0
					|| field[Ballj - 1][Balli - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case ('x'):
			if (field[Ballj][Balli][0] != 0 || field[Ballj][Balli][1] != 0
					|| field[Ballj][Balli][3] != 0
					|| field[Ballj][Balli - 1][2] != 0
					|| field[Ballj][Balli - 1][0] != 0
					|| field[Ballj - 1][Balli][2] != 0
					|| field[Ballj - 1][Balli - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case ('c'):
			if (field[Ballj][Balli][0] != 0 || field[Ballj][Balli][1] != 0
					|| field[Ballj][Balli][3] != 0
					|| field[Ballj][Balli - 1][2] != 0
					|| field[Ballj][Balli - 1][0] != 0
					|| field[Ballj - 1][Balli][2] != 0
					|| field[Ballj - 1][Balli][1] != 0) {
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
	public int isWinner() {

		if (Balli == 1) {
			return 2;
		}
		if (Balli == 13) {
			return 1;
		}
		if (field[Ballj][Balli][0] != 0 && field[Ballj][Balli][1] != 0
				&& field[Ballj][Balli][3] != 0
				&& field[Ballj][Balli - 1][2] != 0
				&& field[Ballj][Balli - 1][0] != 0
				&& field[Ballj - 1][Balli][2] != 0
				&& field[Ballj - 1][Balli][1] != 0
				&& field[Ballj - 1][Balli - 1][3] != 0) {
			if (player == 2) {
				return 2;
			}
			if (player == 3) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
	
	public int getPlayer() {
		return player;
	}

}
