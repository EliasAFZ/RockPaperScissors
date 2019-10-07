package MVC_Pattern;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/20/2019
 * Description: Handles Data flow between Model and View. Conditions were checked to determine
 * next direction in program. Controller business logic was kept as minimal as possible.
 * Began following MVC but ended up with more of an MVP or MVVM data flow and kept with it.
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
                gameRound();
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
            case "yes" -> ml.setCurrentActivePlayer(playerName);
            case "no" -> endMenu();
            default -> {
                vw.incorrectPlayerResponse(playerResponse);
                createPlayer();
            }
        }
    }


    private void gameRound() {
        gameCurrentRules();
        gameRoundCheck();
        ml.updatePlayerStats();
        checkToSwitchSets();
        endMenu();
    }


    private void checkToSwitchSets() {
        String playerChoice;
        String matchResults = ml.getMatchResults();
        String allAvailableGamePieces = ml.getCurrentActivePlayer().getPlayerName();

        if (matchResults.equalsIgnoreCase("Player one Wins!")) {
            playerChoice = vw.displayAllGameSets(allAvailableGamePieces);
            ml.switchGamePieceSet(playerChoice);
        }
    }


    private void gameCurrentRules() {
        int currentNumOfGamePieces = ml.numOfGamePieces();
        String currentGamePiecesInPlay = ml.toStringListGamePieces(Condition.pieceNames);
        String gamePiecesWinsAgainst = ml.toStringListGamePieces(Condition.winsAgainst);
        String gamePieceLosesAgainst = ml.toStringListGamePieces(Condition.losesAgainst);

        vw.displayGameStatus(currentNumOfGamePieces, currentGamePiecesInPlay);
        vw.displayRules(currentGamePiecesInPlay, gamePiecesWinsAgainst, gamePieceLosesAgainst);
    }


    private void gameRoundCheck() {
        String currentActivePlayerName = ml.getCurrentActivePlayer().getPlayerName();
        String p1SelectedPiece = vw.getPlayerPieceChoice();
        String p2SelectedPiece = ml.getCpuPieceChoice();
        String matchResults;

        if (ml.containsPiece(p1SelectedPiece)) {
            vw.displayPlayerChoices(currentActivePlayerName, p1SelectedPiece, p2SelectedPiece);
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
                gameRound();
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