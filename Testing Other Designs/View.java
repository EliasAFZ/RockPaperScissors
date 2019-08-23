import Objects.Observable;
import Objects.Subsciber;
import Objects.Tuple;

import java.util.Scanner;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 7/16/2019
 * Description: View handling displaying the current state.
 * @Author Elias Afzalzada
 */

// Only console based view for first iteration.
public class View implements Subsciber<Tuple<String,Contextualizable>> {
    private boolean roundGoing = true;
    private Scanner userInput = new Scanner(System.in);
    private Observable<Tuple<ActionEnum,String>> controllerSubscriptions = new Observable<>();
    public void start() {

        System.out.println("Welcome to a weird version of Rock/Paper/Scissors/?");
        System.out.println("Game description bla bla bla");
        System.out.print("Please enter your gaming handle: ");
        String playerHandle = userInput.nextLine();
        System.out.print("Hello there " + playerHandle);

        controllerSubscriptions.newData(new Tuple<>(ActionEnum.newPlayer, playerHandle));
        while (roundGoing){
            // main program loop
            // do stuff here


        }
        //handle new data and send it to state by using controllerSubscriptions
    }

    public void addSubscriber(Controller controller) {
        controllerSubscriptions.subscribe(controller);
    }

    @Override
    public void onData(Tuple<String,Contextualizable> data) {
        // check the string for who is who and update with object data

        System.out.println(data.left);
        if(data.left.equals(Player.class.getName())){
            Player pl = (Player) data.right;
            //display data from player
            if(pl.isWinner()){
                roundGoing = false;
            }
        }else if(data.left.equals(GamePiece.class.getName())){
            GamePiece gp = (GamePiece) data.right;
        }else if(data.left.equals(Computer.class.getName())){

        }
    }

    @Override
    public void onError(Exception error) {

    }
}
