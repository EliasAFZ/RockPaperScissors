package MVC_Pattern;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/3/2019
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

    private enum gameObject{
        rock("Scissors", "Paper"),
        paper("Scissors", "Paper"),
        scissor("Scissors", "Paper"),
        fire("Scissors", "Paper"),
        water("Scissors", "Paper"),
        air("Scissors", "Paper"),
        sponge("Scissors", "Paper");

        private final String winsAgainst;
        private final String losesTo;

        gameObject(String winsAgainst, String losesTo){
            this.winsAgainst = winsAgainst;
            this.losesTo = losesTo;
        }
    }


    Model(){
        //TODO: receive state updates
    }

    public void test(){

    }

}
