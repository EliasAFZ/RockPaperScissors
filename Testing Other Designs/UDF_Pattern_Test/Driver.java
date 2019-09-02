package State_Pattern;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/16/2019
 * Description: Driver class, normally in MVC you just create all the references to
 * the objects for model/view and pass them to controller however I wanted to explore
 * unidirectional data flow so for this all the driver contains is a reference to the
 * controller and calls the launch method to set it all off.
 *
 * @Author Elias Afzalzada
 */

public class Driver {
    public static void main(String[] args) {
        Controller cr = new Controller();
        cr.Launch();
    }
}
