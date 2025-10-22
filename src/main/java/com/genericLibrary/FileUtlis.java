package com.genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtlis {
    public String readDataFromExcel(String sheet,int row ,int cell) throws IOException {
 	   FileInputStream fis = new FileInputStream("./src/test/resources/TestData/SourceData.xlsx");
 	   Workbook wb = WorkbookFactory.create(fis);
 	   String data = wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
 	   return data;
 	   
    }
    
    public int readNumericDataFromExcel(String sheet,int row ,int cell) throws IOException {
 	   FileInputStream fis = new FileInputStream("./src/test/resources/TestData/SourceData.xlsx");
 	   Workbook wb = WorkbookFactory.create(fis);
 	   int data = (int)wb.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
 	   return data;
 	   
    }

}
