package MVC_UDF;

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
    private Computer cpu = new Computer();
    private HashMap<String, Player> playerMap = new HashMap<>();
    private HashMap<String, GamePiece> gamePieceMap = new HashMap<>();
    final private GamePiece rock = new GamePiece("Rock", "Paper", "scissors");
    final private GamePiece paper = new GamePiece("Paper", "Scissors", "Rock");
    final private GamePiece scissors = new GamePiece("Scissors", "Rock", "Paper");

    public void setInitialAppState() {
        gamePieceMap.put("Rock", rock);
        gamePieceMap.put("Paper", paper);
        gamePieceMap.put("Scissors", scissors);
        vw.setInitialAppView();
    }

    public void createStatePlayer(String playerHandle) {
        Player p1 = new Player(playerHandle);
        playerMap.put(playerHandle, p1);
    }

    public void gameIsRunning(){
        vw.gameViewRunning(gamePieceMap.size(), gamePieceMap.keySet().toString());
    }

    public void gameIsEnding(){
        gamePieceMap.clear();
        vw.gameViewEnding();
    }

    public void incorrectResponse(String incorrectResponse){
        vw.continueGameQuestion(incorrectResponse);
    }

}
