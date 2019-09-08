package MVC_Pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/3/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */

class Model {

    final private GamePiece rock = new GamePiece("rock", "scissors", "paper");
    final private GamePiece paper = new GamePiece("paper", "rock", "scissors");
    final private GamePiece scissors = new GamePiece("scissors", "paper", "rock");
    private HashMap<String, Player> playerMap = new HashMap<>();
    private ArrayList<GamePiece> activeGamePieceSet = new ArrayList<>();

    Model() {
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

    String getCpuPieceChoice() {
        Random randGen = new Random();
        int randPieceIndex = randGen.nextInt(activeGamePieceSet.size());
        GamePiece cpuChosenPiece = activeGamePieceSet.get(randPieceIndex);
        return cpuChosenPiece.getPieceName();
    }

    //TODO: migrate this function to controller
    String retrieveMatchResults(String p1SelectedPiece, String p2SelectedPiece) {
        GamePiece p1GamePiece = toGamePiece(p1SelectedPiece);
        GamePiece p2GamePiece = toGamePiece(p1SelectedPiece);
        String matchResult = "Error";
        if (p1GamePiece.getWinsAgainst().equalsIgnoreCase(p2SelectedPiece)) {
            matchResult = "p1Winner";
        } else if (p2GamePiece.getWinsAgainst().equalsIgnoreCase(p1SelectedPiece)) {
            matchResult = "p2Winner";
        } else if (p1SelectedPiece.equalsIgnoreCase(p2SelectedPiece)) {
            matchResult = "tie";
        }
        return matchResult;
    }

    boolean containsPiece(String playerSelectedPiece) {
        for (GamePiece gamePiece : activeGamePieceSet) {
            if (playerSelectedPiece.equalsIgnoreCase(gamePiece.getPieceName())) {
                return true;
            }
        }
        return false;
    }

    GamePiece toGamePiece(String gamePieceName) {
        for (GamePiece currentPiece : activeGamePieceSet) {
            if (currentPiece.getPieceName().equalsIgnoreCase(gamePieceName)) {
                return currentPiece;
            }
        }
        return null;
    }

    String stringGamePieces(Controller.Condition condition) {
        String listOfPieces = "";
        switch (condition) {
            case names -> {
                for (GamePiece currentPiece : activeGamePieceSet) {
                    listOfPieces += currentPiece.getPieceName() + " ";
                }
            }
            case winsagainst -> {
                for (GamePiece currentPiece : activeGamePieceSet) {
                    listOfPieces += currentPiece.getWinsAgainst() + " ";
                }
            }
            case losesagainst -> {
                for (GamePiece currentPiece : activeGamePieceSet) {
                    listOfPieces += currentPiece.getLosesTo() + " ";
                }
            }
        }
        return listOfPieces;
    }
}
