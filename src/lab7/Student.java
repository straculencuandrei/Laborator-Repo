package lab7;

public final class Student {

    private final String nume;
    private final String formatieDeStudiu;

    public Student(String nume, String formatieDeStudiu) {
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
    }

    public String getNume() {
        return nume;
    }

    public String getFormatieDeStudiu() {
        return formatieDeStudiu;
    }

    @Override
    public String toString() {
        return "Student{" + "nume='" + nume + '\'' + ", formatie='" + formatieDeStudiu + '\'' + '}';
    }
}