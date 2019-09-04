package MVC_Pattern;


/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/3/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */
public class Controller {

    private View vw;
    private Model ml;

    Controller(View vw, Model ml) {
        this.vw = vw;
        this.ml = ml;
    }


    public void startMenu() {
        String playerResponse = vw.startGameQuestion();

        //if (playerResponse.equalsIgnoreCase("yes")) {
        //    vw.retrievePlayerName();
        //} else if (playerResponse.equalsIgnoreCase("no")) {
        //    vw.gameViewJustLooking();
        //} else {
        //    vw.incorrectViewResponse(playerResponse);
        //    startMenu();
        //}

        // Switch expression new in java
        switch (playerResponse.toLowerCase()){
            case "yes" -> vw.retrievePlayerName();
            case "no" -> vw.gameViewJustLooking();
            default -> {
                vw.incorrectViewResponse(playerResponse);
                startMenu();
            }
            //default -> throw new IllegalStateException("Unexpected value: " + playerResponse.toLowerCase());
        }

    }

    public void gameLoop() {

    }

    public void update() {

    }

    public void createPlayer(String playerHandle) {

    }


}