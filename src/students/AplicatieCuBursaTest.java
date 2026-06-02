package students;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AplicatieCuBursaTest {
    private AplicatieCuBursa appCuBursa;

    @BeforeEach
    public void setUp() {
        appCuBursa = new AplicatieCuBursa();
    }

    @AfterEach
    public void tearDown() {
        appCuBursa = null;
    }

    @Test
    @DisplayName("Test sorteaza with generated data")
    public void testSortTest1() {
        //arrange
        List<StudentBursier> lista = appCuBursa.genereaza();
        
        //act
        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);
        
        //assert - parcurgem lista sortata si verificam daca satisface conditiile de comparare
        Assertions.assertNotNull(sortata);
        Assertions.assertEquals(5, sortata.size());
        
        // Verificam ca formatiile sunt in ordine
        for (int i = 0; i < sortata.size() - 1; i++) {
            StudentBursier s1 = sortata.get(i);
            StudentBursier s2 = sortata.get(i + 1);
            
            // Daca formatiile sunt diferite, s1 trebuie sa vina inaintea lui s2
            int cmpFormatia = s1.formatieDeStudiu.compareTo(s2.formatieDeStudiu);
            if (cmpFormatia != 0) {
                Assertions.assertTrue(cmpFormatia < 0, 
                    "Format " + s1.formatieDeStudiu + " should come before " + s2.formatieDeStudiu);
            } else {
                // Daca formatiile sunt aceleasi, verificam numele
                int cmpNume = s1.nume.compareTo(s2.nume);
                if (cmpNume != 0) {
                    Assertions.assertTrue(cmpNume < 0,
                        "Name " + s1.nume + " should come before " + s2.nume);
                } else {
                    // Daca numele sunt aceleasi, verificam prenumele
                    int cmpPrenume = s1.prenume.compareTo(s2.prenume);
                    if (cmpPrenume != 0) {
                        Assertions.assertTrue(cmpPrenume < 0,
                            "First name " + s1.prenume + " should come before " + s2.prenume);
                    }
                }
            }
        }
    }

    @Test
    @DisplayName("Test sorteaza does not modify original list")
    public void testSorteazaDoesNotModifyOriginal() {
        //arrange
        List<StudentBursier> lista = appCuBursa.genereaza();
        List<StudentBursier> listaCopy = new ArrayList<>(lista);
        
        //act
        appCuBursa.sorteaza(lista);
        
        //assert - lista originala nu trebuie modificata
        Assertions.assertEquals(listaCopy.size(), lista.size());
        for (int i = 0; i < lista.size(); i++) {
            Assertions.assertEquals(listaCopy.get(i), lista.get(i));
        }
    }

    @Test
    @DisplayName("Test sorteaza returns all elements")
    public void testSorteazaReturnsAllElements() {
        //arrange
        List<StudentBursier> lista = appCuBursa.genereaza();
        int originalSize = lista.size();
        
        //act
        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);
        
        //assert
        Assertions.assertEquals(originalSize, sortata.size());
    }

    @Test
    @DisplayName("Test sorteaza with custom data")
    public void testSorteazaCustomData() {
        //arrange
        List<StudentBursier> lista = new ArrayList<>();
        lista.add(new StudentBursier(1, "Ana", "Popescu", "ISM141/2", 8.5, 500.0));
        lista.add(new StudentBursier(2, "Bogdan", "Popa", "ISM141/2", 9.0, 600.0));
        lista.add(new StudentBursier(3, "Ana", "Popa", "ISM141/1", 8.9, 550.0));
        
        //act
        List<StudentBursier> sortata = appCuBursa.sorteaza(lista);
        
        //assert
        // ISM141/1 should come before ISM141/2
        Assertions.assertEquals("ISM141/1", sortata.get(0).formatieDeStudiu);
        Assertions.assertEquals("ISM141/2", sortata.get(1).formatieDeStudiu);
        Assertions.assertEquals("ISM141/2", sortata.get(2).formatieDeStudiu);
    }

    @Test
    @DisplayName("Test genereaza returns non-empty list")
    public void testGenereazaReturnsNonEmptyList() {
        //arrange & act
        List<StudentBursier> lista = appCuBursa.genereaza();
        
        //assert
        Assertions.assertNotNull(lista);
        Assertions.assertTrue(lista.size() > 0);
        Assertions.assertEquals(5, lista.size());
    }

    @Test
    @DisplayName("Test all students in generated list are valid")
    public void testGenereazaStudentsValid() {
        //arrange & act
        List<StudentBursier> lista = appCuBursa.genereaza();
        
        //assert
        for (StudentBursier student : lista) {
            Assertions.assertNotNull(student.nume);
            Assertions.assertNotNull(student.prenume);
            Assertions.assertNotNull(student.formatieDeStudiu);
            Assertions.assertTrue(student.medie > 0 && student.medie <= 10, "Note should be between 0 and 10");
            Assertions.assertTrue(student.getCuantumBursa() > 0, "Scholarship should be positive");
        }
    }
}
