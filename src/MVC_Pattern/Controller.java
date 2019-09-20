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

    //enum testing for type safety
    enum Condition {
        names, winsagainst, losesagainst
    }

    void startMenu() {
        String playerResponse = vw.startGameQuestion();
        // Switch expression new in java 12
        switch (playerResponse.toLowerCase()) {
            case "yes" -> {
                String playerName = vw.retrievePlayerName();
                ml.createPlayer(playerName);
                ml.setCurrentActivePlayer(playerName);
                gameLoop(playerResponse);
            }
            case "no" -> vw.viewJustLooking();
            default -> {
                vw.incorrectPlayerResponse(playerResponse);
                startMenu();
            }
        }
    }

    private void gameLoop(String playerResponse) {
        while (playerResponse.equalsIgnoreCase("yes") || playerResponse.equalsIgnoreCase("1")) {
            gameCurrentRules();
            gameRoundCheck();
            //switch set method here
            ml.updatePlayerStats();
            vw.endDisplayMenu();
        }
    }

    private void gameCurrentRules() {
        vw.displayGameStatus(ml.numOfGamePieces(), ml.stringGamePieces(Condition.names));
        vw.displayRules(ml.stringGamePieces(Condition.names),
                ml.stringGamePieces(Condition.winsagainst),
                ml.stringGamePieces(Condition.losesagainst));
    }

    private void gameRoundCheck() {
        String p1SelectedPiece = vw.getPlayerPieceChoice();
        String p2SelectedPiece = ml.getCpuPieceChoice();
        if (ml.containsPiece(p1SelectedPiece)) {
            vw.displayPlayerChoices(p1SelectedPiece, p2SelectedPiece);
            String matchResults = ml.retrieveMatchResults(p1SelectedPiece, p2SelectedPiece);
            vw.viewDisplayMatchResults(matchResults);
        } else {
            vw.incorrectPlayerResponse(p1SelectedPiece);
            gameRoundCheck();
        }
    }

    private void endMenu(int playerResponse){
        int endChoice = vw.endDisplayMenu();
        //TODO: BUG on incorrect response after 2nd incorrect response app ends
        switch (endChoice) {
            case 1 -> {
                //play again
                gameLoop(String.valueOf(endChoice));
            }
            case 2 -> {
                //switch players
            }
            case 3 -> {
                //display high scores
            }
            case 4 -> {
                //end game
                vw.viewEnding();
            }
            default -> {
                vw.incorrectPlayerResponse(String.valueOf(endChoice));
                endMenu(endChoice);
                //playerResponse = vw.viewContinueGame();
                //gameLoop(playerResponse);
            }
        }
    }

}