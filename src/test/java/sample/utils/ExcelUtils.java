package sample.utils;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    public static FileOutputStream fo;
    public static FileInputStream fi;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell cell;
    public static XSSFCellStyle cellStyle;

    public static int getROwCount(String filePath, String sheetName) throws IOException {
        fi = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fi);
        sheet = workbook.getSheet(sheetName);
        int rows = sheet.getLastRowNum();
        workbook.close();
        fi.close();
        return rows;
    }

    public static int getCellCount(String filePath, String sheetName, int rowNum) throws IOException {
        fi = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(sheetName);
        sheet = workbook.getSheet(sheetName);
        int cellCount = sheet.getRow(rowNum).getLastCellNum();
        workbook.close();
        fi.close();
        return cellCount;
    }

    public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) throws IOException {
        fi = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(sheetName);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        String data;
        try{
            data = cell.toString();
        }
        catch (Exception e){
            data="";
        }
        workbook.close();
        fi.close();
        return data;
    }



}
