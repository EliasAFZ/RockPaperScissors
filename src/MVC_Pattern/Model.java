package MVC_Pattern;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/29/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */

public class Model {

    private HashMap<String, Player> playerMap = new HashMap<>();
    private ArrayList<GamePiece> gamePieceArrayList = new ArrayList<>();
    final private GamePiece rock = new GamePiece("Rock", "scissors", "paper");
    final private GamePiece paper = new GamePiece("Paper", "rock", "scissors");
    final private GamePiece scissors = new GamePiece("Scissors", "paper", "rock");

    Model(){
        //TODO: receive state updates
    }

}
