package com.cybertek.tests;

import com.cybertek.pages.GasMileageCalculatorPage;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GasMileageTests {
    GasMileageCalculatorPage gasMileageCalculatorPage = new GasMileageCalculatorPage();

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;

    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;


    @Test
    public void gas_mileage_calculator() throws IOException {

        Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");

        //Get the path from Content Root
        String path = "src/test/resources/testData/GasMileageTestData.xlsx";

        // loading the file into the inputStream object
        fileInputStream = new FileInputStream(path);

        // loading the workbook to the class

        workbook = new XSSFWorkbook(fileInputStream);

        //opening the sheet

        sheet = workbook.getSheet("Sheet1");

        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {


            XSSFRow currentRow = sheet.getRow(rowNum);

             if (!currentRow.getCell(0).toString().equals("Y")){
                 if(currentRow.getCell(6)==null){
                     currentRow.createCell(6);
                 }

                 currentRow.getCell(6).setCellValue("Skip Requested");
                 continue;
             }

            //===========================================================================
            double current = currentRow.getCell(1).getNumericCellValue();

            //clearing before entering any data
            gasMileageCalculatorPage.inputCurrentOdo.clear();

            //We need to pass 'double' into the box

            // gasMileageCalculatorPage.inputCurrentOdo.sendKeys(current+"");
            gasMileageCalculatorPage.inputCurrentOdo.sendKeys(String.valueOf(current));

            //===========================================================================

            //Entering previous odometer reading
            double previous = currentRow.getCell(2).getNumericCellValue();

            gasMileageCalculatorPage.inputPreviousOdo.clear();
            gasMileageCalculatorPage.inputPreviousOdo.sendKeys(String.valueOf(previous));
            //===========================================================================

            //Entering how many gallons of gas used

            double gas = currentRow.getCell(3).getNumericCellValue();

            gasMileageCalculatorPage.inputGas.clear();
            gasMileageCalculatorPage.inputGas.sendKeys(String.valueOf(gas));

//===========================================================================

            gasMileageCalculatorPage.calculateButton.click();


            //How does the calculation of AVG/MPG work
            // (current-previous)/gallons -->

            DecimalFormat df = new DecimalFormat("#.00");

            double expectedResult = (current - previous) / gas;


            System.out.println("expectedResult = " + df.format(expectedResult));

            //actual result  --> 14.29 mpdg --> split " " --> {"14.29", "mpg"}

            String[] actualResultArr = gasMileageCalculatorPage.resultInGas.getText().split(" ");
            System.out.println("actualResultArr = " + actualResultArr[0]);

            if (currentRow.getCell(4) == null) {
                currentRow.createCell(4);   // creating a cell to write in it
            }

            currentRow.getCell(4).setCellValue(df.format(expectedResult));

//===========================================================================

            if (currentRow.getCell(5) == null) {
                currentRow.createCell(5);   // creating a cell to write in it
            }

            currentRow.getCell(5).setCellValue(actualResultArr[0]);

//===========================================================================

            //Passing the status into the excel file

            if (currentRow.getCell(6) == null) {
                currentRow.createCell(6);
            }


            if (actualResultArr[0].equals(String.valueOf(df.format(expectedResult)))) {
                //System.out.println("PASS");

                currentRow.getCell(6).setCellValue("PASS!");
            } else {
                //System.out.println("FAIL");
                currentRow.getCell(6).setCellValue("FAIL!");
            }
//===========================================================================
            // Entering the current time when the test is running that specific line
            if (currentRow.getCell(7) == null) {
                currentRow.createCell(7);
            }

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yy hh:mm:ss a");
            currentRow.getCell(7).setCellValue(LocalDateTime.now().format(dtf).toString());

        }


        fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileInputStream.close();
        fileOutputStream.close();


    }
}
