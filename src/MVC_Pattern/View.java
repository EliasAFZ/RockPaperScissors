package MVC_Pattern;

import java.util.Scanner;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/3/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */

// Only console based view for first iteration.
class View {

    private Scanner inputScanner = new Scanner(System.in);

    View() {
        welcomeDisplay();
    }

    private void welcomeDisplay() {
        String welcomeMessage = "\nWelcome to a weird game of Rock/Paper/Scissors/? \n\n" +
                "Game description: So this game is based on the original rules that rock beats \n" +
                "scissor, paper beats rock, scissors beats paper, etc. However in this version \n" +
                "you may switch to a new set of pieces each time you win! So for example lets say \n" +
                "currently rock, paper, and scissors are in play. You can switch them out for fire, \n" +
                "water, and air. You can also have a combination of whatever set pieces are available. \n";
        System.out.println(welcomeMessage);
    }

    String startGameQuestion() {
        System.out.print("Would you like to play?(Yes/No): ");
        return inputScanner.nextLine().toLowerCase();
    }

    void incorrectViewResponse(String incorrectResponse) {
        System.out.println(incorrectResponse + " is an invalid response. Please enter a valid response!");
    }

    String retrievePlayerName() {
        System.out.print("Please enter your gaming handle: ");
        String playerHandle = inputScanner.nextLine();
        System.out.println("Hello there " + playerHandle + "! \n");
        return playerHandle;
    }

    void gameViewStatus(int numOfGamePieces, String gamePieces) {
        System.out.println("Alright so currently their are " + numOfGamePieces + " game pieces, \n" +
                "they are: " + gamePieces);
    }

    void gameViewRules(String gamePieces, String gamePieceWinRules, String gamePieceLoseRules) {
        System.out.println("The rules for these pieces follow:\n" + " ");
        System.out.println("RULES");
        System.out.println("Game Pieces: " + gamePieces);
        System.out.println("Wins against: " + gamePieceWinRules);
        System.out.println("Loses against: " + gamePieceLoseRules + "\n");

    }

    String getPlayePieceChoice() {
        System.out.print("Please enter your game piece choice: ");
        return inputScanner.nextLine().toLowerCase();
    }

    void gameViewSelectWinner() {
        System.out.println("The winner is: " + "winnername");
    }

    void gameViewSelectLoser() {
        System.out.println("The loser is: " + "losername");
    }

    String gameViewContinueGame() {
        System.out.print("Would you like to keep playing?(Yes/No): ");
        return inputScanner.nextLine().toLowerCase();
    }

    void gameViewJustLooking() {
        System.out.println("Thank you for checking out my game!");
    }

    void gameViewEnding() {
        System.out.println("Thank you for playing!");
    }
}