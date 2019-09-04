package MVC_Pattern;


/**
 * Project Name: RockPaperScissorsGame
 * Date: 9/3/2019
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


    public void gameLoop(){
        vw.welcomeDisplay();
    }

    public void update(){

    }

}