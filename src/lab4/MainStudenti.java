package lab4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainStudenti {

    public static float gasesteNota(String prenume, String nume, Map<String, Student> mapStudenti) {
        HashMap<String, Student> cautareMap = new HashMap<>();

        for (Student s : mapStudenti.values()) {
            String cheie = s.getPrenume() + "-" + s.getNume();
            cautareMap.put(cheie, s);
        }

        String cheieCautata = prenume + "-" + nume;
        Student studentGasit = cautareMap.get(cheieCautata);

        if (studentGasit != null) {
            return studentGasit.getNota();
        }
        return 0.0f;
    }

    public static void main(String[] args) {
        HashMap<String, Student> studenti = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader("studenti.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    Student s = new Student(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim());
                    studenti.put(data[0].trim(), s);
                }
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fisierului studenti.txt");
        }

        try (BufferedReader br = new BufferedReader(new FileReader("note_anon.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 2) {
                    String matricol = data[0].trim();
                    float nota = Float.parseFloat(data[1].trim());

                    if (studenti.containsKey(matricol)) {
                        studenti.get(matricol).setNota(nota);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Eroare la citirea fisierului note_anon.txt");
        }

        for (Student s : studenti.values()) {
            System.out.println(s);
        }

        float notaM = gasesteNota("Bianca", "Popescu", studenti);
        float notaN = gasesteNota("Ioan", "Popa", studenti);

        System.out.println("Nota Bianca Popescu: " + notaM);
        System.out.println("Nota Ioan Popa: " + notaN);
    }
}