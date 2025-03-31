import java.util.Scanner;
public class TicTacToe {

    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board [][] = new String[ROWS][COLS];

//pseudocode


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        boolean playAgain = false;

        String playMove = "";
        String playString = "";
        String name1 = "Player 1";
        String name2 = "Player 2";
        String P1 = "X";
        String P2 = "O";

        int moveCount = 0;
        int row;
        int col;
        int plays = 0;
    do {
        do {
            clearBoard();
            display();
            for (int turns = 0; turns < 9; turns++) {
                if (plays % 2 == 0) {
                    playMove = P1;
                    playString = name1;
                } else {
                    playMove = P2;
                    playString = name2;
                }
            }
            System.out.println("It's your turn " + playMove);
        } while (moveCount < ROWS * COLS);

        do {
            display();
            row = SafeInput.getRangedInt(in, "Enter row [1-3]: ", 1, 3) - 1;
            col = SafeInput.getRangedInt(in, "Enter row [1-3]: ", 1, 3) - 1;
        } while (isValidMove(row, col));
        moveCount++;
        display();
        board[row][col] = playString;
        if (moveCount >= 4) {

            if (isWin(playString)) {
                System.out.println(playMove + "WINS!");}
            else if (moveCount >= 7) {

                if (isTie()) {
                    System.out.println("It's a...TIE!");}
            }
        }
    }while(SafeInput.getYNConfirm(in, "Play Again?"));
}

    private static void display(){

        String displayBoard = "";
        for (int row = 0; row < ROWS; row++) {
            if (col == COLS - 1){
                displayBoard += board [ROWS][COLS];}
            else { displayBoard += board [ROWS][COLS] + "|";}
            if (row != ROWS - 1){
                displayBoard += "\n---+---+---\n";}
        }
        System.out.println(displayBoard);
    }

    private static void clearBoard() {

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = "   ";} }
    }

    private static boolean isValidMove(int row, int col){

        return (board [row][col].equals("   "));

    }

    private static boolean isWin(String player){

        if (isColWin(player) || isRowWin(player) || isDiagonalWin(player)) {
            return true;}
        else return false;}

    private static boolean isColWin(String player){

        for (int col = 0; col < COLS; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;}
        }
        return false;
    }

    private static boolean isRowWin(String player) {

        for (int row = 0; row < ROWS; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;}
        }
        return false;
    }

    private static boolean isDiagonalWin(String player){



    }

    private static boolean isTie(){



    }


}