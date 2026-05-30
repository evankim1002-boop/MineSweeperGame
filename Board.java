
public class Board {

    private int flagCount;
    private int bombCount;
    private Tile[][] tileBoard;
    private int neighborCount;
    private Tile tile;

    public Board() {
        flagCount = 0;
        this.bombCount = 0;
        generateBoard();
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

    public int getBombCount(){
        bombCount = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tileBoard[i][j].getBomb() == 1) {
                    bombCount++;
                }
            }
        }
        return bombCount;
    }

    public int getNeighborCount(int r, int c){
        int count = 0;
        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (i >= 0 && i < 10 && j >= 0 && j < 10 && !(i == r && j == c)) {
                    if(getTile(i, j).getBomb()==1){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public void revealEmptyTiles(int r, int c){
        if (r < 0 || r >= 10 || c < 0 || c >= 10) {
            return;
        }
        if (getTile(r, c).getRevealState() == 1 || getTile(r, c).getFlag() == 1 || getTile(r, c).getBomb() == 1) {
            return;
        }

        getTile(r, c).setRevealState(1);

        if (getNeighborCount(r, c) != 0) {
            return;
        }

        for (int i = r - 1; i <= r + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (!(i == r && j == c)) {
                    revealEmptyTiles(i, j);
                }
            }
        }
    }

    public Tile getTile(int r, int c) {
        return tileBoard[r][c];
    }

    public int getFlagCount() {
        flagCount = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (tileBoard[i][j].getFlag() == 1) {
                    flagCount++;
                }
            }
        }
        return flagCount;
    }

    public void printDisplay(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (getTile(i,j).getRevealState() == 0){
                    if(getTile(i,j).getFlag() == 0){
                        System.out.print("? ");
                    }
                    else{
                        System.out.print("F ");
                    }
                }
                else if(getTile(i,j).getRevealState()== 1){
                    System.out.print(getNeighborCount(i, j) + " ");
                }
            }
            System.out.println();
        }
    }

    
    
    

    
}


