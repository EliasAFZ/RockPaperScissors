package MVC_Pattern;

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
                    ml.stringGamePieces(Condition.names));
            vw.gameViewRules(ml.stringGamePieces(Condition.names),
                    ml.stringGamePieces(Condition.winsagainst),
                    ml.stringGamePieces(Condition.losesagainst));
            gameCheck();
            //updateStats();
            playerResponse = vw.gameViewContinueGame();
        }
        vw.gameViewEnding();
    }

    private void gameCheck() {
        String p1SelectedPiece = vw.getPlayePieceChoice();
        String p2SelectedPiece = ml.getCpuPieceChoice();
        String matchResults;
        if (ml.containsPiece(p1SelectedPiece)) {
            matchResults = ml.retrieveMatchResults(p1SelectedPiece, p2SelectedPiece);
            //TODO: remove test
            System.out.println(matchResults);
        } else {
            vw.incorrectViewResponse(p1SelectedPiece);
            gameCheck();
        }
    }
}