package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;

public class ExcelReader {

   
    public static Object[][] getExcelData() {
        Object[][] data = null;
        try {
            File file = new File("src/test/resources/TestData.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheetAt(0);

            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                }
            }
            workbook.close();
            fis.close();
        } catch (Exception e) {
            System.out.println("Oops! Excel read aagala: " + e.getMessage());
        }
        return data;
    }
}