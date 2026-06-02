package lab10;

import java.util.List;

public class StudentiInFisierXlsx implements IStudentiExport {
    private final String fileName;
    public StudentiInFisierXlsx(String fileName) { this.fileName = fileName; }
    public void doExport(List<Student> studenti) {
        System.out.println("Exporting to excel file: " + fileName);
    }
}
