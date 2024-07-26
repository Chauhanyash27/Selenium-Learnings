package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider
    public Object[][] AllDataProvider() throws IOException {

        String filePath = System.getProperty("user.dir") + "\\TestData\\APIDataFile.xlsx";
        int totalRows = ExcelFileHandling.getRowCount(filePath, "UserData");
        int totalColumns = ExcelFileHandling.getColumnCount(filePath, "UserData", 0);

        Object[][] data = new Object[totalRows][totalColumns];
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                data[i - 1][j] = (ExcelFileHandling.getCellData(filePath, "UserData", i, j));
            }
        }
        return data;
    }

    @DataProvider
    public Object[] UsernameDataProvider() throws IOException {

        String filePath = System.getProperty("user.dir") + "\\TestData\\APIDataFile.xlsx";
        int totalRows = ExcelFileHandling.getRowCount(filePath, "UserData");

        Object[] data = new Object[totalRows];

        for (int i = 1; i <= totalRows; i++) {
                data[i - 1]= (ExcelFileHandling.getCellData(filePath, "UserData", i, 1));
            }
        return data;
    }

}