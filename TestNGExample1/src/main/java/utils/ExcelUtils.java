/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



/**
 *
 * @author Mensur Owary
 */
public class ExcelUtils {
    
    private static XSSFWorkbook book;
    private static XSSFSheet sheet;
    private static XSSFCell cell;
    
    private static int totalColCount = 0;
    
    public static Object[][] getData(Class c, String filename, String sheetname){
        return getDataArray(c.getClassLoader().getResourceAsStream(filename), sheetname);
    }
    
    private static Object[][] getDataArray(InputStream input, String sheetName){
        Object[][] array = null;
        
        try{
            book = new XSSFWorkbook(input);
            sheet = book.getSheet(sheetName);
            int totalRowCount = sheet.getLastRowNum();
            setTotalColCount(sheet);
            array = new Object[totalRowCount][totalColCount];
            
            for(int i=1;i<=totalRowCount;i++){
                for(int j=0;j<=totalColCount-1;j++){
                    array[i-1][j] = cellData(i, j);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return array;
    }
    
    public static Object[][] getDataArray(String path, String sheetName){
        Object[][] array = null;
        
        try{
            book = new XSSFWorkbook(new FileInputStream(path));
            sheet = book.getSheet(sheetName);
            int totalRowCount = sheet.getLastRowNum();
            setTotalColCount(sheet);
            array = new Object[totalRowCount][totalColCount];
            
            for(int i=1;i<=totalRowCount;i++){
                for(int j=0;j<=totalColCount-1;j++){
                    array[i-1][j] = cellData(i, j);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return array;
    }
    
    public static void setTotalColCount(XSSFSheet sheet){
        totalColCount = sheet.getRow(0).getLastCellNum();
    }
    
    public static Object[][] getDataArrayByCol(String path, String sheetName, int col){
        if(col==0){
            totalColCount=2;
            return getDataArray(path, sheetName);
        }else{
            setTotalColCount(sheet);
        }
        Object[][] data = getDataArray(path, sheetName);
        
        int lenRow = data.length;
        int lenCol = data[0].length;
        
        int colCtr = 0;
        int j=0;
        
        Object[][] arr = new Object[lenRow][3];
        
        for(int i=0;i<lenRow;i++){
            while(j<lenCol){
                if(j<2 || j==col){
                    arr[i][colCtr] = data[i][j];
                    colCtr++;
                }
                j++;
            }
            j=0;
            colCtr=0;
        }
        
        return arr;
    }
    
    private static Object cellData(int row, int col){
        Object d = null;
        try{
            cell = sheet.getRow(row).getCell(col);
            switch(cell.getCellTypeEnum()){
                case BOOLEAN:
                    d = cell.getBooleanCellValue();
                    break;
                case STRING:
                    d = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    d = cell.getNumericCellValue();
                    break;
                case ERROR:
//                    d = cell.getErrorCellString();
                    break;
                case BLANK:
                    d = "";
                    break;
                default:
                    d = null;
            }
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        return d;
    }
    
    public static void main(String[] args) {
        Object[][] o = getDataArray("C:\\Users\\MansurGulami\\Desktop\\Data\\logindata.xlsx", "Sheet1");
        System.out.println(Arrays.deepToString(o));
    }
}
