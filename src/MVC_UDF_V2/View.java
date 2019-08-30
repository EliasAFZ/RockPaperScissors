package MVC_UDF_V2;


/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/29/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */

// Only console based view for first iteration.
public class View {

    Action action;

    View(Action action){
       this.action= action;
    }

    public void brazzers(){
        action.addPlayer("YEET");
    }

}