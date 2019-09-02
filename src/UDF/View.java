package UDF;

import java.util.Scanner;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/29/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */

// Only console based view for first iteration.
public class View {

    private Controller cr;
    private Scanner inputScanner = new Scanner(System.in);

    View(Controller cr){
        this.cr = cr;
       //TODO: set view actions
    }







    public void welcomeDisplay() {
        String welcomeMessage = "\nWelcome to a weird game of Rock/Paper/Scissors/? \n\n" +
                "Game description: So this version is based on the original rules that rock beats \n" +
                "scissor, paper beats rock, scissors beats paper, etc. However in this version \n" +
                "you may add a new piece each time you win! So when you win you get to name \n" +
                "said new piece and declare its strength/weakness the only caveat would be that \n" +
                "you may not add a piece that is essentially the same as another piece already in play.\n";
        System.out.println(welcomeMessage);
    }

    public void setInitialAppView() {
        welcomeDisplay();
        startGameQuestion();
    }

    public void startGameQuestion() {
        System.out.print("Would you like to play?(Yes/No): ");
        String playerResponse = inputScanner.nextLine();
        //cr.startGameResponse(playerResponse);
    }

    public void incorrectViewResponse(String incorrectResponse) {
        System.out.println(incorrectResponse + " is an invalid response. Please enter a valid response!");
    }

    public void retrievePlayerName() {
        System.out.print("Please enter your gaming handle: ");
        String playerHandle = inputScanner.nextLine();
        System.out.println("Hello there " + playerHandle + "! \n");
        //cr.createPlayer(playerHandle);
    }

    public void gameViewStatus(int numOfGamePieces, String gamePieces) {
        System.out.println("Alright so currently their are " + numOfGamePieces + " game pieces, \n" +
                "they are: " + gamePieces);
    }

    public void gameViewRules(String gamePieces, String gamePieceWinRules, String gamePieceLoseRules) {
        System.out.println("The rules for these pieces follow:\n"
                + " ");


        System.out.println("Game Pieces: " + gamePieces);
        System.out.println("Wins against: " + gamePieceWinRules);
        System.out.println("Loses against: " + gamePieceLoseRules);

    }

    public void gameViewStartRound() {

    }

    public void gameViewSelectWinner() {

    }

    //public String gameViewContinueGame() {
        //System.out.print("Would you like to keep playing?(Yes/No): ");
        //String playerResponse = userInput.nextLine();
        //return playerResponse;
    //}

    public void gameViewRunning(int numOfGamePieces, String gamePieces, String gamePieceWinRules, String gamePieceLoseRules) {
        gameViewStatus(numOfGamePieces, gamePieces);
        gameViewRules(gamePieces, gamePieceWinRules, gamePieceLoseRules);
        //gameViewStartRound();
        //gameViewSelectWinner();
        //cr.gameLoop(gameViewContinueGame());

    }

    public void gameViewEnding() {
        System.out.println("Thank you for playing!");
    }

    public void gameViewJustLooking() {
        System.out.println("Thank you for checking out my game!");
    }

}