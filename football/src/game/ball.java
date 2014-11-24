package game;

public class ball {

	int i = 7;
	int j = 5;

	public boolean isBall(int i, int j) {
		if (this.i == i && this.j == j) {
			return true;
		}
		return false;
	}

	public void move(char direction) {// qweadyxc
		switch (direction) { // qweadyxc
		case ('q'):
			i -= 1;
			j -=1;
			break;
		case ('w'):
			j -=1;
			break;
		case ('e'):
			j -=1;
			i +=1;
			break;
		case ('a'):
			i -=1;
			break;
		case ('d'):
			i +=1;
			break;
		case ('y'):
			j +=1;
			i -=1;
			break;
		case ('x'):
			j +=1;
			break;
		case ('c'):
			j +=1;
			i +=1;
			break;
		}
	}

}
