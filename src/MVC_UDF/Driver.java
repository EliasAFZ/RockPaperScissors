package MVC_UDF;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/16/2019
 * Description: Plug and play driver that can be switched out for testing.
 *
 * @Author Elias Afzalzada
 */

public class Driver {
    public static void main(String[] args) {
        Controller cr = new Controller();
        cr.Launch();
    }
}
