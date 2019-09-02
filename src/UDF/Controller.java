package UDF;


/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/29/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */
public class Controller implements Action{

    private State st;

    Controller(State st){
        this.st = st;
    }


    @Override
    public void isPlaying() {

    }

    @Override
    public void selectingPiece(GamePiece selectedPiece) {

    }
}