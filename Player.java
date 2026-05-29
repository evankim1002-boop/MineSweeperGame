;

public class Player {
    private String name;
    private int score;
    private int highScore;
    private int Time;
    private int gamesPlayed;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.highScore = 0;
        this.Time = 0;
        this.gamesPlayed = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return calculateScore(Time);
    }

    public int getHighScore() {
        return highScore(getScore());
    }

    public int getTime() {
        return (int) (System.currentTimeMillis()/1000);
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int calculateScore(int time){
        score = 1000 - time;
        return score;
    }

    public int highScore(int score){
        if (score > highScore) {
            highScore = score;
        }
        return highScore;
    } 

    


}