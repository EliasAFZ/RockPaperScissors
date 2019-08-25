package MVC_UDF;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/20/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */
public class GamePiece {

    private String pieceName;
    private String losesTo;
    private String winsAgainst;

    public GamePiece(String pieceName, String losesTo, String winsAgainst) {
        this.pieceName = pieceName;
        this.losesTo = losesTo;
        this.winsAgainst = winsAgainst;
    }

    public String getPieceName() {
        return pieceName;
    }

    public String getLosesTo() {
        return losesTo;
    }

    public String getWinsAgainst() {
        return winsAgainst;
    }
}
