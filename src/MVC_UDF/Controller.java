package MVC_UDF;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/23/2019
 * Description: Controller for the Application handling all business logic.
 *
 * @Author Elias Afzalzada
 */
public class Controller {

    private static State st = new State();

    public void Launch() {
        st.setInitialAppState();
    }

    public void createPlayer(String playerHandle) {
        st.createStatePlayer(playerHandle);
    }

    public void startGameResponse(String playerResponse) {
        if (playerResponse.equalsIgnoreCase("yes")) {
            st.gameIsRunning();
        } else if (playerResponse.equalsIgnoreCase("no")) {
            st.gameIsEnding();
        } else {
            st.incorrectResponse(playerResponse);
        }

    }


}
