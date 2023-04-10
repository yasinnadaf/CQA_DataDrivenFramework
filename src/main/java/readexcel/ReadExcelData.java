package readexcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ReadExcelData {
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ReadExcelData(String sheetPath){
        File file = new File(sheetPath);
        try {
            FileInputStream fis = new FileInputStream(file);
            this.workbook = new XSSFWorkbook(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getData(int sheetNo, int row , int column){
        this.sheet = this.workbook.getSheetAt(sheetNo);
        Cell cell = this.sheet.getRow(row).getCell(column);
        cell.setCellType(CellType.STRING);
        String data = cell.getStringCellValue();
        return data;
    }

    public int getRowCount(int sheetNo){
        int rowNumber = this.workbook.getSheetAt(sheetNo).getLastRowNum();
        ++rowNumber;
        return rowNumber;
    }

}
