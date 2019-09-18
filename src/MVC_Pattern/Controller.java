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
                String playerName = "";
                playerName = vw.retrievePlayerName();
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
        while (playerResponse.equalsIgnoreCase("yes")) {
            gameCurrentRules();
            gameRoundCheck();
            ml.updatePlayerStats();
            playerResponse = vw.viewContinueGame();

            //TODO: BUG on incorrect response after 2nd incorrect response app ends
            if(playerResponse.equalsIgnoreCase("yes")){
                continue;
            } else if(playerResponse.equalsIgnoreCase("no")){
                vw.viewEnding();
            } else {
                vw.incorrectPlayerResponse(playerResponse);
                playerResponse = vw.viewContinueGame();
                gameLoop(playerResponse);
            }

            /**switch (playerResponse.toLowerCase()) {
                case "yes" -> {
                    continue;
                }
                case "no" -> vw.gameViewEnding();
                default -> {
                    vw.incorrectViewResponse(playerResponse);
                    playerResponse = vw.gameViewContinueGame();
                    gameLoop(playerResponse);
                }
            }**/

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
        String matchResults = "";
        if (ml.containsPiece(p1SelectedPiece)) {
            vw.displayPlayerChoices(p1SelectedPiece, p2SelectedPiece);
            matchResults = ml.retrieveMatchResults(p1SelectedPiece, p2SelectedPiece);
            vw.viewDisplayMatchResults(matchResults);
        } else {
            vw.incorrectPlayerResponse(p1SelectedPiece);
            gameRoundCheck();
        }
    }

}