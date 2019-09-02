package State_Pattern;

/**
 * Name: RockPaperScissorsGame
 * Date: 9/2/2019
 * Description:
 *
 * @Author Elias Afzalzada
 * Copyright © Elias Afzalzada - All Rights Reserved
 */
public class GamePieceState3 implements GameState {

    //TODO: Finish State three of the game when it starts (rock, paper, scissors, fire, water, air, sponge)

    private GameMachine gameMachine;

    public GamePieceState3(GameMachine newGameMachine){
        gameMachine = newGameMachine;
    }

    @Override
    public void addPlayer(Player player) {

    }

    @Override
    public void isSelectingPiece(GamePiece gamePiece) {

    }
}
