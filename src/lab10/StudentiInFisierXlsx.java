package lab10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StudentiInFisierXlsx implements IStudentiExport {
    private String fileName;

    public StudentiInFisierXlsx(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void doExport(List<Student> studenti) {
        if (studenti == null) return;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Nume,Prenume,Nota");
            writer.newLine();
            for (Student s : studenti) {
                writer.write(s.getNume() + "," + s.getPrenume() + "," + s.getNota());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}