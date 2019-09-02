import Objects.Observable;
import Objects.Subsciber;
import Objects.Tuple;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 7/23/2019
 * Description: Controller for the Application handling all business logic.
 * @Author Elias Afzalzada
 */
public class Controller implements Subsciber<Tuple<ActionEnum,String>> {
    private Observable<Contextualizable> stateSubscribers = new Observable<>();

    @Override
    public void onData(Tuple<ActionEnum,String> data) {
        ActionEnum actionEnum = data.left;
        String information = data.right;
        switch (actionEnum){
            case actionByComputer:

                break;
            case actionByPlayer:

                break;
            case newPlayer:
                Player player =  new Player(information);
                stateSubscribers.newData(player);
                break;
        }
        //do stuff with new data

    }

    @Override
    public void onError(Exception error) {
        //catch errors
    }

    public void addSubscriber(State state) {
        stateSubscribers.subscribe(state);
    }
}
