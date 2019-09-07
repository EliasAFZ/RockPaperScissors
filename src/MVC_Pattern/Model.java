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

class Model {

    final private GamePiece rock = new GamePiece("Rock", "scissors", "paper");
    final private GamePiece paper = new GamePiece("Paper", "rock", "scissors");
    final private GamePiece scissors = new GamePiece("Scissors", "paper", "rock");
    private HashMap<String, Player> playerMap = new HashMap<>();
    private ArrayList<GamePiece> activeGamePieceSet = new ArrayList<>();

    Model() {
        //TODO: receive state updates
        activeGamePieceSet.add(rock);
        activeGamePieceSet.add(paper);
        activeGamePieceSet.add(scissors);
    }

    void createPlayer(String playerName) {
        Player player = new Player(playerName);
        playerMap.put(playerName, player);
    }

    int numOfGamePieces() {
        return activeGamePieceSet.size();
    }

    String currentGamePieces(Controller.Condition condition) {
        return toString(activeGamePieceSet, condition);
    }

    GamePiece retrieveWinLoseConditions(String gamePieceName) {
        GamePiece gp = null;
        for (int i = 0; i < activeGamePieceSet.size(); i++) {

            //if(activeGamePieceSet.get(i)){

            //}
        }
        return gp;
    }

    boolean containsPiece(String playerSelectedPiece) {
        for (GamePiece gamePiece : activeGamePieceSet) {
            if (playerSelectedPiece.equalsIgnoreCase(gamePiece.getPieceName())) {
                return true;
            }
        }
        return false;
    }

    private String toString(ArrayList activeGamePieceSet, Controller.Condition condition) {
        String listOfPieces = "";
        switch (condition) {
            case names -> {
                for (Object o : activeGamePieceSet) {
                    GamePiece currentPiece = (GamePiece) o;
                    listOfPieces += currentPiece.getPieceName() + " ";
                }
            }
            case winsagainst -> {
                for (Object o : activeGamePieceSet) {
                    GamePiece currentPiece = (GamePiece) o;
                    listOfPieces += currentPiece.getWinsAgainst() + " ";
                }
            }
            case losesagainst -> {
                for (Object o : activeGamePieceSet) {
                    GamePiece currentPiece = (GamePiece) o;
                    listOfPieces += currentPiece.getLosesTo() + " ";
                }
            }
        }
        return listOfPieces;
    }
}
