package students;

import java.util.Objects;

public class Student {
    int id;
    String prenume;
    String nume;
    String formatieDeStudiu;
    double medie;

    public Student(int id, String prenume, String nume, String formatieDeStudiu) {
        this.id = id;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.medie = 0.0;
    }

    public Student(int id, String prenume, String nume, String formatieDeStudiu, double medie) {
        this.id = id;
        this.prenume = prenume;
        this.nume = nume;
        this.formatieDeStudiu = formatieDeStudiu;
        this.medie = medie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Double.compare(student.medie, medie) == 0 &&
                Objects.equals(prenume, student.prenume) &&
                Objects.equals(nume, student.nume) &&
                Objects.equals(formatieDeStudiu, student.formatieDeStudiu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prenume, nume, formatieDeStudiu, medie);
    }

    @Override
    public String toString() {
        return id + " " + prenume + " " + nume + " (" + formatieDeStudiu + ") " + medie;
    }
}