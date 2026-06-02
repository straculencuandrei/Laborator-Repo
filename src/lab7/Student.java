package lab7;

public record Student(String nume, String formatieDeStudiu) {

    @Override
    public String toString() {
        return "Student{" + "nume='" + nume + '\'' + ", formatie='" + formatieDeStudiu + '\'' + '}';
    }
}