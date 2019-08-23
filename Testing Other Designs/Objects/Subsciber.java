package Objects;

public interface Subsciber<GenericType> {
    public void onData(GenericType data);
    public void onError(Exception error);
}
