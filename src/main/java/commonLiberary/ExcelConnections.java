package commonLiberary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConnections {

    String fileName = "TestData.xlsx";


    public String getData(int rowNum, int colNum) throws IOException {

        FileInputStream fis = new FileInputStream(new File(fileName));
        XSSFWorkbook hBook = new XSSFWorkbook(fis);
        XSSFSheet sheet = hBook.getSheet("Sheet1");

//		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        Row row = sheet.getRow(rowNum);
//	    System.out.print(row.getCell(colNum).getStringCellValue());
        String value = row.getCell(colNum).getStringCellValue();
        fis.close();
        return value;

    }

    public void setData(int row, int col, String data) throws IOException, InvalidFormatException {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        Workbook hBook = new XSSFWorkbook(fis);
        Sheet sheet = hBook.getSheet("Sheet1");
        Row newRow = sheet.createRow(row);
        Cell cell = newRow.createCell(col);
        cell.setCellValue(data);
        fis.close();

        FileOutputStream fos = new FileOutputStream(file);
        hBook.write(fos);

        fos.close();


    }

//    public static void main(String[] args) throws IOException, InvalidFormatException {
//
//
////		new ExcelConnections().setData(0, 0, "Hitesh");
//
//    }
}
