package MVC_Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/20/2019
 * Description: Model class which represented our game in this case.
 * Any or all business logic along with game state was kept/done here.
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

    final private GamePiece spock = new GamePiece("spock", "wizard", "lizard");
    final private GamePiece lizard = new GamePiece("lizard", "spock", "wizard");
    final private GamePiece wizard = new GamePiece("wizard", "lizard", "spock");
    final private GamePiece[] gamePieceSet3 = new GamePiece[]{spock, lizard, wizard};

    private GamePiece[][] allAvailableSets = {gamePieceSet1, gamePieceSet2, gamePieceSet3};
    private ArrayList<GamePiece> activeGamePieceSet = new ArrayList<>();
    private HashMap<String, Player> playerMap = new HashMap<>();
    private Player currentActivePlayer;
    private String matchResult;


    Model() {
        createPlayer("Cpu");
        clearCurrentAndLoadGamePieceSet(gamePieceSet1);
    }

    public void createPlayer(String playerName) {
        Player player = new Player(playerName);
        playerMap.put(playerName, player);
    }

    public boolean containsName(String playerName) {
        return (playerMap.containsKey(playerName));
    }

    public void setCurrentActivePlayer(String playerName) {
        currentActivePlayer = playerMap.get(playerName);
    }

    public void clearCurrentAndLoadGamePieceSet(GamePiece[] gamePieceToLoad) {
        // if current arr list is not empty clear it first then load in an array
        if (!activeGamePieceSet.isEmpty()) {
            activeGamePieceSet.clear();
        }
        activeGamePieceSet.addAll(Arrays.asList(gamePieceToLoad));
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
        } else if (matchResult.equalsIgnoreCase("Player two Wins!")) {
            cpu.incrementWinStat();
            currentActivePlayer.incrementLoseStat();
        } else if (matchResult.equalsIgnoreCase("Game is a Tie!")) {
            currentActivePlayer.incrementTieStat();
            cpu.incrementTieStat();
        }
        currentActivePlayer.setWinRate();
        cpu.setWinRate();
    }

    public void switchGamePieceSet(String playerChoice) {
        switch (playerChoice) {
            case "gamepieceset1" -> clearCurrentAndLoadGamePieceSet(gamePieceSet1);
            case "gamepieceset2" -> clearCurrentAndLoadGamePieceSet(gamePieceSet2);
            case "gamepieceset3" -> clearCurrentAndLoadGamePieceSet(gamePieceSet3);
        }
    }

    public boolean containsPiece(String playerSelectedPiece) {
        for (GamePiece gamePiece : activeGamePieceSet) {
            if (playerSelectedPiece.equalsIgnoreCase(gamePiece.getPieceName())) {
                return true;
            }
        }
        return false;
    }

    public Player getCurrentActivePlayer() {
        return currentActivePlayer;
    }

    public GamePiece toGamePiece(String gamePieceName) {
        for (GamePiece currentPiece : activeGamePieceSet) {
            if (currentPiece.getPieceName().equalsIgnoreCase(gamePieceName)) {
                return currentPiece;
            }
        }
        // returning null is normally bad however this allows me to catch that a piece wasn't assigned
        return null;
    }

    public String toStringListGamePieces(Controller.Condition condition) {
        StringBuilder listOfPieces = new StringBuilder();
        switch (condition) {
            case pieceNames -> {
                for (GamePiece currentPiece : activeGamePieceSet) {
                    listOfPieces.append(currentPiece.getPieceName() + " ");
                }
            }
            case winsAgainst -> {
                for (GamePiece currentPiece : activeGamePieceSet) {
                    listOfPieces.append(currentPiece.getWinsAgainst() + " ");
                }
            }
            case losesAgainst -> {
                for (GamePiece currentPiece : activeGamePieceSet) {
                    listOfPieces.append(currentPiece.getLosesTo() + " ");
                }
            }
            case allSetArraysGamePieces -> {
                int currentSetNum = 1;
                for (GamePiece[] currentSetPieceArr : allAvailableSets) {
                    listOfPieces.append("GamePieceSet" + currentSetNum + ": ");
                    for (GamePiece currentPiece : currentSetPieceArr) {
                        listOfPieces.append(currentPiece.getPieceName() + " ");
                    }
                    listOfPieces.append("\n");
                    currentSetNum++;
                }
            }
        }
        return listOfPieces.toString();
    }

    public Player[] getAllPlayers() {
        Player[] playerArr = new Player[playerMap.size()];
        playerMap.values().toArray(playerArr);
        return playerArr;
    }

    public String getMatchResults() {
        return matchResult;
    }
}
