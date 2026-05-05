package proiectaresoftware;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Student {
    private String nume;
    private int nota;

    public Student(String nume, int nota) {
        this.nume = nume;
        this.nota = nota;
    }

    public String getNume() { return nume; }
    public int getNota() { return nota; }

    @Override
    public String toString() {
        return "Student{" + "nume='" + nume + '\'' + ", nota=" + nota + '}';
    }
}

public class StudentiExcel {

    public static void writeToXls(Set<Student> studenti, String xlsFileName) throws Exception {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Studenti");
            int rowNum = 0;

            Row header = sheet.createRow(rowNum++);
            header.createCell(0).setCellValue("Nume");
            header.createCell(1).setCellValue("Nota");

            for (Student s : studenti) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(s.getNume());
                row.createCell(1).setCellValue(s.getNota());
            }

            try (FileOutputStream fos = new FileOutputStream(xlsFileName)) {
                workbook.write(fos);
            }
        }
    }

    public static List<Student> readFromXls(String xlsFileName) throws Exception {
        List<Student> students = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(xlsFileName);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    String nume = "";
                    int nota = 0;

                    Cell cellNume = row.getCell(0);
                    if (cellNume != null) {
                        nume = cellNume.getStringCellValue();
                    }

                    Cell cellNota = row.getCell(1);
                    if (cellNota != null) {
                        nota = (int) cellNota.getNumericCellValue();
                    }

                    students.add(new Student(nume, nota));
                }
            }
        }
        return students;
    }

    public static void main(String[] args) {
        try {
            Set<Student> studenti = new HashSet<>();
            studenti.add(new Student("Popescu Ion", 10));
            studenti.add(new Student("Ionescu Maria", 9));

            String xlsFileName = "laborator8_students.xlsx";

            writeToXls(studenti, xlsFileName);

            List<Student> studentsFromXls = readFromXls(xlsFileName);
            System.out.println("\nStudenti cititi din xlsx:");
            for (Student st : studentsFromXls) {
                System.out.println(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}