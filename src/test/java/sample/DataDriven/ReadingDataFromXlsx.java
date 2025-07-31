package sample.DataDriven;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

//Excel file -> Workbook -> sheets -> Rows ---- Cells
public class ReadingDataFromXlsx {

    public static void main(String[] args) throws IOException {

       FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\inputdata.xlsx");
//        System.out.println(System.getProperty("user.dir"));

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheet("Sheet1");
       // XSSFSheet sheet = workbook.getSheetAt(0);

        int totalNumOfRows = sheet.getLastRowNum();
        int totalNumOfCells = sheet.getRow(1).getLastCellNum();
        System.out.println(totalNumOfRows);
        System.out.println(totalNumOfCells);

        for(int i=1;i<=totalNumOfRows;i++){
            XSSFRow row = sheet.getRow(i);
            for (int j=0;j<totalNumOfCells;j++){
                //System.out.println(sheet.getRow(i).getCell(j));
                XSSFCell cell = row.getCell(j);
                System.out.println(cell.toString());
            }
        }

        workbook.close();
        file.close();
    }
}
