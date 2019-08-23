package MVC_UDF;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/23/2019
 * Description: mvc.Controller for the Application handling all business logic.
 *
 * @Author Elias Afzalzada
 */
public class Controller {

    private static State st = new State();

    public void Launch() {
        st.setInitialAppState();
    }

    public void startGameResponse(String playerResponse){
        if(playerResponse.equalsIgnoreCase("yes")){
            st.startGame();
        }
        else if(playerResponse.equalsIgnoreCase("no")){
            st.endGame();
        }
        else{
            st.incorrectResponse();
        }
    }

    public void createPlayer(String playerHandle) {
        st.createStatePlayer(playerHandle);
    }

}
