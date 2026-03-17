import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //O(1) hash
        Set<Student> studentsSet = new HashSet<>();

        studentsSet.add(new Student(420, "Andrei", "Straculencu", "TI22/1"));

        Student studentCautat1 = new Student(420, "Andrei", "Straculencu", "TI22/1");
        Student studentCautat2 = new Student(418, "Razvan", "Straculencu", "TI22/1");

        System.out.println("Este Andrei in set? " + cautaStudent(studentsSet, studentCautat1));
        System.out.println("Este Razvan in set? " + cautaStudent(studentsSet, studentCautat2));
    }

    public static boolean cautaStudent(Set<Student> set, Student student) {
        return set.contains(student);
    }
}