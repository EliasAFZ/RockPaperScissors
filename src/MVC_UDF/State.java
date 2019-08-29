package MVC_UDF;

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
    final private GamePiece rock = new GamePiece("Rock", "Paper", "scissors");
    final private GamePiece paper = new GamePiece("Paper", "Scissors", "Rock");
    final private GamePiece scissors = new GamePiece("Scissors", "Rock", "Paper");

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

    public void gameIsRunning(){
        vw.gameViewRunning(gamePieceArrayList.size(), "test");
    }

    public void gameIsEnding(){
        gamePieceArrayList.clear();
        vw.gameViewEnding();
    }

    public void startGameQuestion(){
        vw.startGameQuestion();
    }

    public void incorrectResponse(String incorrectResponse){
        vw.incorrectViewResponse(incorrectResponse);

    }

    public void retrievePlayerName(){
        vw.retrievePlayerName();
    }

    public void gameJustLooking(){
        vw.gameViewJustLooking();
    }

}
