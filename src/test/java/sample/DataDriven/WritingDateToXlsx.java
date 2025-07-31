package sample.DataDriven;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Excel file -> Workbook -> sheets -> Rows ---- Cells
public class WritingDateToXlsx {

    public static void main(String[] args) throws IOException {

        FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\ouputdata.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Data");

        XSSFRow row1 = sheet.createRow(0);
            row1.createCell(0).setCellValue("Java");
            row1.createCell(1).setCellValue(123);
            row1.createCell(2).setCellValue("Automation");

        XSSFRow row2 = sheet.createRow(1);
            row2.createCell(0).setCellValue("Python");
            row2.createCell(1).setCellValue(30);
            row2.createCell(2).setCellValue("Automation");

        workbook.write(file);

        workbook.close();
        file.close();
    }
}
