package lab4;

import java.util.Objects;

public class Student {
    private String numarMatricol;
    private String prenume;
    private String nume;
    private String grupa;
    private float nota;

    public Student(String numarMatricol, String prenume, String nume, String grupa) {
        this.numarMatricol = numarMatricol;
        this.prenume = prenume;
        this.nume = nume;
        this.grupa = grupa;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getNume() {
        return nume;
    }

    public float getNota() {
        return nota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(numarMatricol, student.numarMatricol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numarMatricol);
    }

    @Override
    public String toString() {
        return "Student{" +
                "numarMatricol='" + numarMatricol + '\'' +
                ", prenume='" + prenume + '\'' +
                ", nume='" + nume + '\'' +
                ", grupa='" + grupa + '\'' +
                ", nota=" + nota +
                '}';
    }
}