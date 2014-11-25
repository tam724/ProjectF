package game;

import java.util.Scanner;

public class field {
	private static final Scanner SCANNER = new Scanner(System.in);
	int field[][][] = new int[14][10][4]; // [breite][höhe][1-4(0:_, 1:|, 2:/,
											// 3:\)]
											// 0:frei, 1:gesetzt
	ball B = new ball();

	public field() {
		generateNewField();
	}

	private void generateNewField() {
		for (int i = 0; i < 14; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 4; k++) {
					field[i][j][k] = 0;
					if (j == 0||j==9) {
						field[i][j][k] = 1;
					}
					if (j == 1) {
						if (i == 0 || i == 1) {
							field[i][j][k] = 1;
						} else if (i == 2) {
							field[i][j][0] = 1;
							field[i][j][1] = 1;
						}
						else if (i==12||i==13){
							field[i][j][k] =1;
						}
						else{
							field[i][j][0]=1;
						}
					}
					if (j == 2|| j==3||j==6||j==7||j==8) {
						if (i == 0||i==1||i==12||i==13) {
							field[i][j][k] = 1;
						}
						if (i == 2) {
							field[i][j][1] = 1;
						}
						if (i == 12) {
							field[i][j][k] = 1;
						}
					}
					if(j==4){
						if(i==0||i==13){
							field[i][j][k]=1;
						}
						if(i==1){
							field[i][j][1]=1;
							field[i][j][0]=1;
						}
						if(i==12){
							field[i][j][0] = 1;
						}
					}
					if (j == 5) {
						if (i == 0||i==13) {
							field[i][j][k] = 1;
						}
						if(i==1){
							field[i][j][1]=1;
						}
						
					}	
				}
			}
		}
	}

	public void drawfield() {
		boolean spaltegerade = true;
		boolean zeilegerade = true;
		for (int j = 0; j < 9; j++) {
			for (int n = 0; n < 2; n++) {
				for (int i = 0; i < 13; i++) {
					for (int m = 0; m < 2; m++) {
						if (zeilegerade && spaltegerade) {
							if (B.isBall(i, j)) {
								System.out.print("·");
							} else {
								System.out.print("+");
							}
						} else if (zeilegerade && !spaltegerade) {
							if (field[i][j][0] == 1) {
								System.out.print("-");
							} else {
								System.out.print(" ");
							}
						} else if (!zeilegerade && spaltegerade) {
							if (field[i][j][1] == 1) {
								System.out.print("|");
							} else {
								System.out.print(" ");
							}
						} else if (!zeilegerade && !spaltegerade) {
							if (field[i][j][2] == 1 && field[i][j][3] == 0) {
								System.out.print("/");
							} else if (field[i][j][2] == 0
									&& field[i][j][3] == 1) {
								System.out.print("\\");
							} else if (field[i][j][2] == 1
									&& field[i][j][3] == 1) {
								System.out.print("x");
							} else {
								System.out.print(" ");
							}
						}
						spaltegerade = !spaltegerade;
					}
				}
				System.out.println();
				zeilegerade = !zeilegerade;
			}
		}
	}

	public boolean isGesetzt(int i, int j, int k) {
		if (field[i][j][k] == 1) {
			return true;
		}
		return false;
	}
	
	public boolean nochmal(){
		int i = B.i;
		int j = B.j;
		if((this.isGesetzt(i - 1, j - 1, 3))||
				(this.isGesetzt(i, j - 1, 1))||
				(this.isGesetzt(i, j - 1, 2))||
				(this.isGesetzt(i - 1, j, 0))||
				(this.isGesetzt(i, j, 0))||
				(this.isGesetzt(i - 1, j, 2))||
				(this.isGesetzt(i, j, 1))||
				(this.isGesetzt(i, j, 3))){
			return true;
		}
		return false;
	}

	public boolean isEnd() {
		int i = B.i;
		int j = B.j;
		if (field[i][j][0] == 1 && field[i][j][1] == 1 && field[i][j][3] == 1
				&& field[i - 1][j][2] == 1 && field[i - 1][j][0] == 1
				&& field[i][j - 1][2] == 1 && field[i][j - 1][1] == 1
				&& field[i - 1][j - 1][3] == 1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBall(int i, int j) {
		if (B.i == i && B.j == j)
			return true;
		return false;
	}

	public boolean isValidShoot(char direction) { //
		int i = B.i;
		int j = B.j;
		if((direction=='q'&&this.isGesetzt(i - 1, j - 1, 3))||
				(direction == 'w' &&this.isGesetzt(i, j - 1, 1))||
				(direction== 'e'&&this.isGesetzt(i, j - 1, 2))||
				(direction =='a'&&this.isGesetzt(i - 1, j, 0))||
				(direction == 'd'&&this.isGesetzt(i, j, 0))||
				(direction =='y'&&this.isGesetzt(i - 1, j, 2))||
				(direction =='x'&&this.isGesetzt(i, j, 1))||
				(direction =='c'&&this.isGesetzt(i, j, 3))){
					return false;
				}
			return true;
		}


	public void moveball(char direction) {
		int i = B.i;
		int j = B.j;
		switch (direction) { // qweadyxc
		case ('q'):
			field[i - 1][j - 1][3] = 1;
			break;
		case ('w'):
			field[i][j - 1][1] = 1;
			break;
		case ('e'):
			field[i][j - 1][2] = 1;
			break;
		case ('a'):
			field[i - 1][j][0] = 1;
			break;
		case ('d'):
			field[i][j][0] = 1;
			break;
		case ('y'):
			field[i - 1][j][2] = 1;
			break;
		case ('x'):
			field[i][j][1] = 1;
			break;
		case ('c'):
			field[i][j][3] = 1;
			break;
		}
		B.move(direction);
	}

	public int isGoooooool() {
		if ((B.i == 0) && (B.j == 3 || B.j == 4 || B.j == 5)) {
			return 1;
		}
		if ((B.i == 12) && (B.j == 3 || B.j == 4 || B.j == 5)) {
			return 2;
		} else {
			return 0;
		}
	}

	public char shoot() {
		while (true) {
			System.out.print("Welche Richtung? qweadyxc");
			char direction = SCANNER.next().charAt(0);
			if (!(direction == 'q' || direction == 'w' || direction == 'e'
					|| direction == 'a' || direction == 'd' || direction == 'y'
					|| direction == 'x' || direction == 'c')) {
				System.out.println("Bitte richtige Richtung eingeben!");
				continue;
			}
			return direction;
		}
	}
}
