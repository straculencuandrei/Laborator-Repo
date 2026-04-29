package lab7;

public class PasswordMaker {

    private static PasswordMaker instance;
    private static int callingCounts = 0;

    static {
        instance = new PasswordMaker();
    }

    private PasswordMaker() {
    }

    public static PasswordMaker getInstance() {
        callingCounts++;
        return instance;
    }

    public static int getCallingCounts() {
        return callingCounts;
    }

    public String getPassword() {
        return "pass_" + (Math.random() * 1000);
    }
}