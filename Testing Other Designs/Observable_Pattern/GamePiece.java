/**
 * Project Name: RockPaperScissorsGame
 * Date: 7/20/2019
 * Description:
 * @Author Elias Afzalzada
 */
public class GamePiece implements Contextualizable {

    private String pieceName;
    private String losesToo;
    private String winsAgainst;

    public GamePiece (String _pieceName, String _losesToo, String _winsAgainst){
        this.pieceName = _pieceName;
        this.losesToo = _losesToo;
        this.winsAgainst = _winsAgainst;
    }


}
