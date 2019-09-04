package MVC_Pattern;


/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/3/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */

public class Driver {
    public static void main(String[] args) {
        View vw = new View();
        Model ml = new Model();
        Controller cr = new Controller(vw, ml);

        cr.gameLoop();
    }
}
