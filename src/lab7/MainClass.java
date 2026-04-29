package lab7;

import java.util.HashSet;
import java.util.Set;

public class MainClass {

    static Student schimbaFormatia(Student st, String nouaFormatieDeStudiu) {
        return new Student(st.getNume(), nouaFormatieDeStudiu);
    }

    static Set<Student> imparteInDouaFormatii(Set<Student> studenti, String formatia1, String formatia2) {
        Set<Student> studentiNoi = new HashSet<>();

        int size = studenti.size();
        int limitaJumatate = (size / 2) + (size % 2);

        int count = 0;
        for (Student s : studenti) {
            if (count < limitaJumatate) {
                studentiNoi.add(schimbaFormatia(s, formatia1));
            } else {
                studentiNoi.add(schimbaFormatia(s, formatia2));
            }
            count++;
        }

        return studentiNoi;
    }

    public static void main(String[] args) {
        System.out.println("--- 7.6.2 Singleton ---");
        PasswordMaker pm2 = PasswordMaker.getInstance();
        System.out.println("Generated password 1: " + PasswordMaker.getInstance().getPassword());
        System.out.println("Generated password 2: " + PasswordMaker.getInstance().getPassword());
        System.out.println("Generated password 3: " + pm2.getPassword());
        System.out.println("getInstance() a fost apelata de: " + PasswordMaker.getCallingCounts() + " ori.");

        System.out.println("\n--- 7.6.3 Imutabilitate ---");
        Set<Student> studenti = new HashSet<>();
        studenti.add(new Student("Popescu Ion", "Generala"));
        studenti.add(new Student("Ionescu Ana", "Generala"));
        studenti.add(new Student("Vasile Mihai", "Generala"));
        studenti.add(new Student("Marinescu Elena", "Generala"));
        studenti.add(new Student("Stan Andrei", "Generala"));

        System.out.println("Lista initiala de studenti:");
        for(Student s : studenti) { System.out.println(s); }

        studenti = imparteInDouaFormatii(studenti, "TI 211_1", "TI 211_2");

        System.out.println("\nNoua lista dupa reimpartirea pe grupe:");
        for(Student s : studenti) { System.out.println(s); }
    }
}