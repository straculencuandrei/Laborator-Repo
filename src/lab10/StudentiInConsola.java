package lab10;

import java.util.List;

// Adaugat public la clasele de strategii ca sa le poata instantia lab11
public class StudentiInConsola implements IStudentiExport {
    public void doExport(List<Student> studenti) {
        for (Student s : studenti) {
            System.out.println(s);
        }
    }
}
