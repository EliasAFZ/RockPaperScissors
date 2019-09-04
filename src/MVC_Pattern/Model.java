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

    final private GamePiece rock = new GamePiece("Rock", "scissors", "paper");
    final private GamePiece paper = new GamePiece("Paper", "rock", "scissors");
    final private GamePiece scissors = new GamePiece("Scissors", "paper", "rock");
    private HashMap<String, Player> playerMap = new HashMap<>();
    private ArrayList<GamePiece> activeGamePieceSet = new ArrayList<>();
    private GamePiece[] gamePieceSetOne = new GamePiece[1];
    private GamePiece[] gamePieceSetTwo = new GamePiece[1];
    private GamePiece[] gamePieceSetThree = new GamePiece[1];

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

    public void initState(){
        activeGamePieceSet.add(rock);
        activeGamePieceSet.add(paper);
        activeGamePieceSet.add(scissors);
    }

    public void createPlayer(String playerName){
        Player player = new Player(playerName);
    }

    public void addPlayer(Player p1){
        playerMap.put(p1.getPlayerName(), p1);
    }

}
