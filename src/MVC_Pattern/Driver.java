package MVC_Pattern;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/20/2019
 * Description: Creates handles for view/model and passed them onto controller then starts.
 *
 * @Author Elias Afzalzada
 */

public class Driver {
    public static void main(String[] args) {
        View vw = new View();
        Model ml = new Model();
        Controller cr = new Controller(vw, ml);

        cr.runStart();
    }
}
