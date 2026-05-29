import java.util.Scanner;

public class Game {
    private int totalGame;
    private int highScore;
    private String input;
    private Scanner scanner;
    private Board board;

    public Game(){
        this.totalGame = 0;
        this.scanner = new Scanner(System.in);
        this.board = new Board();
    }

    public int checkWin(Board board){
    }

    public void endRound(){
        
    }

    public int getRow(){
        System.out.println("Enter row: ");
        return scanner.nextInt();
        
    }

    public int getColumn(){
        System.out.println("Enter column: ");
        return scanner.nextInt();
    }

    public void playerChoice(){
        String input = scanner.nextLine();
        if (input.equals("flag")){
            placeFlag(getRow(), getColumn());
            
        }
        else if (input.equals("check"))
        {
            checkTile(getRow(), getColumn());
        }
        else if (input.equals("remove")){
            removeFlag(getRow(), getColumn());
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
        if (board.getTile(r,c).getBomb() == 1)
            board.getTile(r,c).setRevealState(1);
            endRound();
        else{
            System.out.println(board.getTile(r,c).getBombCount())
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
    
}
