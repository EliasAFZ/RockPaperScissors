/**
 * Name: RockPaperScissorsGame
 * Date: 7/23/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */
public class Computer implements Contextualizable {

    final private String playerName = "Computer";
    private int computerHighScore;
    private float winRate;
    private int numOfWins;
    private int numOfLosses;

    public Computer() {
        computerHighScore = 0;
        winRate = 0;
        numOfWins = 0;
        numOfLosses = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getComputerHighScore() {
        return computerHighScore;
    }

    public void setComputerHighScore(int computerHighScore) {
        this.computerHighScore = computerHighScore;
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
}
