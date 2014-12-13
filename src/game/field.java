package game;

public class field {

	private int field[][][] = new int[14][10][4]; // [breite][höhe][1-4(0:_, 1:|, 2:/,
											// 3:\)]
											// 0:frei, 1:Umrandung, 2:Spieler 1,
											// 3:Spieler 2;
	int Balli = 7;
	int Ballj = 5;
	private int player = 0;
	
	// Setzen der Umrandung des Spielfeldes
	public field(int first) {
		if(first == 1){
			player = 2;
		}
		if(first == 2){
			player = 3;
		}
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 4; k++) {
					field[i][j][k] = 0;
					if (j == 0 || j == 9) {
						field[i][j][k] = 1;
					}
					if (j == 1) {
						if (i == 0 || i == 1) {
							field[i][j][k] = 1;
						} else if (i == 2) {
							field[i][j][0] = 1;
							field[i][j][1] = 1;
						} else if (i == 12 || i == 13) {
							field[i][j][k] = 1;
						} else {
							field[i][j][0] = 1;
						}
					}
					if (j == 2 || j == 3 || j == 6 || j == 7 || j == 8) {
						if (i == 0 || i == 1 || i == 12 || i == 13) {
							field[i][j][k] = 1;
						}
						if (i == 2) {
							field[i][j][1] = 1;
						}
						if (i == 12) {
							field[i][j][k] = 1;
						}
					}
					if (j == 4) {
						if (i == 0 || i == 13) {
							field[i][j][k] = 1;
						}
						if (i == 1) {
							field[i][j][1] = 1;
							field[i][j][0] = 1;
						}
						if (i == 12) {
							field[i][j][0] = 1;
						}
					}
					if (j == 5) {
						if (i == 0 || i == 13) {
							field[i][j][k] = 1;
						}
						if (i == 1) {
							field[i][j][1] = 1;
						}

					}
				}
			}
		}
	}

	// Gibt wert des Feldes zurück
	public int getValue(int i, int j, int k) {
		return field[i][j][k];
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
				field[Balli - 1][Ballj - 1][3] = player;
				Balli -= 1;
				Ballj -= 1;
				break;
			case ('w'):
				field[Balli][Ballj - 1][1] = player;
				Ballj -= 1;
				break;
			case ('e'):
				field[Balli][Ballj - 1][2] = player;
				Balli += 1;
				Ballj -= 1;
				break;
			case ('a'):
				field[Balli - 1][Ballj][0] = player;
				Balli -= 1;
				break;
			case ('d'):
				field[Balli][Ballj][0] = player;
				Balli += 1;
				break;
			case ('y'):
				field[Balli - 1][Ballj][2] = player;
				Balli -= 1;
				Ballj += 1;
				break;
			case ('x'):
				field[Balli][Ballj][1] = player;
				Ballj += 1;
				break;
			case ('c'):
				field[Balli][Ballj][3] = player;
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
			if (field[Balli][Ballj][0] != 0
					|| field[Balli][Ballj][1] != 0
					|| field[Balli - 1][Ballj][2] != 0
					|| field[Balli - 1][Ballj][0] != 0
					|| field[Balli][Ballj - 1][2] != 0
					|| field[Balli][Ballj - 1][1] != 0
					|| field[Balli - 1][Ballj - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case ('w'):
			if (field[Balli][Ballj][0] != 0
					|| field[Balli][Ballj][3] != 0
					|| field[Balli - 1][Ballj][2] != 0
					|| field[Balli - 1][Ballj][0] != 0
					|| field[Balli][Ballj - 1][2] != 0
					|| field[Balli][Ballj - 1][1] != 0
					|| field[Balli - 1][Ballj - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case ('e'):
			if (field[Balli][Ballj][0] != 0
					|| field[Balli][Ballj][1] != 0
					|| field[Balli][Ballj][3] != 0
					|| field[Balli - 1][Ballj][0] != 0
					|| field[Balli][Ballj - 1][2] != 0
					|| field[Balli][Ballj - 1][1] != 0
					|| field[Balli - 1][Ballj - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case ('a'):
			if (field[Balli][Ballj][1] != 0 || field[Balli][Ballj][3] != 0
					|| field[Balli - 1][Ballj][2] != 0
					|| field[Balli - 1][Ballj][0] != 0
					|| field[Balli][Ballj - 1][2] != 0
					|| field[Balli][Ballj - 1][1] != 0
					|| field[Balli - 1][Ballj - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case ('d'):
			if (field[Balli][Ballj][0] != 0
					|| field[Balli][Ballj][1] != 0
					|| field[Balli][Ballj][3] != 0
					|| field[Balli - 1][Ballj][2] != 0
					|| field[Balli][Ballj - 1][2] != 0
					|| field[Balli][Ballj - 1][1] != 0
					|| field[Balli - 1][Ballj - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case ('y'):
			if (field[Balli][Ballj][0] != 0 || field[Balli][Ballj][1] != 0
					|| field[Balli][Ballj][3] != 0
					|| field[Balli - 1][Ballj][2] != 0
					|| field[Balli - 1][Ballj][0] != 0
					|| field[Balli][Ballj - 1][1] != 0
					|| field[Balli - 1][Ballj - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case ('x'):
			if (field[Balli][Ballj][0] != 0 || field[Balli][Ballj][1] != 0
					|| field[Balli][Ballj][3] != 0
					|| field[Balli - 1][Ballj][2] != 0
					|| field[Balli - 1][Ballj][0] != 0
					|| field[Balli][Ballj - 1][2] != 0
					|| field[Balli - 1][Ballj - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case ('c'):
			if (field[Balli][Ballj][0] != 0 || field[Balli][Ballj][1] != 0
					|| field[Balli][Ballj][3] != 0
					|| field[Balli - 1][Ballj][2] != 0
					|| field[Balli - 1][Ballj][0] != 0
					|| field[Balli][Ballj - 1][2] != 0
					|| field[Balli][Ballj - 1][1] != 0
			) {
				return;
			} else {
				break;
			}
		}
		if(player== 2){
			player = 3;
		}
		else if(player == 3){
			player = 2;
		}
	}

	// Testet ob der Ball im Tor ist
	public int isWinner() {
		if (field[Balli][Ballj][0] != 0 && field[Balli][Ballj][1] != 0
				&& field[Balli][Ballj][3] != 0
				&& field[Balli - 1][Ballj][2] != 0
				&& field[Balli - 1][Ballj][0] != 0
				&& field[Balli][Ballj - 1][2] != 0
				&& field[Balli][Ballj - 1][1] != 0
				&& field[Balli - 1][Ballj - 1][3] != 0) {
			return player;
		}
		if (Balli == 1) {
			return 1;
		}
		if (Balli == 13) {
			return 2;
		} else {
			return 0;
		}
	}
	
	public int getPlayer(){
		return player;
	}
	
}
