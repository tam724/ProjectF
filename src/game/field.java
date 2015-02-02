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

    //DIFFICULTIES OF THE AI
    static final int DIFFICULTY_SIMPLE = 0;
    static final int DIFFICULTY_MIDDLE = 1;
    static final int DIFFICULTY_HARD = 2;

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
                    {4, 4, 4, 4}, {4, 4, 4, 4}}};    // [höhe][breite][(0:_, 1:|, 2:/,3:\)]

    int Ballx = 7;
    int Bally = 5;
    private int currentplayer = 0;
    private int winplayer = 0;

    private static field testField;
    private static int max_turn_quality = 0;
    private static int[] quality_of_direction = {0, -1, -1, -1, 0, 1, 1, 1};
    public static ArrayList<ArrayList<String>> pList = new ArrayList<>();
    final public static int[] own_goal = {13, 1};
    final public static int[] enemy_goal = {1, 13};
    public static boolean AI_goal = false;
    public static boolean AI_loose = false;
    public static boolean AI_assist = false;
    public static String AI_own_goal;
    public static String AI_assist_shoot;
    public static int assist_counter_to_goal = 0;

    public field(int startplayer) {
        if (startplayer == PLAYER_ONE) {
            currentplayer = PLAYER_ONE;
        } else if (startplayer == PLAYER_TWO) {
            currentplayer = PLAYER_TWO;
        } else {
            //choose random player
            currentplayer = new Random().nextInt(2) + 2;
            assert (currentplayer == PLAYER_ONE || currentplayer == PLAYER_TWO);
        }
        winplayer = 0;
        AI_goal = false;
        AI_loose = false;
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

    public int getOpponent(int player) {
        if (player == PLAYER_ONE) {
            return PLAYER_TWO;
        } else if (player == PLAYER_TWO) {
            return PLAYER_ONE;
        } else return 0;
    }

    // Gibt Wert des Feldes zurück
    public int getValue(int i, int j, int k) {
        return field[j][i][k];
    }

    public int getCurrentPlayer() {
        return currentplayer;
    }

    // Liegt der Ball auf dem Punkt (i,j)
    public boolean isBall(int i, int j) {
        return (Ballx == i && Bally == j);
    }

    // Ist in Schussrichtung schon ein Strich gezogen?
    private boolean isValidShoot(int direction) {
        return !((direction == UP_LEFT && 0 != this.getValue(Ballx - 1, Bally - 1, 3))
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
    private boolean again(int direction) {
        switch (direction) { // qweadyxc
            case (UP_LEFT):
                if (field[Bally][Ballx][0] != 0 || field[Bally][Ballx][1] != 0
                        || field[Bally][Ballx - 1][2] != 0
                        || field[Bally][Ballx - 1][0] != 0
                        || field[Bally - 1][Ballx][2] != 0
                        || field[Bally - 1][Ballx][1] != 0
                        || field[Bally - 1][Ballx - 1][3] != 0) {
                    return true;
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
                    return true;
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
                    return true;
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
                    return true;
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
                    return true;
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
                    return true;
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
                    return true;
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
                    return true;
                } else {
                    break;
                }
        }
        if (currentplayer == PLAYER_ONE) {
            currentplayer = PLAYER_TWO;
        } else if (currentplayer == PLAYER_TWO) {
            currentplayer = PLAYER_ONE;
        }
        return false;
    }

    // Testet ob ein Spieler das Spiel gewonnen hat
    public boolean isWinner() {
        if (AI_loose) {
            return true;
        }
        if (Ballx == 1) {
            winplayer = PLAYER_TWO;
            return true;
        } else if (Ballx == 13) {
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
            if (currentplayer == PLAYER_ONE) winplayer = PLAYER_TWO;
            else if (currentplayer == PLAYER_TWO) winplayer = PLAYER_ONE;
            return true;
        }
        return false;
    }

    public int getWinner() {
        return winplayer;
    }

    // KI
    public String getBestShoot(int player, int difficulty) {
        testField = new field(this);
        AI_goal = false;
        AI_own_goal = "";
        AI_assist = false;
        AI_assist_shoot = "";
        pList.clear();
        switch(player) {
            case (PLAYER_ONE):
                max_turn_quality = -50;
                break;
            case (PLAYER_TWO):
                max_turn_quality = 50;
                break;
        }
        pList.add(new ArrayList<String>());
        pList.add(new ArrayList<String>());
        pList.add(new ArrayList<String>());
        switch (difficulty) {
            case (DIFFICULTY_SIMPLE):
                assist_counter_to_goal = 3;
                break;
            case (DIFFICULTY_MIDDLE):
                assist_counter_to_goal = 7;
                break;
            case (DIFFICULTY_HARD):
                assist_counter_to_goal = 10000;
        }
        testDirections("", player);
        if (difficulty == DIFFICULTY_SIMPLE) {
            //Remove nothing
        } else if (difficulty == DIFFICULTY_MIDDLE && pList.size() > 2) {
            pList.remove(2);
        } else if (difficulty == DIFFICULTY_HARD && pList.size() > 2) {
            pList.remove(2);
            pList.remove(1);
        }
        for (int i = pList.size() - 1; i >= 0; i--) {
            if (pList.get(i).isEmpty()) {
                pList.remove(i);
                System.out.println("Deleting List " + i + " because it is empty");
            }
        }
        if (pList.isEmpty()) {
            if (AI_assist) {
                return AI_assist_shoot;
            } else {
                winplayer = getOpponent(player);
                AI_loose = true;

                if (AI_own_goal.isEmpty()) {

                    return "loose";
                } else {
                    return AI_own_goal;
                }
            }
        }
        int rand_list_num = new Random().nextInt(pList.size());
        assert (rand_list_num >= 0 && rand_list_num < 3);
        int rand_intern_list_num = new Random().nextInt(pList.get(rand_list_num).size());
        return pList.get(rand_list_num).get(rand_intern_list_num);
    }

    private void testDirections(String turn, int player) {
        for (int i = 0; i < 8; i++) {
            if (AI_goal) {
                //Wenn die AI ein Tor geschosssen hat, wird die gesamte rekursion abgebaut!
                return;
            } else {
                // Durchläuft alle 8 Richtungen
                if (testField.isValidShoot(i)) {
                    // Wenn ich in diese Richtung spielen kann
                    // System.out.println("Teste Richtung: "+i);
                    testField.shoot(i);
                    turn = turn + i;
                    if (testField.Ballx == own_goal[player - 2]) {
                        // Wenn die KI ein Tor schießen kann, macht sie es
                        pList.clear();
                        pList.add(new ArrayList<String>());
                        pList.get(0).add(turn);
                        AI_goal = true;
                        testField.goBack(i, player);
                        return;
                    }
                    if (testField.Ballx == enemy_goal[player - 2]) {
                        // Damit die KI kein Eigentor schießt
                        AI_own_goal = turn;
                        //Falls es keine andere möglichkeit gibt wird dieser Zug gespielt
                        turn = turn.substring(0, turn.length() - 1);
                        testField.goBack(i, player);
                        continue;
                    }
                    if (testField.currentplayer == player) {
                        // Wenn der Spieler nochmal an der Reihe ist -> Rekursion
                        // System.out.println("Ich bin nochmal, starte Rekursion");
                        testDirections(turn, player);
                        //System.out.println("weiter gehts :)");
                    } else {
                        // Wenn der Spieler nicht mehr an der Reihe ist -> Maximum
                        // testen

                        if (!isAssist(getOpponent(player), 0)) {
                            if (max_turn_quality > testField.Ballx) {
                                // Wenn aktuell getesteter Zug besser als vorherige ist
                                pList.remove(2);
                                pList.add(0, new ArrayList<String>());
                                pList.get(0).add(turn);
                                max_turn_quality = testField.Ballx;
                            } else if (max_turn_quality == testField.Ballx) {
                                // Wenn der beste und der aktuelle gleich gut sind
                                pList.get(0).add(turn);
                            } else if (max_turn_quality + 1 == testField.Ballx) {
                                //Wenn der beste um eins bessser ist als der aktuelle (Schwierigkeitsgrad)
                                pList.get(1).add(turn);
                            } else if (max_turn_quality + 2 == testField.Ballx) {
                                //Wenn der beste um zwei besser ist als der aktuelle (Schwierigkeitsgrad)
                                pList.get(2).add(turn);
                            }
                        } else {
                            if (!AI_assist) {
                                AI_assist_shoot = turn;
                            }
                            AI_assist = true;
                        }
                    }
                    turn = turn.substring(0, turn.length() - 1);
                    testField.goBack(i, player);
                }
            }
        }
    }

    public boolean isAssist(int player, int counter) {
        if (counter <= assist_counter_to_goal) {
            for (int i = 0; i < 8; i++) {
                // Durchläuft alle 8 Richtungen
                if (testField.isValidShoot(i)) {
                    // Wenn ich in diese Richtung spielen kann
                    testField.shoot(i);
                    if (testField.Ballx == own_goal[player - 2]) {
                        testField.goBack(i, player);
                        return true;
                    }
                    if (testField.again(i)) {
                        // Wenn der Spieler nochmal an der Reihe ist -> Rekursion
                        if (isAssist(player, counter + 1)) {
                            testField.goBack(i, player);
                            return true;
                        }
                    }
                    testField.goBack(i, player);
                }
            }
        }
        return false;
    }
}
