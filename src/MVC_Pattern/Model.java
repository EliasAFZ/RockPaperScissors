package MVC_Pattern;

import java.lang.reflect.Array;
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
    final private GamePiece[] gamePieceSet1 = new GamePiece[]{rock, paper, scissors};

    final private GamePiece fire = new GamePiece("fire", "air", "water");
    final private GamePiece water = new GamePiece("water", "fire", "air");
    final private GamePiece air = new GamePiece("air", "water", "fire");
    final private GamePiece[] gamePieceSet2 = new GamePiece[]{fire, water, air};

    private ArrayList<GamePiece> activeGamePieceSet = new ArrayList<>();
    private HashMap<String, Player> playerMap = new HashMap<>();
    private Player currentActivePlayer;

    //TODO: temp value
    private String matchResult = "error ifs not hit";

    Model() {
        Player cpu = new Player("Cpu");
        playerMap.put("Cpu", cpu);
        loadGamePieceSet();
    }

    void createPlayer(String playerName) {
        Player player = new Player(playerName);
        playerMap.put(playerName, player);
    }

    void setCurrentActivePlayer(String playerName){
        currentActivePlayer = playerMap.get(playerName);
    }

    void loadGamePieceSet(){
        // if current arr list is empty load the default set which is set 1
        if(activeGamePieceSet.isEmpty()){
            for(GamePiece gp : gamePieceSet1){
                activeGamePieceSet.add(gp);
            }
        }
    }

    void loadGamePieceSet(GamePiece[] gamePieceArray){
            for(GamePiece gp : gamePieceSet1){
                activeGamePieceSet.add(gp);
            }
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

    String retrieveMatchResults(String p1SelectedPiece, String p2SelectedPiece) {
        GamePiece p1GamePiece =  toGamePiece(p1SelectedPiece);
        GamePiece p2GamePiece =  toGamePiece(p2SelectedPiece);
        //TODO: BUG fix if statements not getting hit
        if (p1GamePiece.getWinsAgainst().equalsIgnoreCase(p2GamePiece.getPieceName()) &&
                p2GamePiece.getLosesTo().equalsIgnoreCase(p1GamePiece.getPieceName())) {
            matchResult = "Player one Winner!";
        } else if (p2GamePiece.getWinsAgainst().equalsIgnoreCase(p1GamePiece.getPieceName()) &&
                   p1GamePiece.getLosesTo().equalsIgnoreCase(p2GamePiece.getPieceName())){
            matchResult = "Player two Winner!";
        } else if (p1SelectedPiece.equalsIgnoreCase(p2SelectedPiece)) {
            matchResult = "Game is a Tie!";
        }
        return matchResult;
    }

    //TODO: String Literals need to be changed to enums for type errors and readability
    void updatePlayerStats() {
        Player cpu = playerMap.get("Cpu");
        currentActivePlayer.incrementTotalMatches();
        cpu.incrementTotalMatches();
        if(matchResult.equalsIgnoreCase("Player one Winner!")){
            currentActivePlayer.incrementWinStat();
            cpu.incrementLoseStat();
            switchGamePieceSet();
        } else if(matchResult.equalsIgnoreCase("Player two Winner!")){
            cpu.incrementWinStat();
            currentActivePlayer.incrementLoseStat();
        } else if (matchResult.equalsIgnoreCase("Game is a Tie!")){
            currentActivePlayer.incrementTieStat();
            cpu.incrementTieStat();
        }
    }

    void switchGamePieceSet(){

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
