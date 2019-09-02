package State_Pattern;

/**
 * Name: RockPaperScissorsGame
 * Date: 8/29/2019
        * Description:
        *
        * @Author Elias Afzalzada
        * Copyright © Elias Afzalzada - All Rights Reserved
        */
interface GameState {

    void addPlayer(Player player);

    void isSelectingPiece(GamePiece gamePiece);

    //TODO: add more actions for all states to use

}
