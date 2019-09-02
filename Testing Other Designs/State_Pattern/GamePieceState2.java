package State_Pattern;

/**
 * Name: RockPaperScissorsGame
 * Date: 9/2/2019
 * Description:
 *
 * @Author Elias Afzalzada
 * Copyright © Elias Afzalzada - All Rights Reserved
 */
public class GamePieceState2 implements GameState{

    //TODO: finish State two of the game when it starts (just fire water air)

    private GameMachine gameMachine;

    public GamePieceState2(GameMachine newGameMachine){
        gameMachine = newGameMachine;
    }

    @Override
    public void addPlayer(Player player) {

    }

    @Override
    public void isSelectingPiece(GamePiece gamePiece) {

    }
}
