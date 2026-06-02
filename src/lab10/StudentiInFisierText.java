package lab10;

import java.util.List;

public class StudentiInFisierText implements IStudentiExport {
    private final String fileName;
    public StudentiInFisierText(String fileName) { this.fileName = fileName; }
    public void doExport(List<Student> studenti) {
        System.out.println("Exporting to text file: " + fileName);
    }
}
