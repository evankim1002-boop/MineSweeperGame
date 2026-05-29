public class Tile{

    private int Bomb;
    private int isFlag;
    private int bombCount;
    private int revealState;

    public Tile() {
        Bomb = (int) (Math.random() + 1);
        isFlag = 0;

    }

    public int getBomb() {
        if (Bomb == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getFlag() {
        if (isFlag == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public void setFlag(int flag) {
        this.isFlag = flag;
    }

    public int getRevealState(){
        return revealState;
    }

    public void setRevealState(int i){
        revealState = i;
    } 

    
}
