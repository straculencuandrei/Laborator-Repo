package lab7;

public abstract class Form {

    private static int counter = 0;

    public Form() {
        counter++;
    }

    public static int getInstanceCount() {
        return counter;
    }

    public abstract double getArea();
}