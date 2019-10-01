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

    //testing enum for type safety
    public enum Condition {
        pieceNames, winsAgainst, losesAgainst, allSetArraysGamePieces
    }


    public void runStart() {
        String playerResponse = vw.startGameQuestion();
        // Switch expression new in java 12
        switch (playerResponse) {
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
        if (!ml.containsName(playerName) && !playerName.isBlank()) {
            ml.createPlayer(playerName);
            ml.setCurrentActivePlayer(playerName);
        } else if (ml.containsName(playerName)) {
            playerAlreadyExistsCheck(vw.playerAlreadyExists(playerName), playerName);
        } else {
            vw.emptyPlayerName();
            createPlayer();
        }
    }

    private void playerAlreadyExistsCheck(String playerResponse, String playerName) {
        switch (playerResponse) {
            case "yes" -> {
                ml.setCurrentActivePlayer(playerName);
            }
            case "no" -> endMenu();
            default -> {
                vw.incorrectPlayerResponse(playerResponse);
                createPlayer();
            }
        }
    }


    private void gameLoop() {
        gameCurrentRules();
        gameRoundCheck();
        ml.updatePlayerStats();
        checkToSwitchSets();
        endMenu();
    }

    private void checkToSwitchSets() {
        String playerChoice;
        String matchResults = ml.getMatchResults();

        if (matchResults.equalsIgnoreCase("Player one Wins!")) {
            playerChoice = vw.displayAllGameSets(ml.toStringListGamePieces(Condition.allSetArraysGamePieces));
            ml.switchGamePieceSet(playerChoice);
            }
        }

    //TODO: messy code needs more variables for readability, less functional style.
    private void gameCurrentRules() {
        vw.displayGameStatus(ml.numOfGamePieces(), ml.toStringListGamePieces(Condition.pieceNames));
        vw.displayRules(ml.toStringListGamePieces(Condition.pieceNames),
                ml.toStringListGamePieces(Condition.winsAgainst),
                ml.toStringListGamePieces(Condition.losesAgainst));
    }

    //TODO: messy code needs more variables for readability, less functional style.
    private void gameRoundCheck() {
        String p1SelectedPiece = vw.getPlayerPieceChoice();
        String p2SelectedPiece = ml.getCpuPieceChoice();
        String matchResults;

        if (ml.containsPiece(p1SelectedPiece)) {
            vw.displayPlayerChoices(ml.getCurrentActivePlayer().getPlayerName(), p1SelectedPiece, p2SelectedPiece);
            matchResults = ml.retrieveMatchResults(p1SelectedPiece, p2SelectedPiece);
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