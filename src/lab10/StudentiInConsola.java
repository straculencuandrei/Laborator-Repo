package lab10;

import java.util.List;

public class StudentiInConsola implements IStudentiExport {
    @Override
    public void doExport(List<Student> studenti) {
        if (studenti == null) return;
        for (Student s : studenti) {
            System.out.println(s.toString());
        }
    }
}