package game;

import java.util.ArrayList;
import java.util.Random;

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

    private int[][][] field = {
            {{4, 4, 4, 4}, {4, 4, 4, 4}, {4, 4, 4, 4},
                    {4, 4, 4, 4}, {4, 4, 4, 4}, {4, 4, 4, 4},
                    {4, 4, 4, 4}, {4, 4, 4, 4}, {4, 4, 4, 4},
                    {4, 4, 4, 4}, {4, 4, 4, 4}, {4, 4, 4, 4},
                    {4, 4, 4, 4}, {4, 4, 4, 4}},
            {{4, 4, 4, 4}, {4, 4, 4, 4}, {1, 1, 0, 0},
                    {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0},
                    {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0},
                    {1, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0},
                    {4, 1, 4, 4}, {4, 4, 4, 4}},
            {{4, 4, 4, 4}, {4, 4, 4, 4}, {0, 1, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {4, 1, 4, 4}, {4, 4, 4, 4}},
            {{4, 4, 4, 4}, {4, 4, 4, 4}, {0, 1, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {4, 1, 4, 4}, {4, 4, 4, 4}},
            {{4, 4, 4, 4}, {2, 2, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {3, 0, 0, 0}, {4, 3, 4, 4}},
            {{4, 4, 4, 4}, {0, 2, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {4, 3, 4, 4}},
            {{4, 4, 4, 4}, {2, 4, 4, 4}, {0, 1, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {3, 1, 4, 4}, {4, 4, 4, 4}},
            {{4, 4, 4, 4}, {4, 4, 4, 4}, {0, 1, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {4, 1, 4, 4}, {4, 4, 4, 4}},
            {{4, 4, 4, 4}, {4, 4, 4, 4}, {0, 1, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0},
                    {4, 1, 4, 4}, {4, 4, 4, 4}},
            {{4, 4, 4, 4}, {4, 4, 4, 4}, {1, 4, 4, 4},
                    {1, 4, 4, 4}, {1, 4, 4, 4}, {1, 4, 4, 4},
                    {1, 4, 4, 4}, {1, 4, 4, 4}, {1, 4, 4, 4},
                    {1, 4, 4, 4}, {1, 4, 4, 4}, {1, 4, 4, 4},
                    {4, 4, 4, 4}, {4, 4, 4, 4}}};    // [höhe][breite][1-4(0:_, 1:|, 2:/,3:\)]

    int Ballx = 7;
    int Bally = 5;
    private int currentplayer = 0;
    private int winplayer = 0;

    private static field testField;
    private static int max_turn_quality = 0;
    private static int[] quality_of_direction = {0, -1, -1, -1, 0, 1, 1, 1};
    public static ArrayList<String> pList = new ArrayList<>();

    public field(int startplayer){
        if(startplayer == PLAYER_ONE){
            currentplayer = PLAYER_ONE;
        }
        else if(startplayer == PLAYER_TWO){
            currentplayer = PLAYER_TWO;
        }
        else {
            //choose random player
            currentplayer = new Random().nextInt(2)+2;
            assert (currentplayer == PLAYER_ONE || currentplayer == PLAYER_TWO);
        }
    }

    public field(field toCopy) {
        this.Ballx = toCopy.Ballx;
        this.Bally = toCopy.Bally;
        this.currentplayer = toCopy.currentplayer;
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

    public int getCurrentPlayer(){
        return currentplayer;
    }

    // Liegt der Ball auf dem Punkt (i,j)
    public boolean isBall(int i, int j) {
        return (Ballx == i && Bally == j);
    }

    // Ist in Schussrichtung schon ein Strich gezogen?
    private boolean isValidShoot(int direction) {
        return!((direction == UP_LEFT && 0 != this.getValue(Ballx - 1, Bally - 1, 3))
                || (direction == UP && 0 != this.getValue(Ballx, Bally - 1, 1))
                || (direction == UP_RIGHT && 0 != this.getValue(Ballx, Bally - 1, 2))
                || (direction == LEFT && 0 != this.getValue(Ballx - 1, Bally, 0))
                || (direction == RIGHT && 0 != this.getValue(Ballx, Bally, 0))
                || (direction == DOWN_LEFT && 0 != this.getValue(Ballx - 1, Bally, 2))
                || (direction == DOWN && 0 != this.getValue(Ballx, Bally, 1))
                || (direction == DOWN_RIGHT && 0 != this.getValue(Ballx, Bally, 3)));
    }

    // Ball wird in angegebene Richtung bewegt und der Strich wird gesetzt
    public boolean shoot(int direction) {
        if (!isValidShoot(direction)) {
            return false;
        } else {
            switch (direction) { // qweadyxc
                case (UP_LEFT):
                    field[Bally - 1][Ballx - 1][3] = currentplayer;
                    Ballx -= 1;
                    Bally -= 1;
                    break;
                case (UP):
                    field[Bally - 1][Ballx][1] = currentplayer;
                    Bally -= 1;
                    break;
                case (UP_RIGHT):
                    field[Bally - 1][Ballx][2] = currentplayer;
                    Ballx += 1;
                    Bally -= 1;
                    break;
                case (LEFT):
                    field[Bally][Ballx - 1][0] = currentplayer;
                    Ballx -= 1;
                    break;
                case (RIGHT):
                    field[Bally][Ballx][0] = currentplayer;
                    Ballx += 1;
                    break;
                case (DOWN_LEFT):
                    field[Bally][Ballx - 1][2] = currentplayer;
                    Ballx -= 1;
                    Bally += 1;
                    break;
                case (DOWN):
                    field[Bally][Ballx][1] = currentplayer;
                    Bally += 1;
                    break;
                case (DOWN_RIGHT):
                    field[Bally][Ballx][3] = currentplayer;
                    Ballx += 1;
                    Bally += 1;
                    break;
            }
            again(direction);
            return true;
        }
    }

    private boolean goBack(int direction, int tempPlayer) {
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
        currentplayer = tempPlayer;
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
        if (currentplayer == PLAYER_ONE) {
            currentplayer = PLAYER_TWO;
        } else if (currentplayer == PLAYER_TWO) {
            currentplayer = PLAYER_ONE;
        }
    }

    // Testet ob ein Spieler das Spiel gewonnen hat
    public boolean isWinner() {
        if (Ballx == 1) {
           winplayer = PLAYER_TWO;
            return true;
        }
        else if(Ballx == 13){
            winplayer = PLAYER_ONE;
            return true;
        }
        if (field[Bally][Ballx][0] != 0 && field[Bally][Ballx][1] != 0
                && field[Bally][Ballx][3] != 0
                && field[Bally][Ballx - 1][2] != 0
                && field[Bally][Ballx - 1][0] != 0
                && field[Bally - 1][Ballx][2] != 0
                && field[Bally - 1][Ballx][1] != 0
                && field[Bally - 1][Ballx - 1][3] != 0) {
            if(currentplayer == PLAYER_ONE) winplayer = PLAYER_TWO;
            else if(currentplayer == PLAYER_TWO) winplayer = PLAYER_ONE;
            return true;
        }
        return false;
    }

    public int getWinner(){
        return winplayer;
    }

    // KI
    public String getBestShoot(int player) {
        testField = new field(this);
        pList.clear();
        max_turn_quality = -30;
        testDirections("", 0, player);
        if(pList.size() > 0)
        	return pList.get(new Random().nextInt((pList.size() - 1) - 0 + 1));
        else
        	return null;
    }

    private void testDirections(String turn, int quality, int player) {
        int temp_quality;
        int ball_quality = Ballx;
        boolean goal = false;
        int own_goal;
        int enemy_goal;
        if (player == PLAYER_ONE) {
            own_goal = 13;
            enemy_goal = 1;
        } else {
            assert (player == PLAYER_TWO);
            own_goal = 1;
            enemy_goal = 13;
        }
        for (int i = 0; i < 8; i++) {
            temp_quality = quality;
            //Durchläuft alle 8 Richtungen
            if (testField.isValidShoot(i)) {
                //Wenn ich in diese Richtung spielen kann
                testField.shoot(i);
                turn = turn + i;
                //In welche Richtung soll die KI spielen?
                if (player == PLAYER_ONE) {
                    temp_quality -= quality_of_direction[i];
                } else {
                    temp_quality += quality_of_direction[i];
                }
                if (ball_quality - temp_quality == own_goal || goal) {
                    //Wenn die KI ein Tor schießen kann, macht sie es
                    pList.clear();
                    pList.add(turn);
                    return;
                }
                if (ball_quality - temp_quality == enemy_goal) {
                    //Damit die KI kein Eigentor schießt
                    turn = turn.substring(0, turn.length() - 1);
                    testField.goBack(i, player);
                    continue;
                }
                if (testField.currentplayer == player) {
                    //Wenn der Spieler nochmal an der Reihe ist -> Rekursion
                    testDirections(turn, temp_quality, player);
                } else {
                    //Wenn der Spieler nicht mehr an der Reihe ist -> Maximum testen
                    if (max_turn_quality < temp_quality) {
                        //Wenn aktuell getesteter Zug besser als vorherige ist
                        pList.clear();
                        pList.add(turn);
                        max_turn_quality = temp_quality;
                    } else if (max_turn_quality == temp_quality) {
                        //Wenn der beste und der aktuelle gleich gut sind
                        pList.add(turn);
                    }
                }
                turn = turn.substring(0, turn.length() - 1);
                testField.goBack(i, player);
            }
        }
    }

}
