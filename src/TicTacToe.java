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

    private static void clearBoard() {
    }
    private static void display(){
    }
    private static boolean isValidMove(int row, int col){
    }
    private static boolean isWin(String player){
    }
    private static boolean isColWin(String player){
    }
    private static boolean isRowWin(String player){
    }
    private static boolean isDiagonalWin(String player){
    }
    private static boolean isTie(){
    }


}