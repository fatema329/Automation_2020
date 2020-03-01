package day8_02022020;

import day7_02012020.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class data_driven {


    public static void main(String[] args) throws IOException, BiffException, InterruptedException {


     //Step1: define the path of your readable excel file
     Workbook readableFile = Workbook.getWorkbook(new File("src/Resource/FreshDirect_Data.xls"));
     //Step2: define the work sheet for the data
     Sheet readableSheet = readableFile.getSheet(0);

     //Step 3: get count of all non empty rows in your excel sheet
     int rowCount = readableSheet.getRows();

     //Step 4: create a duplicate work book to write back so it doesn't mess up your readable workbook
     WritableWorkbook writableBook = Workbook.createWorkbook(new File("src/Resource/FreshDirect_Data_Result.xls"),readableFile);
     //Step 5: define the writable work sheet to read the data
     WritableSheet wSheet = writableBook.getSheet(0);

    //define the path of chrome driver
    System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver.exe");
    //set pre arguments using ChromeOptions
    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized","incognito");
    //define the chromedriver
    WebDriver driver = new ChromeDriver(options);

     for(int i = 1; i < rowCount; i++){

         //get the data from item column which is 0
         String itemName = wSheet.getCell(0,i).getContents();
         //get the data from Department column which is 1
         String departmentName = wSheet.getCell(1,i).getContents();
        //get the data from Brand column which is 2
         String brandName = wSheet.getCell(2,i).getContents();

         //navigate to fresh direct
         driver.navigate().to("https://www.freshdirect.com");
         Thread.sleep(3000);
         //reusable method to enter keyword in search field
         Reusable_Methods.type(driver,"//*[@id='topSearchField']",itemName,"Search Field");
        Thread.sleep(2500);
         //reusable method to click on search icon
         Reusable_Methods.click(driver,"//*[@id='topInputFindButton_fdx']","Search Button");
        //put few seconds to wait for page to load
         Thread.sleep(4000);
         //click on department type by passing the variable on xpath
         Reusable_Methods.click(driver,"//*[text()='"+departmentName+"']","Department Type");
        //click on Selec a Brand
         Reusable_Methods.click(driver,"//*[text()='Select a Brand']","Select a Brand");
        //wait few seconds
         Thread.sleep(1500);
         //click on Brand Type
         Reusable_Methods.click(driver,"//*[text()='"+brandName+"']","Brand Type");

     }//end of for loop



    }//end of main method


}//end of parent class
