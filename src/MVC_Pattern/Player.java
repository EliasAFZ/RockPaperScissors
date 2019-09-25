package MVC_Pattern;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/20/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */
public class Player {

    private String playerName;
    private int playerHighScore;
    private float winRate;
    private int numOfWins;
    private int numOfLosses;
    private int numOfTies;
    private int numOfTotalMatches;

    Player(String playerName) {
        this.playerName = playerName;
        numOfTotalMatches = 0;
        playerHighScore = 0;
        winRate = 0;
        numOfLosses = 0;
        numOfWins = 0;
        numOfTies = 0;

    }

    public String getPlayerName() {
        return playerName;
    }

    public void incrementTotalMatches() {
        this.numOfTotalMatches = numOfTotalMatches + 1;
    }

    public int getPlayerHighScore() {
        return playerHighScore;
    }

    public void setPlayerHighScore(int playerHighScore) {
        this.playerHighScore = playerHighScore;
    }

    public float getWinRate() {
        return winRate;
    }

    public void setWinRate(float winRate) {
        //TODO: BUG divide by zero error
        this.winRate = numOfTotalMatches / numOfLosses;
    }

    public int getNumOfWins() {
        return numOfWins;
    }

    public void incrementWinStat() {
        this.numOfWins = numOfWins + 1;
    }

    public int getNumOfLosses() {
        return numOfLosses;
    }

    public void incrementLoseStat() {
        this.numOfLosses = numOfLosses + 1;
    }

    public int getNumOfTies() {
        return numOfTies;
    }

    public void incrementTieStat() {
        this.numOfTies = numOfTies + 1;
    }
}
