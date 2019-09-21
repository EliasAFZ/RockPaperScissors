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
        String welcomeMessage = "Welcome to a weird game of Rock/Paper/Scissors/?\n" +
                "Game description: So this game is based on the original rules that rock beats \n" +
                "scissor, paper beats rock, scissors beats paper, etc. However in this version \n" +
                "you may switch to a new set of pieces each time you win! So for example lets say \n" +
                "currently rock, paper, and scissors are in play. You can switch them out for fire, \n" +
                "water, and air. You can switch to whatever possible game sets are available. \n" +
                "You can switch to a new player and check there respective scores at the end.";
        lineSeparatorWelcomeDisplay();
        System.out.println(welcomeMessage);
        lineSeparatorWelcomeDisplay();
    }

    String startGameQuestion() {
        System.out.print("Would you like to play?(Yes/No): ");
        return inputScanner.nextLine().toLowerCase();
    }

    void incorrectPlayerResponse(String incorrectResponse) {
        System.out.println(incorrectResponse + " is an invalid response. Please enter a valid response!");
        lineSeparator();
    }

    String retrievePlayerName() {
        lineSeparator();
        System.out.print("Please enter your gaming handle: ");
        String playerHandle = inputScanner.nextLine();
        System.out.println("Hello there " + playerHandle + "!");
        return playerHandle;
    }

    void displayGameStatus(int numOfGamePieces, String gamePieces) {
        lineSeparator();
        System.out.println("\nCurrently their are " + numOfGamePieces + " game pieces, \n" +
                "they are: " + gamePieces);
    }

    void displayRules(String gamePieces, String gamePieceWinRules, String gamePieceLoseRules) {
        System.out.println("The rules for these pieces follow:\n");
        System.out.println("RULES read from top to bottom");
        System.out.println("Game Pieces: " + gamePieces);
        System.out.println("Wins against: " + gamePieceWinRules);
        System.out.println("Loses against: " + gamePieceLoseRules + "\n");
        lineSeparator();
    }

    String getPlayerPieceChoice() {
        System.out.print("Please enter your game piece choice: ");
        return inputScanner.nextLine().toLowerCase();
    }

    void displayPlayerChoices(String p1Piece, String p2Piece){
        lineSeparator();
        System.out.println("P1  chose: " + p1Piece);
        System.out.println("Cpu chose: " + p2Piece);
    }

    void viewDisplayMatchResults(String matchResults){
        System.out.println("The match result is: " + matchResults);
    }

    void displayCurrentPlayerStats(String playerName,
                                   int highScore,
                                   int totalMatches,
                                   int winRate,
                                   int wins,
                                   int losses,
                                   int ties){
        lineSeparator();
        System.out.println("Player Name: " + playerName);
        System.out.println("High Score: " + highScore);
        System.out.println("Total Matches: " + totalMatches);
        System.out.println("Win Rate: " + winRate);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Ties: " + ties);
    }

    void displayCurrentPlayerStats(Player player){
        lineSeparator();
        System.out.println("Player Name: " + player.getPlayerName());
        System.out.println("High Score: " + player.getPlayerHighScore());
        System.out.println("Total Matches: " + player.getTotalMatches());
        System.out.println("Win Rate: " + player.getWinRate());
        System.out.println("Wins: " + player.getNumOfWins());
        System.out.println("Losses: " + player.getNumOfLosses());
        System.out.println("Ties: " + player.getNumOfTies());
    }

    void switchGamePieceSet(){
        System.out.println("Congrats on winning now you can switch out to another game piece set!");
    }

    String endDisplayMenu(){
        lineSeparator();
        System.out.println("END MENU: Enter the correlating number to your choice");
        System.out.println("1: keep playing?");
        System.out.println("2: Switch to new player?");
        System.out.println("3: Display scores?");
        System.out.println("4: Exit Game");
        System.out.print("Enter option: ");
        return inputScanner.nextLine();
    }

    void nameAlreadyExistsDisplay(String playerInput){
        System.out.println(playerInput + " already exists please enter another name!");
    }

    void blankStringDisplay(){
        System.out.println("You entered an empty string please enter something!");
    }

    void viewJustLooking() {
        lineSeparator();
        System.out.println("Thank you for checking out my game!");
    }

    void viewEnding() {
        lineSeparator();
        System.out.println("Thank you for playing!");
        lineSeparator();
    }

    void lineSeparator(){
        System.out.println("------------------------------------------------------------");
    }

    void lineSeparatorWelcomeDisplay(){
        System.out.println("--------------------------------------------------------------------------------------");
    }

}