public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Alice");
        Game game1 = new Game();
        while(game1.checkWin(game1.getBoard()) == 0 && game1.getGameOver() == 0){
            game1.playerChoice();
            System.out.println();
            game1.printDebug();
            System.out.println(""+player1.getTime());
        }
        game1.printDebug();
        if (game1.checkWin(game1.getBoard()) == 1){
            System.out.println();
            System.out.println("You Win!");
            System.out.println();
        }
    }
}
