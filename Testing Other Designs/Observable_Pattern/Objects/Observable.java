package Objects;


import java.util.ArrayList;

public class Observable<GenericType> {

    ArrayList<Subsciber<GenericType>> subs = new ArrayList<>();


    public void newData(GenericType data){
        subs.forEach(subs -> subs.onData(data));
    }

    public void OnError(Exception err){
        subs.forEach(subsciber -> subsciber.onError(err));
    }

    public void subscribe(Subsciber sub){
        subs.add(sub);
    }

}
