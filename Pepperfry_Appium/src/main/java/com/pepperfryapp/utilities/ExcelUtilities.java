package com.pepperfryapp.utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelUtilities {

    public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);

            return cell.getStringCellValue();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
