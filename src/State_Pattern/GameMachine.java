package State_Pattern;


/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/29/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */
public class GameMachine {

    private GameState gameState;
    private GameState gamePieceState1;
    private GameState gamePieceState2;
    private GameState gamePieceState3;

    public GameMachine(){
        gamePieceState1 = new GamePieceState1(this);
        gamePieceState2 = new GamePieceState2(this);
        gamePieceState3 = new GamePieceState3(this);

        gameState = gamePieceState1;
    }

}