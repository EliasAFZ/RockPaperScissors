package MVC_Pattern;

import java.util.Random;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/3/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */
class Controller {

    private View vw;
    private Model ml;

    Controller(View vw, Model ml) {
        this.vw = vw;
        this.ml = ml;
    }


    void startMenu() {
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

    //enum testing for type safety
    enum Condition {
        names, winsagainst, losesagainst
    }

    private void gameLoop(String playerResponse) {

        while (playerResponse.equalsIgnoreCase("yes")) {
            vw.gameViewStatus(ml.numOfGamePieces(),
                    ml.currentGamePieces(Condition.names));
            vw.gameViewRules(ml.currentGamePieces(Condition.names),
                    ml.currentGamePieces(Condition.winsagainst),
                    ml.currentGamePieces(Condition.losesagainst));
            gameCheck();


            playerResponse = vw.gameViewContinueGame();
        }
        vw.gameViewEnding();
    }

    private void gameCheck() {
        Random randGen = new Random();
        String p1SelectedPiece = vw.gameViewStartRound();
        if (ml.containsPiece(p1SelectedPiece)) {
            ml.retrieveWinLoseConditions(p1SelectedPiece);
        } else {
            vw.incorrectViewResponse(p1SelectedPiece);
            gameCheck();
        }
        //String p2SelectedPiece = randGen.nextInt(ml.numOfGamePieces());
    }

}