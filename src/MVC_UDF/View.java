package MVC_UDF;

import java.util.Scanner;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/16/2019
 * Description: View handling displaying the current state.
 *
 * @Author Elias Afzalzada
 */

// Only console based view for first iteration.
public class View {

    private static Controller cr = new Controller();
    private Scanner userInput = new Scanner(System.in);

    public void welcomeDisplay() {
        String welcomeMessage = "\nWelcome to a weird version of Rock/Paper/Scissors/? \n\n" +
                "Game description: So this version is based of the original rules that rock beats \n" +
                "scissor, paper beats rock, scissors beats paper, etc. However in this version \n" +
                "you may add a new piece each time you win! So when you win you get to name \n" +
                "said new piece and declare its strength/weakness the only caveat would be that \n" +
                "you may not add a piece that is essentially the same as another piece already in play.\n";
        System.out.println(welcomeMessage);
    }

    public void setInitialAppView() {
        welcomeDisplay();
        System.out.print("Would you like to play?(Yes/No): ");
        String playerResponse = userInput.nextLine();
        cr.startGameResponse(playerResponse);
    }

    public void gameViewRunning(){
        //Player setup
        System.out.print("Please enter your gaming handle: ");
        String playerHandle = userInput.nextLine();
        System.out.println("Hello there " + playerHandle + ".");
        cr.createPlayer(playerHandle);


    }

//System.out.println("Alright ready, here we go!" +
    //"\n3..." +
    //"\n2..." +
    //"\n1...");

}
