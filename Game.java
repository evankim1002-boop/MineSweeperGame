
import java.util.Scanner;

public class Game {

    private int totalGame;
    private int highScore;
    private String input;
    private Scanner scanner;
    private Board board;
    private int gameOver;

    public Game() {
        this.totalGame = 0;
        this.scanner = new Scanner(System.in);
        this.board = new Board();
        this.gameOver = 0;
    }

    public int checkWin(Board board) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board.getTile(i, j).getBomb() == 0 && board.getTile(i, j).getRevealState() == 0) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public void endRound() {
        System.out.println(" _._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._.");
        System.out.println(" /                                                                         \\");
        System.out.println("|   ____    _    __  __ _____    ___  _   _ _____ ____      _ _ _ _ _     |");
        System.out.println("|  / ___|  / \\  |  \\/  | ____|  / _ \\| | | | ____|  _ \\    | | | | | |    |");
        System.out.println("| | |  _  / _ \\ | |\\/| |  _|   | | | | | | |  _| | |_) |   | | | | | |    |");
        System.out.println("| | |_| |/ ___ \\| |  | | |___  | |_| | V_/  | |___|  _ <    |_|_|_|_|_|    |");
        System.out.println("|  \\____/_/   \\_\\_|  |_|_____|  \\___/ \\_/   |_____|_| \\_\\   (_) (_) (_)    |");
        System.out.println("|                                                                         |");
        System.out.println("\\_._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._._/");
        gameOver = 1;
    }

    public int getRow() {
        boolean validRow = true;
        int row = -1;
        // System.out.println("Enter row: ");
        // int row = scanner.nextInt();
        // row = scanner.nextInt();
        // scanner.nextLine();

        // while(validRow){
        //     if (!scanner.hasNextInt()){
        //         System.out.println("Error. input valid number");
        //     }
        //     row = scanner.nextInt();
        //     scanner.next();
        //     if(row >= 0 && row <= 9){
        //         validRow = false;
        //     }
        // }
        // return row;
        while (true) {
            System.out.print("Enter row: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Error. Enter a valid number.");
                scanner.next(); // remove invalid token
            } else {
                row = scanner.nextInt();

                if (row >= 0 && row <= 9) {
                    break;
                }

                System.out.println("Row must be between 0 and 9.");
            }
        }
        return row;
    }

    public int getColumn() {
        boolean validColumn = true;
        int column = -1;
        // System.out.println("Enter column: ");
        // while (!scanner.hasNextInt()) {
        // System.out.println("Error. input valid number");
        // }
        // int column = scanner.nextInt();
        // if(column > 0 || column < 9){
        //     validColumn = false;
        // }
        // while (validColumn && !scanner.hasNextInt()) {
        //     System.out.println("Error. input valid number");
        //     column = scanner.nextInt();
        //     scanner.next();
        //     if (column >= 0 && column <= 9) {
        //         validColumn = false;
        //     }
        // }
        // return column;
        while (true) {
            System.out.print("Enter column: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Error. Enter a valid number.");
                scanner.next(); // remove invalid token
            } else {
                column = scanner.nextInt();

                if (column >= 0 && column <= 9) {
                    break;
                }

                System.out.println("Column must be between 0 and 9.");
            }
        }
        return column;
    }

    public void playerChoice() {
        board.printDisplay();
        System.out.println("Enter flag, check, or remove: ");
        String input = scanner.nextLine();
        if (input.equals("flag")) {
            int row = getRow();
            int column = getColumn();
            placeFlag(row, column);

        } else if (input.equals("check")) {
            int row = getRow();
            int column = getColumn();
            checkTile(row, column);
        } else if (input.equals("remove")) {
            int row = getRow();
            int column = getColumn();
            removeFlag(row, column);
        }
    }

    public void placeFlag(int r, int c) {
        if (board.getTile(r, c).getFlag() == 0) {
            board.getTile(r, c).setFlag(1);
            System.out.println("Flag Placed Sucessfully");
        } else if (board.getTile(r, c).getFlag() == 1) {
            System.out.println("Flag Already Present");
            playerChoice();
        }
    }

    public void checkTile(int r, int c) {
        if (board.getTile(r, c).getBomb() == 1) {
            board.getTile(r, c).setRevealState(1);
            endRound();
        } else {
            board.revealEmptyTiles(r, c);
            System.out.println(board.getNeighborCount(r, c));
        }
    }

    public void removeFlag(int r, int c) {
        if (board.getTile(r, c).getFlag() == 1) {
            board.getTile(r, c).setFlag(0);
            System.out.println("Flag Removed Sucessfully");
        } else if (board.getTile(r, c).getFlag() == 0) {
            System.out.println("No Flag Present");
            playerChoice();
        }
    }

    public Board getBoard() {
        return board;
    }

    public int getGameOver() {
        return gameOver;
    }

    public void printDebug() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board.getTile(i, j).getBomb() == 0) {
                    System.out.print(board.getNeighborCount(i, j) + " ");
                } else {
                    System.out.print("B ");
                }

            }
            System.out.println();
        }

    }

}
