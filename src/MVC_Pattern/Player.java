package MVC_Pattern;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/20/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */
class Player {

    private String playerName;
    private int playerHighScore;
    private float winRate;
    private int numOfWins;
    private int numOfLosses;
    private int numOfTies;

    Player(String playerName) {
        this.playerName = playerName;
        playerHighScore = 0;
        winRate = 0;
        numOfLosses = 0;
        numOfWins = 0;
        numOfTies = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
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
        this.winRate = winRate;
    }

    public int getNumOfWins() {
        return numOfWins;
    }

    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }

    public int getNumOfLosses() {
        return numOfLosses;
    }

    public void setNumOfLosses(int numOfLosses) {
        this.numOfLosses = numOfLosses;
    }

    public int getNumOfTies() {
        return numOfTies;
    }

    public void setNumOfTies(int numOfTies) {
        this.numOfTies = numOfTies;
    }
}
