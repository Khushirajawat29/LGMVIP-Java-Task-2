import java.util.Scanner;

public class TicTacToeGame {
    private char[][] board;
    private char currentPlayer;

    public TicTacToeGame() {
        board = new char[4][4];
        currentPlayer = 'O';
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 1; i < 4; i=i+1) {
            for (int j = 1; j < 4; j=j+1) {
                board[i][j] = '?';
            }
        }
    }

    public void printBoard() {
        System.out.println("_____________");
        for (int i = 1; i < 4; i= i+1) {
            System.out.print("| ");
            for (int j = 1; j < 4; j=j+1) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("_____________");
        }
    }

    public boolean isBoardFull() {
        for (int i = 1; i < 4; i=i+1) {
            for (int j = 1; j < 4; j=j+1) {
                if (board[i][j] == '?') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin() {
        // Check rows, columns, and diagonals
        for (int i = 1; i < 4; i=i+1) {
            if (board[i][1] != '?' && board[i][1] == board[i][2] && board[i][2] == board[i][3]) {
                return true;
            }
            if (board[1][i] != '?' && board[1][i] == board[2][i] && board[2][i] == board[3][i]) {
                return true;
            }
        }
        if (board[1][1] != '?' && board[1][1] == board[2][2] && board[2][2] == board[3][3]) {
            return true;
        }
        return board[1][3] != '?' && board[1][3] == board[2][2] && board[2][2] == board[3][1];
    }

    public boolean makeMove(int row, int col) {
        if (row < 1 || row >= 4 || col < 1 || col >= 4 || board[row][col] != '?') {
            return false;
        }
        board[row][col] = currentPlayer;
        return true;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'O') ? 'X' : 'O';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToeGame game = new TicTacToeGame();

        System.out.println("WELCOME TO TIC TAC TOE GAME!!");
        game.printBoard();

        while (true) {
            System.out.println("Player " + game.currentPlayer + ", enter your move (row and column): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (game.makeMove(row, col)) {
                game.printBoard();
                if (game.checkWin()) {
                    System.out.println("Player " + game.currentPlayer + " WIN THE GAME!");
                    break;
                } else if (game.isBoardFull()) {
                    System.out.println("IT'S DRAW");
                    break;
                } else {
                    game.switchPlayer();
                }
            } else {
                System.out.println("Invalid move. Please select a vaild move.");
            }
        }

        scanner.close();
    }
}
