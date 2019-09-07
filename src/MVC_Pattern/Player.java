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

    Player(String playerName) {
        this.playerName = playerName;
        playerHighScore = 0;
        winRate = 0;
        numOfLosses = 0;
        numOfWins = 0;
    }

    String getPlayerName() {
        return playerName;
    }

    int getPlayerHighScore() {
        return playerHighScore;
    }

    void setPlayerHighScore(int playerHighScore) {
        this.playerHighScore = playerHighScore;
    }

    float getWinRate() {
        return winRate;
    }

    void setWinRate(float winRate) {
        this.winRate = winRate;
    }

    int getNumOfWins() {
        return numOfWins;
    }

    void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }

    int getNumOfLosses() {
        return numOfLosses;
    }

    void setNumOfLosses(int numOfLosses) {
        this.numOfLosses = numOfLosses;
    }
}
