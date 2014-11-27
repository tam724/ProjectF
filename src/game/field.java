package game;

public class field {

	int field[][][] = new int[14][10][4]; // [breite][höhe][1-4(0:_, 1:|, 2:/,
											// 3:\)]
											// 0:frei, 1:Umrandung, 2:Spieler 1,
											// 3:Spieler 2;
	int Balli = 7;
	int Ballj = 5;

	char pointer = 0;

	public field() {
		generateNewField();
	}

	// Setzen der Umrandung des Spielfeldes
	private void generateNewField() {
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

	// Ausgabe für Konsolenversion geht nicht mehr da mehrere Spieler
	/*
	 * public void drawfield() { boolean spaltegerade = true; boolean
	 * zeilegerade = true; for (int j = 0; j < 9; j++) { for (int n = 0; n < 2;
	 * n++) { for (int i = 0; i < 13; i++) { for (int m = 0; m < 2; m++) { if
	 * (zeilegerade && spaltegerade) { if (isBall(i, j)) {
	 * System.out.print("·"); } else { System.out.print("+"); } } else if
	 * (zeilegerade && !spaltegerade) { if (field[i][j][0] == 1) {
	 * System.out.print("-"); } else { System.out.print(" "); } } else if
	 * (!zeilegerade && spaltegerade) { if (field[i][j][1] == 1) {
	 * System.out.print("|"); } else { System.out.print(" "); } } else if
	 * (!zeilegerade && !spaltegerade) { if (field[i][j][2] == 1 &&
	 * field[i][j][3] == 0) { System.out.print("/"); } else if (field[i][j][2]
	 * == 0 && field[i][j][3] == 1) { System.out.print("\\"); } else if
	 * (field[i][j][2] == 1 && field[i][j][3] == 1) { System.out.print("x"); }
	 * else { System.out.print(" "); } } spaltegerade = !spaltegerade; } }
	 * System.out.println(); zeilegerade = !zeilegerade; } } }
	 */

	// Abfrage ob ein Wert gesetzt ist
	public boolean isGesetzt(int i, int j, int k) {
		if (field[i][j][k] == 1 || field[i][j][k] == 2 || field[i][j][k] == 3) {
			return true;
		}
		return false;
	}

	//Gibt wert des Feldes zurück
	public int getValue(int i, int j, int k){
		return field[i][j][k];
	}
	
	// Abfrabe ob es noch einen Ausweg gibt
	// Sind alle Striche um den Ball herum gezogen?
	public boolean isEnd() {
		if (field[Balli][Ballj][0] != 0 && field[Balli][Ballj][1] != 0
				&& field[Balli][Ballj][3] != 0
				&& field[Balli - 1][Ballj][2] != 0
				&& field[Balli - 1][Ballj][0] != 0
				&& field[Balli][Ballj - 1][2] != 0
				&& field[Balli][Ballj - 1][1] != 0
				&& field[Balli - 1][Ballj - 1][3] != 0) {
			return true;
		} else {
			return false;
		}
	}

	//
	
	// Liegt der Ball auf dem Punkt (i,j)
	public boolean isBall(int i, int j) {
		if (Balli == i && Ballj == j)
			return true;
		return false;
	}

	// Ist in Schussrichtung schon ein Strich gezogen?
	public boolean isValidShoot(char direction) { //
		if ((direction == 'q' && this.isGesetzt(Balli - 1, Ballj - 1, 3))
				|| (direction == 'w' && this.isGesetzt(Balli, Ballj - 1, 1))
				|| (direction == 'e' && this.isGesetzt(Balli, Ballj - 1, 2))
				|| (direction == 'a' && this.isGesetzt(Balli - 1, Ballj, 0))
				|| (direction == 'd' && this.isGesetzt(Balli, Ballj, 0))
				|| (direction == 'y' && this.isGesetzt(Balli - 1, Ballj, 2))
				|| (direction == 'x' && this.isGesetzt(Balli, Ballj, 1))
				|| (direction == 'c' && this.isGesetzt(Balli, Ballj, 3))) {
			return false;
		}
		return true;
	}

	// Ball wird in angegebene Richtung bewegt und der Strich wird gesetzt
	public void setShoot(char direction, int player) {
		switch (direction) { // qweadyxc
		case ('q'):
			field[Balli - 1][Ballj - 1][3] = player;
			break;
		case ('w'):
			field[Balli][Ballj - 1][1] = player;
			break;
		case ('e'):
			field[Balli][Ballj - 1][2] = player;
			break;
		case ('a'):
			field[Balli - 1][Ballj][0] = player;
			break;
		case ('d'):
			field[Balli][Ballj][0] = player;
			break;
		case ('y'):
			field[Balli - 1][Ballj][2] = player;
			break;
		case ('x'):
			field[Balli][Ballj][1] = player;
			break;
		case ('c'):
			field[Balli][Ballj][3] = player;
			break;
		}
	}

	public void moveBall(char direction) {
		switch (direction) { // qweadyxc
		case ('q'):
			Balli -= 1;
			Ballj -= 1;
			break;
		case ('w'):
			Ballj -= 1;
			break;
		case ('e'):
			Balli += 1;
			Ballj -= 1;
			break;
		case ('a'):
			Balli -= 1;
			break;
		case ('d'):
			Balli += 1;
			break;
		case ('y'):
			Balli -= 1;
			Ballj += 1;
			break;
		case ('x'):
			Ballj += 1;
			break;
		case ('c'):
			Balli += 1;
			Ballj += 1;
			break;
		}
	}

	// Testet ob der Spieler nochmal ziehen kann
	public boolean isTaken(char direction) {
		switch (direction) { // qweadyxc
		case ('q'):
			if (	field[Balli][Ballj][0] != 0 
					|| field[Balli][Ballj][1] != 0
	//				|| field[Balli][Ballj][3] != 0
					|| field[Balli - 1][Ballj][2] != 0
					|| field[Balli - 1][Ballj][0] != 0
					|| field[Balli][Ballj - 1][2] != 0
					|| field[Balli][Ballj - 1][1] != 0
					|| field[Balli - 1][Ballj - 1][3] != 0
					) {
				return true;
			} else {
				return false;
			}
		case ('w'):
				if (	field[Balli][Ballj][0] != 0 
	//			|| field[Balli][Ballj][1] != 0
				|| field[Balli][Ballj][3] != 0
				|| field[Balli - 1][Ballj][2] != 0
				|| field[Balli - 1][Ballj][0] != 0
				|| field[Balli][Ballj - 1][2] != 0
				|| field[Balli][Ballj - 1][1] != 0
				|| field[Balli - 1][Ballj - 1][3] != 0
				) {
			return true;
		} else {
			return false;
		}
		case ('e'):
			if (	field[Balli][Ballj][0] != 0 
					|| field[Balli][Ballj][1] != 0
					|| field[Balli][Ballj][3] != 0
			//		|| field[Balli - 1][Ballj][2] != 0
					|| field[Balli - 1][Ballj][0] != 0
					|| field[Balli][Ballj - 1][2] != 0
					|| field[Balli][Ballj - 1][1] != 0
					|| field[Balli - 1][Ballj - 1][3] != 0
					) {
				return true;
			} else {
				return false;
			}
		case ('a'):
			if (	//field[Balli][Ballj][0] != 0 
					 field[Balli][Ballj][1] != 0
					|| field[Balli][Ballj][3] != 0
					|| field[Balli - 1][Ballj][2] != 0
					|| field[Balli - 1][Ballj][0] != 0
					|| field[Balli][Ballj - 1][2] != 0
					|| field[Balli][Ballj - 1][1] != 0
					|| field[Balli - 1][Ballj - 1][3] != 0
					) {
				return true;
			} else {
				return false;
			}
		case ('d'):
			if (	field[Balli][Ballj][0] != 0 
					|| field[Balli][Ballj][1] != 0
					|| field[Balli][Ballj][3] != 0
					|| field[Balli - 1][Ballj][2] != 0
			//		|| field[Balli - 1][Ballj][0] != 0
					|| field[Balli][Ballj - 1][2] != 0
					|| field[Balli][Ballj - 1][1] != 0
					|| field[Balli - 1][Ballj - 1][3] != 0
					) {
				return true;
			} else {
				return false;
			}
		case ('y'):
			if (	field[Balli][Ballj][0] != 0 
					|| field[Balli][Ballj][1] != 0
					|| field[Balli][Ballj][3] != 0
					|| field[Balli - 1][Ballj][2] != 0
					|| field[Balli - 1][Ballj][0] != 0
				//	|| field[Balli][Ballj - 1][2] != 0
					|| field[Balli][Ballj - 1][1] != 0
					|| field[Balli - 1][Ballj - 1][3] != 0
					) {
				return true;
			} else {
				return false;
			}
		case ('x'):
			if (	field[Balli][Ballj][0] != 0 
					|| field[Balli][Ballj][1] != 0
					|| field[Balli][Ballj][3] != 0
					|| field[Balli - 1][Ballj][2] != 0
					|| field[Balli - 1][Ballj][0] != 0
					|| field[Balli][Ballj - 1][2] != 0
			//		|| field[Balli][Ballj - 1][1] != 0
					|| field[Balli - 1][Ballj - 1][3] != 0
					) {
				return true;
			} else {
				return false;
			}
		case ('c'):
			if (	field[Balli][Ballj][0] != 0 
					|| field[Balli][Ballj][1] != 0
					|| field[Balli][Ballj][3] != 0
					|| field[Balli - 1][Ballj][2] != 0
					|| field[Balli - 1][Ballj][0] != 0
					|| field[Balli][Ballj - 1][2] != 0
					|| field[Balli][Ballj - 1][1] != 0
				//	|| field[Balli - 1][Ballj - 1][3] != 0
					) {
				return true;
			} else {
				return false;
			}
		default:
			return false;
		}
	}

	// Testet ob der Ball im Tor ist
	public int isGoooooool() {
		if (Balli == 1) {
			return 1;
		}
		if (Balli == 13) {
			return 2;
		} else {
			return 0;
		}
	}
}
