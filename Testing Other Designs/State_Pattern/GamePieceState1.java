package State_Pattern;

/**
 * Name: RockPaperScissorsGame
 * Date: 9/2/2019
 * Description:
 *
 * @Author Elias Afzalzada
 * Copyright © Elias Afzalzada - All Rights Reserved
 */
public class GamePieceState1 implements  GameState {

    //TODO: finish State one of the game when it starts (just rock paper scissors)

    private GameMachine gameMachine;

    public GamePieceState1(GameMachine newGameMachine){
        gameMachine = newGameMachine;
    }


    @Override
    public void addPlayer(Player player) {

    }

    @Override
    public void isSelectingPiece(GamePiece gamePiece) {

    }
}
