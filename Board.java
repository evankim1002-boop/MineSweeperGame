
public class Board {

    private int flagCount;
    private int bombCount;
    private Tile[][] tileBoard;

    public Board() {
        flagCount = 0;
        generateBoard();
        this.bombCount = bombCount;
    }

    public void generateBoard(){
        tileBoard = new Tile[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Tile tile = new Tile();
                tileBoard[i][j] = tile;
                if (tile.getBomb() == 1) {
                    bombCount++;
                }
            }
        }
    }

    public int getFlagCount() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tileBoard[i][j].getFlag() == 1) {
                    flagCount++;
                }
            }
        }
        return flagCount;
    }

    
}


