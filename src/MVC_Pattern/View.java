package MVC_Pattern;

import java.util.Scanner;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/20/2019
 * Description: View class anything/everything with displaying to the end user is done here.
 * This class was kept as "dumb" as possible.
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
                "You can switch to a new player and check there everyone's scores at the end.";
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
        String playerHandle = inputScanner.nextLine().toLowerCase();
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


    public String displayAllGameSets(String allGamePieceSets) {
        lineSeparator();
        System.out.println("Congrats on winning now you can switch out to another game piece set!");
        System.out.println("Here are your available game sets to choose from: ");
        System.out.print(allGamePieceSets);
        System.out.println("Please enter your game set of choice!");
        System.out.print("Enter GamePieceSet# (e.g. GamePieceSet1): ");
        return inputScanner.nextLine().toLowerCase();
    }


    public void displayCurrentPlayerStats(Player player) {
        lineSeparator();
        System.out.println("Player: " + player.getPlayerName());
        System.out.println("Total Matches: " + player.getTotalMatches());
        System.out.print("Win Rate: ");
        System.out.printf("%.2f", player.getWinRate());
        System.out.println("%");
        System.out.println("Total Wins: " + player.getNumOfWins());
        System.out.println("Total Losses: " + player.getNumOfLosses());
        System.out.println("Total Ties: " + player.getNumOfTies());
        lineSeparator();
    }

    public void displayAllPlayersScores(Player[] playerArr) {
        for (Player currentSelectedPlayer : playerArr) {
            displayCurrentPlayerStats(currentSelectedPlayer);
        }
    }

    public String endDisplayMenu() {
        lineSeparator();
        System.out.println("END MENU: Enter the correlating number to your choice.");
        System.out.println("1: Keep playing with the same player?");
        System.out.println("2: Switch to a new player?");
        System.out.println("3: Display current players scores?");
        System.out.println("4: Display all stored players scores?");
        System.out.println("5: Exit Game");
        System.out.print("Enter option: ");
        return inputScanner.nextLine();
    }


    public void incorrectPlayerResponse(String incorrectResponse) {
        System.out.println(incorrectResponse + " is an invalid response. Please enter a valid response!");
    }


    public void emptyPlayerName() {
        System.out.println("You entered an emtpy name please enter another name.");
    }


    public String playerAlreadyExists(String playerName) {
        lineSeparator();
        System.out.print(playerName + " already exists would you like to switch to that player? (Yes/No): ");
        return inputScanner.nextLine().toLowerCase();
    }


    public void viewJustLooking() {
        lineSeparator();
        System.out.println("Thank you for checking out my game!");
    }


    public void viewEnding() {
        System.out.println("Thank you for playing!");
    }


    private void lineSeparator() {
        System.out.println("-------------------------------------------------------------------------------");
    }
}