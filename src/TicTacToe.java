import java.util.Scanner;
public class TicTacToe {

    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static final String[][] board = new String[ROWS][COLS];

//pseudocode


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        boolean gameOver = false;

        boolean playAgain;
        String playMove = "";
        String playString = "";
        String name1 = "Player 1";
        String name2 = "Player 2";
        String P1 = "X";
        String P2 = "O";

        int row;
        int col;
        int plays = 0;

        do {
            clearBoard();

            do {

                display();

                for (int turns = 0; turns < 9; turns++) {
                    if (plays % 2 == 0) {
                        playString = P1;
                        playMove = name1;
                    } else {
                        playString = P2;
                        playMove = name2;
                    }
                }
                System.out.println("It's your turn " + playMove);

                do {

                    row = SafeInput.getRangedInt(in, "Enter row: ", 1, 3) - 1;
                    col = SafeInput.getRangedInt(in, "Enter col: ", 1, 3) - 1;
                    plays += 1;
                    board[row][col] = playString;
                    display();

                } while (isValidMove(row, col));

                if (plays >= 5) {
                    gameOver = true;
                    if (isWin(playString)) {
                        System.out.println(playMove + "WINS!");
                        break;
                    } else if (plays >= 7) {
                        if (isTie()) {
                            System.out.println("It's a...TIE!");
                            break;
                        }
                    }
                   playAgain = SafeInput.getYNConfirm(in, "Play Again? [Y/N]");
                }
            } while (gameOver = true);
        }while (playAgain = true);
    }

    private static void display() {

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                System.out.print(board[row][col] + " | ");}
            System.out.print("\n");
            for (int k = 0; k < COLS * ROWS * 1.25; k++) {
                System.out.print("-");}
            System.out.print("\n");
        }
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

        if (board [0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player) ||
                (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player))) {
            return true;}
        else return false; }

    private static boolean isTie(){

        int noX = 0;
        int noO = 0;
        int numberTies = 0;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col].equals("X")) {
                    noX++;}
            else if (board[row][col].equals("O")) {
            noO++; }
            if (noX >= 1 && noO >= 1) {
                numberTies++;}
            }
        }
        if (numberTies >= 3) {
            return true;}
        return false;
    }
}