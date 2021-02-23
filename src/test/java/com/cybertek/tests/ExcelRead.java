package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void excel_read_test() throws IOException {
        String path = "SampleData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        // workbook>sheet>row>cell
        // We created workbook instance and loaded with 'Sample Data"
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // Create the sheet and pass the name of the sheet we want to work on

        XSSFSheet sheet = workbook.getSheet("Employees");
        // print out"Barack" from excel sheet
        System.out.println(sheet.getRow(1).getCell(0));

        // print out"singer" from excel sheet
        System.out.println(sheet.getRow(4).getCell(2));

        // returns the count of used cells only
        //if there are cells not used they will not be counted
        // starts counting from 1
        int usedRows = sheet.getPhysicalNumberOfRows();


        // returns the count from top to bottom
        // even counts if there are empty cells
        //this starts counting from 0
        int lastUsedRow = sheet.getLastRowNum();

        System.out.println(lastUsedRow);


        //TODO 1- CREATE A LOGIC TO PRINT OUT ALEX'S NAME DYNAMICALLY

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            XSSFCell currentCell = sheet.getRow(rowNum).getCell(0);

            if(currentCell.toString().equals("Alex")){
                System.out.println("Current cell = "+ currentCell);
            }
        }

        //TODO 2- CREATE A LOGIC TO PRINT OUT ElON MUSK LASTNAME DYNAMICALLY


        for (int rowNumber = 0; rowNumber < usedRows; rowNumber++) {

            XSSFCell  currentCell = sheet.getRow(rowNumber).getCell(1);

            if(currentCell.toString().equals("Musk")){
                System.out.println("Elon's lastname is : " + currentCell);
            }

        }

        //TODO 3- CREATE A LOGIC TO PRINT OUT CHRISTIAN RONALDO JOB ID  DYNAMICALLY
        // CHECK FOR LAST NAME, IT IS RONALDO, PRINT OUT JOB ID

        for (int rowNumber = 0; rowNumber < usedRows; rowNumber++) {
            XSSFCell currentCell = sheet.getRow(rowNumber).getCell(1);
                    if(currentCell.toString().equals("Ronaldo")){
                        System.out.println("Ronaldo's job id is = " + sheet.getRow(rowNumber).getCell(2));
                    }

        }

    }
}
