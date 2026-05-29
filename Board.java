
public class Board {

    private int flagCount;
    private int bombCount;
    private Tile[][] tileBoard;
    private int neighborCount;
    private Tile tile;

    public Board() {
        flagCount = 0;
        generateBoard();
        this.bombCount = 0;
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
        Tile tile = getTile(r, c);
        int count = 0;
        if(r == 0 && c == 0){
            if(getTile(r+1,c).getBomb()==1){
                count++;
            }
            else if(getTile(r, c+1).getBomb()==1){

            }
        }
    }

    public Tile getTile(int r, int c) {
        return tileBoard[r][c];
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

    public void printDisplay(){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                if (getTile(i,j).getRevealState() == 0){
                    if(getTile(i,j).getFlag() == 0){
                        System.out.println("?");
                    }
                    else{
                        System.out.println("Flag");
                    }
                }
                else if(getTile(i,j).getRevealState()== 0){
                    System.out.println(getNeighborCount(i, j));
                }
            }
            System.out.println();
        }
    }

    

    
}


