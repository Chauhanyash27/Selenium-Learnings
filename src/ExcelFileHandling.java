import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelFileHandling{


    public static FileInputStream file;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static int getRowCount(String excelFile,String sheetName) throws IOException {
        file = new FileInputStream(excelFile);
        workbook = new XSSFWorkbook(file);
        sheet=workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        file.close();
        return rowCount;
    }

    public static int getColumnCount(String excelFile,String sheetName, int rowNumber) throws IOException {
        file = new FileInputStream(excelFile);
        workbook = new XSSFWorkbook(file);
        sheet=workbook.getSheet(sheetName);
        row = sheet.getRow(rowNumber);
        int columnCount = row.getLastCellNum();
        workbook.close();
        file.close();
        return columnCount;
    }

    public static String getCellData(String excelFile,String sheetName, int rowNumber, int columnNumber) throws IOException {

        file = new FileInputStream(excelFile);
        workbook = new XSSFWorkbook(file);
        sheet=workbook.getSheet(sheetName);
        row = sheet.getRow(rowNumber);
        cell = row.getCell(columnNumber);
        String data = cell.toString();
        workbook.close();
        file.close();
        return data;
    }

}