package lab9;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

class Student {
    int id;
    String nume;
    String prenume;
    String grupa;
    double nota;

    public Student(int id, String prenume, String nume, String grupa, double nota) {
        this.id = id;
        this.prenume = prenume;
        this.nume = nume;
        this.grupa = grupa;
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return prenume + " " + nume + " (Nota: " + nota + ")";
    }
}

