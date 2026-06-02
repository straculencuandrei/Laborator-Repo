package students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AplicatieCuBursa {
    public static void main(String[] args) {
        AplicatieCuBursa instanta = new AplicatieCuBursa();
        List<StudentBursier> lista = instanta.genereaza();
        
        System.out.println("Lista originala:");
        for (StudentBursier student : lista) {
            System.out.println(student);
        }
        
        System.out.println("--------------------------------------------------");
        
        List<StudentBursier> sortata = instanta.sorteaza(lista);
        
        System.out.println("Lista sortata:");
        for (StudentBursier student : sortata) {
            System.out.println(student);
        }
    }

    public List<StudentBursier> genereaza() {
        List<StudentBursier> lista = new ArrayList<>();
        lista.add(new StudentBursier(1025, "Andrei", "Popa", "ISM141/2", 8.70, 725.50));
        lista.add(new StudentBursier(1024, "Ioan", "Mihalcea", "ISM141/1", 9.80, 801.10));
        lista.add(new StudentBursier(1029, "Bianca", "Popescu", "TI131/1", 9.10, 780.80));
        lista.add(new StudentBursier(1026, "Anamaria", "Prodan", "TI131/1", 8.90, 745.50));
        lista.add(new StudentBursier(1030, "Bianca", "Popescu", "TI131/1", 9.10, 100.00));
        return lista;
    }

    public List<StudentBursier> sorteaza(List<StudentBursier> lst) {
        // Creez o copie a listei pentru a nu modifica lista originala
        List<StudentBursier> listaSortata = new ArrayList<>(lst);
        
        // Sorteaza dupa:
        // 1. Formatia de studiu
        // 2. Numele (nume)
        // 3. Prenumele (prenume)
        // 4. Nota
        // 5. Cuantumul bursei
        Collections.sort(listaSortata, (s1, s2) -> {
            // Compara formatia de studiu
            int cmpFormatia = s1.formatieDeStudiu.compareTo(s2.formatieDeStudiu);
            if (cmpFormatia != 0) {
                return cmpFormatia;
            }
            
            // Compara numele
            int cmpNume = s1.nume.compareTo(s2.nume);
            if (cmpNume != 0) {
                return cmpNume;
            }
            
            // Compara prenumele
            int cmpPrenume = s1.prenume.compareTo(s2.prenume);
            if (cmpPrenume != 0) {
                return cmpPrenume;
            }
            
            // Compara nota (descrescator, stiu ca vreau sa vina mai bine la inceput)
            int cmpNota = Double.compare(s2.medie, s1.medie);
            if (cmpNota != 0) {
                return cmpNota;
            }
            
            // Compara cuantumul bursei (descrescator)
            return Double.compare(s2.getCuantumBursa(), s1.getCuantumBursa());
        });
        
        return listaSortata;
    }
}
