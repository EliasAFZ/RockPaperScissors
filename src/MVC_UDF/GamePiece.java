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
    private String winsAgainst;
    private String losesTo;

    public GamePiece(String pieceName, String winsAgainst, String losesTo) {
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
