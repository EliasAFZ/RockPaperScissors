
/**
 * Project Name: RockPaperScissorsGame
 * Date: 7/16/2019
 * Description: Plug and play driver that can be switched out for testing.
 * @Author Elias Afzalzada
 */

public class Driver {
    public static void main(String[] args) {
        Controller controller = new Controller();
        State state = Singelton.getState();
        View view = new View();

        //Add subscribers
        view.addSubscriber(controller);
        state.addSubscriber(view);
        controller.addSubscriber(state);


        view.start();
    }
}
