import Objects.Observable;
import Objects.Subsciber;
import Objects.Tuple;

import java.util.HashMap;

/**
 * Project Name: RockPaperScissorsGame
 * Date: 7/16/2019
 * Description: State holds the current state of the application
 * @Author Elias Afzalzada
 */

public class State implements Subsciber<Contextualizable> {

    private HashMap<String, Contextualizable> stateMap = new HashMap<>();
    private Observable<Tuple<String,Contextualizable>> viewSubscriptions = new Observable<>();

    public void addState(String _name, Contextualizable _obj){
        stateMap.put(_name, _obj);
    }

    public Contextualizable getState(String _name){
        return stateMap.get(_name);
    }


    public void addSubscriber(View view) {
        viewSubscriptions.subscribe(view);
    }

    private void stateChanged(){
        stateMap.forEach((key,value) -> viewSubscriptions.newData(new Tuple<>(key, value)));
    }

    @Override
    public void onData(Contextualizable data) {
        stateChanged();
    }

    @Override
    public void onError(Exception error) {
        //
    }
}
