package MVC_Pattern;

import java.util.Random;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/3/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */
public class Controller {

    private View vw;
    private Model ml;

    Controller(View vw, Model ml) {
        this.vw = vw;
        this.ml = ml;
    }


    public void startMenu() {
        String playerResponse = vw.startGameQuestion();

        // Switch expression new in java 12
        switch (playerResponse.toLowerCase()) {
            case "yes" -> {
                ml.createPlayer(vw.retrievePlayerName());
                ml.createPlayer("Computer");
                gameLoop(playerResponse);
            }
            case "no" -> vw.gameViewJustLooking();
            default -> {
                vw.incorrectViewResponse(playerResponse);
                startMenu();
            }
        }

    }

    public void gameLoop(String playerResponse) {
        while(playerResponse.equalsIgnoreCase("yes")){
            vw.gameViewStatus(ml.numOfGamePieces(), ml.currentGamePieces("names"));
            vw.gameViewRules(ml.currentGamePieces("names"), ml.currentGamePieces("winsAgainst"),ml.currentGamePieces("losesAgainst"));
            gameCheck();


            playerResponse = vw.gameViewContinueGame();
        }
        vw.gameViewEnding();
    }

    public void gameCheck() {
        Random randGen = new Random();
        String p1SelectedPiece = vw.gameViewStartRound();
        ml.getPiece(p1SelectedPiece);
        //String p2SelectedPiece = randGen.nextInt(ml.numOfGamePieces());
    }


}