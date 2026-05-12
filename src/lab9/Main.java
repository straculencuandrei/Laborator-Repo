package lab9;

import lab9.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        problemaUnu();
        System.out.println();
        problemaDoi();
        System.out.println();
        problemaTrei();
    }

    public static void problemaUnu() {
        List<Integer> numere = new Random().ints(10, 5, 26).boxed().collect(Collectors.toList());
        System.out.println("Lista initiala: " + numere);

        int suma = numere.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Suma: " + suma);

        int max = numere.stream().max(Integer::compareTo).orElse(0);
        int min = numere.stream().min(Integer::compareTo).orElse(0);
        System.out.println("Maxim: " + max + " Minim: " + min);

        List<Integer> interval = numere.stream().filter(n -> n >= 10 && n <= 20).collect(Collectors.toList());
        System.out.println("Elemente in intervalul 10-20: " + interval);

        List<Double> numereDouble = numere.stream().map(Integer::doubleValue).collect(Collectors.toList());
        System.out.println("Lista ca Double: " + numereDouble);

        boolean contine12 = numere.stream().anyMatch(n -> n == 12);
        System.out.println("Contine 12: " + contine12);
    }

    public static void problemaDoi() {
        String text = "Acesta este un program scris in java pentru expresii lambda";
        List<String> cuvinte = Arrays.asList(text.split(" "));

        List<String> filtrate = cuvinte.stream().filter(c -> c.length() >= 5).collect(Collectors.toList());
        System.out.println("S-au gasit " + filtrate.size() + " cuvinte cu lungimea >= 5: " + filtrate);

        List<String> ordonate = filtrate.stream().sorted().collect(Collectors.toList());
        System.out.println("Cuvinte ordonate: " + ordonate);

        String incepeCuP = cuvinte.stream().filter(c -> c.startsWith("p")).findFirst().orElse("");
        System.out.println("Cuvant care incepe cu p: " + incepeCuP);
    }

    public static void problemaTrei() {
        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISM141/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10),
                new Student(1029, "Maria", "Pana", "TI131/2", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
        );

        System.out.println("Studenti cu nota 10:");
        studenti.stream().filter(s -> s.getNota() == 10).forEach(System.out::println);

        System.out.println("Studenti cu nota sub 5:");
        studenti.stream().filter(s -> s.getNota() < 5).forEach(System.out::println);

        List<Student> studentiModificati = studenti.stream().map(s -> {
            if (s.getNota() < 4) {
                return new Student(s.id, s.prenume, s.nume, s.grupa, 4.0);
            }
            return s;
        }).collect(Collectors.toList());

        System.out.println("Studenti dupa mapare (nota minima 4):");
        studentiModificati.forEach(System.out::println);

        double sumaNote = studenti.stream().map(Student::getNota).reduce(0.0, Double::sum);
        System.out.println("Suma tuturor notelor: " + sumaNote);

        double media = sumaNote / studenti.size();
        System.out.println("Media notelor: " + media);
    }
}