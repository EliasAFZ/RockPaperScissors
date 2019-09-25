package MVC_Pattern;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/20/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */
public class GamePiece {

    private String pieceName;
    private String winsAgainst;
    private String losesTo;

    GamePiece(String pieceName, String winsAgainst, String losesTo) {
        this.pieceName = pieceName;
        this.winsAgainst = winsAgainst;
        this.losesTo = losesTo;
    }

    public String getPieceName() {
        return pieceName;
    }

    public String getWinsAgainst() {
        return winsAgainst;
    }

    public String getLosesTo() {
        return losesTo;
    }
}
