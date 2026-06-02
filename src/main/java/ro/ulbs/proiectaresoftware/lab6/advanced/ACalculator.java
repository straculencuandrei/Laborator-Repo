package main.java.ro.ulbs.proiectaresoftware.lab6.advanced;

public abstract class ACalculator<T> {
    protected Object state;

    public abstract ACalculator<T> init();

    @SuppressWarnings("unchecked")
    public T result() {
        return (T)state;
    }

    public void clear() {
        state = null;
    }

}
