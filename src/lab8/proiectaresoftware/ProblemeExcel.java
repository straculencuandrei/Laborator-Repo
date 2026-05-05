package proiectaresoftware;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ProblemeExcel {

    public static void citireSiAfisare(String inputFile) throws Exception {
        try (FileInputStream fis = new FileInputStream(inputFile);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        default:
                            System.out.print(" \t");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void generareCuMediaCalculata(String inputFile, String outputFile) throws Exception {
        try (FileInputStream fis = new FileInputStream(inputFile);
             Workbook workbookIn = new XSSFWorkbook(fis);
             Workbook workbookOut = new XSSFWorkbook()) {

            Sheet sheetIn = workbookIn.getSheetAt(0);
            Sheet sheetOut = workbookOut.createSheet("Sheet1");

            for (int i = 0; i <= sheetIn.getLastRowNum(); i++) {
                Row rowIn = sheetIn.getRow(i);
                Row rowOut = sheetOut.createRow(i);
                if (rowIn != null) {
                    int lastCol = rowIn.getLastCellNum();
                    for (int j = 0; j < lastCol; j++) {
                        Cell cellIn = rowIn.getCell(j);
                        Cell cellOut = rowOut.createCell(j);
                        if (cellIn != null) {
                            switch (cellIn.getCellType()) {
                                case STRING:
                                    cellOut.setCellValue(cellIn.getStringCellValue());
                                    break;
                                case NUMERIC:
                                    cellOut.setCellValue(cellIn.getNumericCellValue());
                                    break;
                                default:
                                    break;
                            }
                        }
                    }

                    if (i > 0 && lastCol >= 3) {
                        double sum = 0;
                        int count = 0;
                        for (int k = lastCol - 3; k < lastCol; k++) {
                            Cell c = rowIn.getCell(k);
                            if (c != null && c.getCellType() == CellType.NUMERIC) {
                                sum += c.getNumericCellValue();
                                count++;
                            }
                        }
                        Cell avgCell = rowOut.createCell(lastCol);
                        if (count > 0) {
                            avgCell.setCellValue(sum / count);
                        }
                    } else if (i == 0) {
                        rowOut.createCell(lastCol).setCellValue("Media Calculata");
                    }
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                workbookOut.write(fos);
            }
        }
    }

    public static void generareCuFormula(String inputFile, String outputFile) throws Exception {
        try (FileInputStream fis = new FileInputStream(inputFile);
             Workbook workbookIn = new XSSFWorkbook(fis);
             Workbook workbookOut = new XSSFWorkbook()) {

            Sheet sheetIn = workbookIn.getSheetAt(0);
            Sheet sheetOut = workbookOut.createSheet("Sheet1");

            for (int i = 0; i <= sheetIn.getLastRowNum(); i++) {
                Row rowIn = sheetIn.getRow(i);
                Row rowOut = sheetOut.createRow(i);
                if (rowIn != null) {
                    int lastCol = rowIn.getLastCellNum();
                    for (int j = 0; j < lastCol; j++) {
                        Cell cellIn = rowIn.getCell(j);
                        Cell cellOut = rowOut.createCell(j);
                        if (cellIn != null) {
                            switch (cellIn.getCellType()) {
                                case STRING:
                                    cellOut.setCellValue(cellIn.getStringCellValue());
                                    break;
                                case NUMERIC:
                                    cellOut.setCellValue(cellIn.getNumericCellValue());
                                    break;
                                default:
                                    break;
                            }
                        }
                    }

                    if (i > 0) {
                        Cell formulaCell = rowOut.createCell(lastCol);
                        formulaCell.setCellFormula("AVERAGE(D" + (i + 1) + ":F" + (i + 1) + ")");
                    } else {
                        rowOut.createCell(lastCol).setCellValue("Media Formula");
                    }
                }
            }

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                workbookOut.write(fos);
            }
        }
    }

    public static void main(String[] args) {
        try {
            citireSiAfisare("laborator8_input.xlsx");
            generareCuMediaCalculata("laborator8_input.xlsx", "laborator8_output2.xlsx");
            generareCuFormula("laborator8_input.xlsx", "laborator8_output3.xlsx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}