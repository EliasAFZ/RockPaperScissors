package MVC_UDF_V2;


/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/23/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */
public class Controller implements Action{

    private State st;

    Controller(State st){
        this.st = st;
    }

    @Override
    public void addPlayer(String playerName) {
        String playername = playerName;
    }

}