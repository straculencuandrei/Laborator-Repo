package students;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> studentsSet = new HashSet<>();
        studentsSet.add(new Student(420, "Andrei", "Straculencu", "TI22/1"));

        Student studentCautat1 = new Student(420, "Andrei", "Straculencu", "TI22/1");
        Student studentCautat2 = new Student(418, "Razvan", "Straculencu", "TI22/1");

        System.out.println("Este Andrei in set? " + cautaStudent(studentsSet, studentCautat1));
        System.out.println("Este Razvan in set? " + cautaStudent(studentsSet, studentCautat2));

        Set<StudentBursier> bursieri = new HashSet<>();
        bursieri.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        bursieri.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        bursieri.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 9.10, 780.80));

        writeToFile("students_out.txt", studentsSet);
        writeToFile("bursieri_out.txt", bursieri);
    }

    public static boolean cautaStudent(Set<Student> set, Student student) {
        return set.contains(student);
    }

    public static void writeToFile(String filename, Collection<? extends Student> studenti) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Student student : studenti) {
                writer.write(student.toString());
                writer.newLine();
            }
            System.out.println("Salvat in: " + filename);
        } catch (IOException e) {
            System.err.println("Eroare: " + e.getMessage());
        }
    }
}