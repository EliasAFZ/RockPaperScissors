package MVC_UDF_V2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/16/2019
 * Description: State holds the current state of the application
 *
 * @Author Elias Afzalzada
 */

public class State {
    private static View vw = new View();
    private HashMap<String, Player> playerMap = new HashMap<>();
    private ArrayList<GamePiece> gamePieceArrayList = new ArrayList<>();
    final private GamePiece rock = new GamePiece("Rock", "scissors", "paper");
    final private GamePiece paper = new GamePiece("Paper", "rock", "scissors");
    final private GamePiece scissors = new GamePiece("Scissors", "paper", "rock");

    public void setInitialAppState() {
        gamePieceArrayList.add(rock);
        gamePieceArrayList.add(paper);
        gamePieceArrayList.add(scissors);
        vw.setInitialAppView();
    }

    public void createStatePlayer(String playerHandle) {
        Player computer = new Player("Computer");
        Player player = new Player(playerHandle);
        playerMap.put(playerHandle, player);
        playerMap.put("Computer", computer);
    }

    public void gameIsRunning() {
        String gamePieceList = "", gamePieceWinRules = "", gamePieceLoseRules = "";
        for (GamePiece currentPiece : gamePieceArrayList) {
            gamePieceList += currentPiece.getPieceName() + " ";
            gamePieceWinRules += currentPiece.getWinsAgainst() + " ";
            gamePieceLoseRules += currentPiece.getLosesTo() + " ";
        }
        vw.gameViewRunning(gamePieceArrayList.size(), gamePieceList, gamePieceWinRules, gamePieceLoseRules);
    }

    public void gameIsEnding() {
        gamePieceArrayList.clear();
        vw.gameViewEnding();
    }

    public void startGameQuestion() {
        vw.startGameQuestion();
    }

    public void incorrectResponse(String incorrectResponse) {
        vw.incorrectViewResponse(incorrectResponse);

    }

    public void retrievePlayerName() {
        vw.retrievePlayerName();
    }

    public void gameJustLooking() {
        vw.gameViewJustLooking();
    }

}
