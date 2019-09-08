package MVC_Pattern;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/20/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */
class GamePiece {

    private String pieceName;
    private String winsAgainst;
    private String losesTo;

    GamePiece(String pieceName, String winsAgainst, String losesTo) {
        this.pieceName = pieceName;
        this.winsAgainst = winsAgainst;
        this.losesTo = losesTo;
    }

    String getPieceName() {
        return pieceName;
    }

    String getWinsAgainst() {
        return winsAgainst;
    }

    String getLosesTo() {
        return losesTo;
    }
}
