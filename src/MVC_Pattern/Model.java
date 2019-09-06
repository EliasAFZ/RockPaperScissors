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
    private ArrayList<GamePiece> activeGamePieceSet = new ArrayList<GamePiece>();

    Model(){
        //TODO: receive state updates
        activeGamePieceSet.add(rock);
        activeGamePieceSet.add(paper);
        activeGamePieceSet.add(scissors);
    }

    public void createPlayer(String playerName){
        Player player = new Player(playerName);
        playerMap.put(playerName, player);
    }

    public int numOfGamePieces(){
        return activeGamePieceSet.size();
    }

    public String currentGamePieces(String condition){
        return toString(activeGamePieceSet, condition);
    }

    public GamePiece getPiece(String gamePieceName){
        GamePiece gp = null;
        for(int i=0; i<activeGamePieceSet.size(); i++){
            if(activeGamePieceSet.get(0).equals(rock)){

            }
        }

        return gp;
    }

    public String toString(ArrayList activeGamePieceSet, String condition){
        String listOfPieces = "";
        switch (condition.toLowerCase()) {
            case "names" -> {
                for(int i=0; i<activeGamePieceSet.size(); i++){
                    GamePiece currentPiece = (GamePiece) activeGamePieceSet.get(i);
                    listOfPieces += currentPiece.getPieceName() + " ";
                }
            }
            case "winsagainst" -> {
                for(int i=0; i<activeGamePieceSet.size(); i++){
                    GamePiece currentPiece = (GamePiece) activeGamePieceSet.get(i);
                    listOfPieces += currentPiece.getWinsAgainst() + " ";
                }
            }
            case "losesagainst" -> {
                for(int i=0; i<activeGamePieceSet.size(); i++){
                    GamePiece currentPiece = (GamePiece) activeGamePieceSet.get(i);
                    listOfPieces += currentPiece.getLosesTo() + " ";
                }
            }
        }

        //for(GamePiece i : activeGamePieceSet){
        //    listOfPieces += i.getPieceName();
        //}

        return listOfPieces;
    }

}
