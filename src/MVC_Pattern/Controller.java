package MVC_Pattern;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/20/2019
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

    //enum testing for type safety
    public enum Condition {
        names, winsagainst, losesagainst
    }


    public void runStart() {
        String playerResponse = vw.startGameQuestion();
        // Switch expression new in java 12
        switch (playerResponse.toLowerCase()) {
            case "yes" -> {
                createPlayer();
                gameLoop();
            }
            case "no" -> vw.viewJustLooking();
            default -> {
                vw.incorrectPlayerResponse(playerResponse);
                runStart();
            }
        }
    }


    private void createPlayer() {
        String playerName = vw.retrievePlayerName();
        if (!ml.containsNameOrIsBlank(playerName)) {
            ml.createPlayer(playerName);
            ml.setCurrentActivePlayer(playerName);
        } else {
            vw.incorrectPlayerName();
            createPlayer();
        }
    }


    private void gameLoop() {
        gameCurrentRules();
        gameRoundCheck();
        //switch set method here
        ml.updatePlayerStats();
        endMenu();
    }


    private void gameCurrentRules() {
        vw.displayGameStatus(ml.numOfGamePieces(), ml.toStringListGamePieces(Condition.names));
        vw.displayRules(ml.toStringListGamePieces(Condition.names),
                ml.toStringListGamePieces(Condition.winsagainst),
                ml.toStringListGamePieces(Condition.losesagainst));
    }

    //TODO: messy code needs more variables for readability, less functional style.
    private void gameRoundCheck() {
        String p1SelectedPiece = vw.getPlayerPieceChoice();
        String p2SelectedPiece = ml.getCpuPieceChoice();
        if (ml.containsPiece(p1SelectedPiece)) {
            vw.displayPlayerChoices(ml.getCurrentActivePlayer().getPlayerName(),p1SelectedPiece, p2SelectedPiece);
            String matchResults = ml.retrieveMatchResults(p1SelectedPiece, p2SelectedPiece);
            vw.viewDisplayMatchResults(matchResults);
        } else {
            vw.incorrectPlayerResponse(p1SelectedPiece);
            gameRoundCheck();
        }
    }

    private void endMenu() {
        String endChoice = vw.endDisplayMenu().toLowerCase();
        switch (endChoice) {
            case "1" -> {
                //play again
                gameLoop();
            }
            case "2" -> {
                //switch to new player
                createPlayer();
                endMenu();
            }
            case "3" -> {
                //display current player scores
                vw.displayCurrentPlayerStats(ml.getCurrentActivePlayer());
                endMenu();
            }
            case "4" -> {
                //display all players scores
                vw.displayAllPlayersScores(ml.getAllPlayers());
                endMenu();
            }
            case "5" -> {
                //end game
                vw.viewEnding();
            }
            default -> {
                vw.incorrectPlayerResponse(endChoice);
                endMenu();
            }
        }
    }
}