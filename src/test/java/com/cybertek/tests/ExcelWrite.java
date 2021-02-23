package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;


    @Test
    public void excel_write() throws IOException {

        String path= "SampleData.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);

        //workbook  > sheet > row > cell

        // loading excel workbook into class
        workbook= new XSSFWorkbook(fileInputStream);

        //open the sheet "Employees" from the workbook

        sheet = workbook.getSheet("Employees");

        //Obama's row
        row = sheet.getRow(1);

        //Obama's cell

        cell = row.getCell(1);

        //Ex : Storing Elon's name cell if we were to be re-using it

        XSSFCell elonsCell = sheet.getRow(2).getCell(0);

        System.out.println("Before = " + elonsCell);

        elonsCell.setCellValue("Melon");


        FileOutputStream fileOutputStream = new FileOutputStream(path);

        workbook.write(fileOutputStream);


        System.out.println("After = " + elonsCell);


        // It is good practice to close fileinput fileoutput and workbook
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();



    }
}
