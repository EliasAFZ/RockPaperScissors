package MVC_Pattern;


/**
 * Project Name: RockPaperScissorsGame
 * Date: 8/29/2019
 * Description:
 *
 * @Author Elias Afzalzada
 */
public class Controller{

    private View vw;
    private Model ml;

    Controller(View vw, Model ml){
        this.vw = vw;
        this.ml = ml;
    }


}