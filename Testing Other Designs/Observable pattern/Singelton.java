/**
 * Name: RockPaperScissorsGame
 * Date: 7/24/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */
public class Singelton {

    private static State state = null;

    public static State getState() {
        if(state == null){
            return new State();
        }
        return state;
    }
}
