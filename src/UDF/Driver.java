package UDF;


/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/29/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */

public class Driver {
    public static void main(String[] args) {
        State st = new State();
        Controller cr = new Controller(st);
        View vw = new View(cr);
    }
}
