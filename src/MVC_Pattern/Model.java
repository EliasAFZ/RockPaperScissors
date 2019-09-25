package MVC_Pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/20/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */

public class Model {

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
        createPlayer("Cpu");
        loadGamePieceSet();
    }

    public void createPlayer(String playerName) {
            Player player = new Player(playerName);
            playerMap.put(playerName, player);
    }

    public boolean containsNameOrIsBlank(String playerName){
        return (playerMap.containsKey(playerName) || playerName.isBlank());
    }

    public void setCurrentActivePlayer(String playerName) {
        currentActivePlayer = playerMap.get(playerName);
    }

    public void loadGamePieceSet() {
        // if current arr list is empty load the default set which is set 1
        if (activeGamePieceSet.isEmpty()) {
            for(GamePiece gp : gamePieceSet1) {
                activeGamePieceSet.add(gp);
            }
        }
    }

    public void loadGamePieceSet(GamePiece[] gamePieceArray) {
        for (GamePiece gp : gamePieceSet1) {
            activeGamePieceSet.add(gp);
        }
    }

    public int numOfGamePieces() {
        return activeGamePieceSet.size();
    }

    public String getCpuPieceChoice() {
        Random randGen = new Random();
        int randPieceIndex = randGen.nextInt(activeGamePieceSet.size());
        GamePiece cpuChosenPiece = activeGamePieceSet.get(randPieceIndex);
        return cpuChosenPiece.getPieceName();
    }

    public String retrieveMatchResults(String p1SelectedPiece, String p2SelectedPiece) {
        GamePiece p1GamePiece = toGamePiece(p1SelectedPiece);
        GamePiece p2GamePiece = toGamePiece(p2SelectedPiece);
        //TODO: BUG fix if statements not getting hit
        if (p1GamePiece.getWinsAgainst().equalsIgnoreCase(p2GamePiece.getPieceName()) &&
                p2GamePiece.getLosesTo().equalsIgnoreCase(p1GamePiece.getPieceName())) {
            matchResult = "Player one Wins!";
        } else if (p2GamePiece.getWinsAgainst().equalsIgnoreCase(p1GamePiece.getPieceName()) &&
                p1GamePiece.getLosesTo().equalsIgnoreCase(p2GamePiece.getPieceName())) {
            matchResult = "Player two Wins!";
        } else if (p1SelectedPiece.equalsIgnoreCase(p2SelectedPiece)) {
            matchResult = "Game is a Tie!";
        }
        return matchResult;
    }

    //TODO: String Literals need to be changed to enums for type errors and readability
    public void updatePlayerStats() {
        Player cpu = playerMap.get("Cpu");
        currentActivePlayer.incrementTotalMatches();
        cpu.incrementTotalMatches();
        if (matchResult.equalsIgnoreCase("Player one Wins!")) {
            currentActivePlayer.incrementWinStat();
            cpu.incrementLoseStat();
            switchGamePieceSet();
        } else if (matchResult.equalsIgnoreCase("Player two Wins!")) {
            cpu.incrementWinStat();
            currentActivePlayer.incrementLoseStat();
        } else if (matchResult.equalsIgnoreCase("Game is a Tie!")) {
            currentActivePlayer.incrementTieStat();
            cpu.incrementTieStat();
        }
    }

    public void switchGamePieceSet() {

    }

    public boolean containsPiece(String playerSelectedPiece) {
        for (GamePiece gamePiece : activeGamePieceSet) {
            if (playerSelectedPiece.equalsIgnoreCase(gamePiece.getPieceName())) {
                return true;
            }
        }
        return false;
    }

    public Player getCurrentActivePlayer(){
        return currentActivePlayer;
    }

    //TODO: returning null is bad possible other solution?
    public GamePiece toGamePiece(String gamePieceName) {
        for (GamePiece currentPiece : activeGamePieceSet) {
            if (currentPiece.getPieceName().equalsIgnoreCase(gamePieceName)) {
                return currentPiece;
            }
        }
        return null;
    }

    public String toStringListGamePieces(Controller.Condition condition) {
        StringBuilder listOfPieces = new StringBuilder();
        switch (condition) {
            case names -> {
                for (GamePiece currentPiece : activeGamePieceSet) {
                    listOfPieces.append(currentPiece.getPieceName() + " ");
                }
            }
            case winsagainst -> {
                for (GamePiece currentPiece : activeGamePieceSet) {
                    listOfPieces.append(currentPiece.getWinsAgainst() + " ");
                }
            }
            case losesagainst -> {
                for (GamePiece currentPiece : activeGamePieceSet) {
                    listOfPieces.append(currentPiece.getLosesTo() + " ");
                }
            }
        }
        return listOfPieces.toString();
    }
}
