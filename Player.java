import java.util.Timer;

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
        return score;
    }

    public int getHighScore() {
        return highScore;
    }

    public int getTime() {
        
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }
}