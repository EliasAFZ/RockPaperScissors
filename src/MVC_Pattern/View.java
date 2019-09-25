package MVC_Pattern;

import java.util.Scanner;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/20/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */

// Only console based view for first iteration.
public class View {

    private Scanner inputScanner = new Scanner(System.in);

    View() {
        welcomeDisplay();
    }


    private void welcomeDisplay() {
        String welcomeMessage = "Welcome to a weird game of Rock/Paper/Scissors/?\n" +
                "Game description: So this game is based on the original rules that rock beats \n" +
                "scissor, paper beats rock, scissors beats paper, etc. However in this version \n" +
                "you may switch to a new set of pieces each time you win! So for example lets \n" +
                "say currently rock, paper, and scissors are in play. You can switch them out for \n" +
                "fire, water, and air. You can switch to whatever possible game sets are available. \n" +
                "You can switch to a new player and check there respective scores at the end.";
        lineSeparator();
        System.out.println(welcomeMessage);
        lineSeparator();
    }


    public String startGameQuestion() {
        System.out.print("Would you like to play?(Yes/No): ");
        return inputScanner.nextLine().toLowerCase();
    }


    public String retrievePlayerName() {
        lineSeparator();
        System.out.print("Please enter your gaming handle: ");
        String playerHandle = inputScanner.nextLine();
        System.out.println("Hello there " + playerHandle + "!");
        return playerHandle;
    }


    public void displayGameStatus(int numOfGamePieces, String gamePieces) {
        lineSeparator();
        System.out.println("\nCurrently their are " + numOfGamePieces + " game pieces, \n" +
                "they are: " + gamePieces);
    }


    public void displayRules(String gamePieces, String gamePieceWinRules, String gamePieceLoseRules) {
        System.out.println("The rules for these pieces follow:\n");
        System.out.println("RULES read from top to bottom");
        System.out.println("Game Pieces: " + gamePieces);
        System.out.println("Wins against: " + gamePieceWinRules);
        System.out.println("Loses against: " + gamePieceLoseRules + "\n");
        lineSeparator();
    }


    public String getPlayerPieceChoice() {
        System.out.print("Please enter your game piece choice: ");
        return inputScanner.nextLine().toLowerCase();
    }


    public void displayPlayerChoices(String playerName, String p1Piece, String p2Piece) {
        lineSeparator();
        System.out.println(playerName + " chose: " + p1Piece);
        System.out.println("Cpu chose: " + p2Piece);
    }


    public void viewDisplayMatchResults(String matchResults) {
        System.out.println("The match result is: " + matchResults);
    }


    public void switchGamePieceSet() {
        System.out.println("Congrats on winning now you can switch out to another game piece set!");
    }


    public void displayCurrentPlayerStats() {
        System.out.println("stats are bla bla");
    }


    public String endDisplayMenu() {
        lineSeparator();
        System.out.println("END MENU: Enter the correlating number to your choice");
        System.out.println("1: keep playing?");
        System.out.println("2: Switch players?");
        System.out.println("3: Display scores?");
        System.out.println("4: Exit Game");
        System.out.print("Enter option: ");
        return inputScanner.nextLine();
    }


    public void incorrectPlayerResponse(String incorrectResponse) {
        System.out.println(incorrectResponse + " is an invalid response. Please enter a valid response!");
    }


    public void incorrectPlayerName() {
        System.out.println("You entered an emtpy name or it already exists enter another name.");
    }


    public void viewJustLooking() {
        lineSeparator();
        System.out.println("Thank you for checking out my game!");
    }


    public void viewEnding() {
        System.out.println("Thank you for playing!");
    }


    public void lineSeparator() {
        System.out.println("-------------------------------------------------------------------------------");
    }
}