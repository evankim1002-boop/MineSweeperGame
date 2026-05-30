import java.util.Scanner;

public class Game {
    private int totalGame;
    private int highScore;
    private String input;
    private Scanner scanner;
    private Board board;
    private int gameOver;

    public Game(){
        this.totalGame = 0;
        this.scanner = new Scanner(System.in);
        this.board = new Board();
        this.gameOver = 0;
    }

    public int checkWin(Board board){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board.getTile(i, j).getBomb() == 0 && board.getTile(i, j).getRevealState() == 0) {
                    return 0;
                }
            }
        }
        return 1;
    }

    public void endRound(){
        System.out.println("Game Over");
        gameOver = 1;
    }

    public int getRow(){
        boolean validRow = true;
        System.out.println("Enter row: ");
        int row = scanner.nextInt();
        if(row >= 0 && row <= 9){
            validRow = false;
        }
        scanner.nextLine();
        while(validRow){
            System.out.println("Error. input valid number");
            row = scanner.nextInt();
            scanner.nextLine();
            if(row >= 0 && row <= 9){
                validRow = false;
            }
        }
        return row;
    }
        

    public int getColumn(){
        boolean validColumn = true;
        System.out.println("Enter row: ");
        int row = scanner.nextInt();
        if(row >= 0 && row <= 9){
            validColumn = false;
        }
        scanner.nextLine();
        while(validColumn){
            System.out.println("Error. input valid number");
            row = scanner.nextInt();
            scanner.nextLine();
            if(row >= 0 && row <= 9){
                validColumn = false;
            }
        }
        return row;
    }
    public void playerChoice(){
        board.printDisplay();
        System.out.println("Enter flag, check, or remove: ");
        String input = scanner.nextLine();
        if (input.equals("flag")){
            int row = getRow();
            int column = getColumn();
            placeFlag(row, column);
            
        }
        else if (input.equals("check"))
        {
            int row = getRow();
            int column = getColumn();
            checkTile(row, column);
        }
        else if (input.equals("remove")){
            int row = getRow();
            int column = getColumn();
            removeFlag(row, column);
        }
    }

    public void placeFlag(int r, int c){
        if (board.getTile(r, c).getFlag() == 0){
            board.getTile(r, c).setFlag(1);
            System.out.println("Flag Placed Sucessfully");
        }
        else if (board.getTile(r, c).getFlag() == 1){
            System.out.println("Flag Already Present");
            playerChoice();
        }
    }

    public void checkTile(int r, int c){
        if (board.getTile(r,c).getBomb() == 1){
            board.getTile(r,c).setRevealState(1);
            endRound();
        }
        else {
            board.revealEmptyTiles(r, c);
            System.out.println(board.getNeighborCount(r, c));
        }
    }

    public void removeFlag(int r, int c){
        if (board.getTile(r, c).getFlag() == 1){
            board.getTile(r, c).setFlag(0);
            System.out.println("Flag Removed Sucessfully");
        }
        else if (board.getTile(r, c).getFlag() == 0){
            System.out.println("No Flag Present");
            playerChoice();
        }
    }

    public Board getBoard(){
        return board;
    }

    public int getGameOver(){
        return gameOver;
    }

    public void printDebug(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if(board.getTile(i,j).getBomb() == 0){
                        System.out.print(board.getNeighborCount(i, j) + " ");
                }
                else{
                        System.out.print("B ");
                    }
                
                }
            System.out.println();
        }
            
    }
    
}
