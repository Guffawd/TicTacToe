import java.util.Scanner;

public class Main {
    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    static boolean xTurn = true;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        printBoard();

        while (true) {
            System.out.println("Enter row (0-2): ");
            int row = scanner.nextInt();
            System.out.println("Enter col (0-2): ");
            int col = scanner.nextInt();

            if (board[row][col] == ' ') {
                if (xTurn) {
                    board[row][col] = 'X';
                    xTurn = false;
                } else {
                    board[row][col] = 'O';
                    xTurn = true;
                }
                printBoard();
                if (checkWin()) {
                    System.out.println("Player " + (xTurn ? "O" : "X") + " wins!");
                    break;
                }
                if (checkDraw()) {
                    System.out.println("It's a draw!");
                    break;
                }
            } else {
                System.out.println("That spot is already taken, try again");
            }
        }

        scanner.close();
    }

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2]);
            if (i != 2) {
                System.out.println("---|---|---");
            }
        }
    }

    public static boolean checkWin() {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return true;
            }
        }
        // check cols
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return true;
            }
        }
        // check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return true;
        }
        return false;
    }

    public static boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
