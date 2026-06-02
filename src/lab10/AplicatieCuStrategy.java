package lab10;

import java.util.Arrays;
import java.util.List;

class StudentiDinFisierText implements IStudentiImport {
    private final String fileName;
    public StudentiDinFisierText(String fileName) { this.fileName = fileName; }
    public List<Student> doImport() {
        System.out.println("Importing from text file: " + fileName);
        return List.of(new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 8.90));
    }
}

class StudentiDinFisierXlsx implements IStudentiImport {
    private final String fileName;
    public StudentiDinFisierXlsx(String fileName) { this.fileName = fileName; }
    public List<Student> doImport() {
        System.out.println("Importing from excel file: " + fileName);
        return List.of(new Student(1025, "Andrei", "Popa", "ISMI41/2", 8.70));
    }
}

public class AplicatieCuStrategy {
    public static void main(String[] args) {
        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISMI41/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 8.90),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 10.0),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10.0),
                new Student(1029, "Maria", "Pana", "TI131/2", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
        );

        Exporter exporter = new Exporter();

        IStudentiExport strategyConsole = new StudentiInConsola();
        exporter.startExport(strategyConsole, studenti);

        String textFileOut = "studentiStrategyText.txt";
        IStudentiExport strategyFisierText = new StudentiInFisierText(textFileOut);
        exporter.startExport(strategyFisierText, studenti);

        String excelFileOut = "studentiStrategyExcel.xlsx";
        IStudentiExport strategyFisierExcel = new StudentiInFisierXlsx(excelFileOut);
        exporter.startExport(strategyFisierExcel, studenti);
    }
}