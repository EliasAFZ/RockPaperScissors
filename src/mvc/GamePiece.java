package mvc;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/20/2019
 * Description:
 * @Author Elias Afzalzada
 */
public class GamePiece{

    private String pieceName;
    private String losesToo;
    private String winsAgainst;

    public GamePiece (String pieceName, String losesToo, String winsAgainst){
        this.pieceName = pieceName;
        this.losesToo = losesToo;
        this.winsAgainst = winsAgainst;
    }

    public String getPieceName() {
        return pieceName;
    }

    public String getLosesToo() {
        return losesToo;
    }

    public String getWinsAgainst() {
        return winsAgainst;
    }
}
