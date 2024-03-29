package MVC_Pattern;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/20/2019
 * Description: Object class to represent a Player.
 *
 * @Author Elias Afzalzada
 */
public class Player {

    private String playerName;
    private float winRate;
    private int numOfWins;
    private int numOfLosses;
    private int numOfTies;
    private int numOfTotalMatches;

    Player(String playerName) {
        this.playerName = playerName;
        numOfTotalMatches = 0;
        winRate = 0;
        numOfWins = 0;
        numOfLosses = 0;
        numOfTies = 0;

    }

    public String getPlayerName() {
        return playerName;
    }

    public int getTotalMatches() {
        return numOfTotalMatches;
    }

    public float getWinRate() {
        return winRate;
    }

    public int getNumOfWins() {
        return numOfWins;
    }

    public int getNumOfLosses() {
        return numOfLosses;
    }

    public int getNumOfTies() {
        return numOfTies;
    }

    public void setWinRate() {
        if (numOfWins != 0 && numOfTotalMatches != 0) {
            winRate = (float) numOfTotalMatches / (float) numOfWins;
        }
    }

    public void incrementTotalMatches() {
        this.numOfTotalMatches = numOfTotalMatches + 1;
    }

    public void incrementWinStat() {
        this.numOfWins = numOfWins + 1;
    }

    public void incrementLoseStat() {
        this.numOfLosses = numOfLosses + 1;
    }

    public void incrementTieStat() {
        this.numOfTies = numOfTies + 1;
    }
}
