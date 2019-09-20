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
                "water, and air. You can also have a combined combination of the previous mention sets. \n";
        System.out.println(welcomeMessage);
    }

    String startGameQuestion() {
        System.out.print("Would you like to play?(Yes/No): ");
        return inputScanner.nextLine().toLowerCase();
    }

    void incorrectPlayerResponse(String incorrectResponse) {
        System.out.println(incorrectResponse + " is an invalid response. Please enter a valid response!");
    }

    String retrievePlayerName() {
        System.out.print("Please enter your gaming handle: ");
        String playerHandle = inputScanner.nextLine();
        System.out.println("Hello there " + playerHandle + "! \n");
        return playerHandle;
    }

    void displayGameStatus(int numOfGamePieces, String gamePieces) {
        System.out.println("Alright so currently their are " + numOfGamePieces + " game pieces, \n" +
                "they are: " + gamePieces);
    }

    void displayRules(String gamePieces, String gamePieceWinRules, String gamePieceLoseRules) {
        System.out.println("The rules for these pieces follow:\n");
        System.out.println("RULES read from top to bottom");
        System.out.println("Game Pieces: " + gamePieces);
        System.out.println("Wins against: " + gamePieceWinRules);
        System.out.println("Loses against: " + gamePieceLoseRules + "\n");

    }

    String getPlayerPieceChoice() {
        System.out.print("Please enter your game piece choice: ");
        return inputScanner.nextLine().toLowerCase();
    }

    void displayPlayerChoices(String p1Piece, String p2Piece){
        System.out.println("P1  chose: " + p1Piece);
        System.out.println("Cpu chose: " + p2Piece);
    }

    void viewDisplayMatchResults(String matchResults){
        System.out.println("The match result is: " + matchResults);
    }

    void displayPlayerStats(){

    }

    void switchGamePieceSet(){
        System.out.println("Congrats on winning now you can switch out to another game piece set!");
    }

    int endDisplayMenu(){
        System.out.println("\nEND MENU: Enter the correlating number for your choice");
        System.out.println("1: keep playing?");
        System.out.println("2: Switch players?");
        System.out.println("3: Display scores?");
        System.out.println("4: Exit Game");
        System.out.print("Enter option: ");
        return inputScanner.nextInt();
    }

    void viewJustLooking() {
        System.out.println("Thank you for checking out my game!");
    }

    void viewEnding() {
        System.out.println("Thank you for playing!");
    }
}