package Action_Items;

import day7_02012020.Reusable_Methods;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class WW {

    public static void main(String[] args) throws IOException, BiffException, InterruptedException, WriteException {
        //create a path for readable file in excel
        Workbook readable = Workbook.getWorkbook(new File("src/Resource/WW_datadriven.xls"));
        //define the work sheet for the data
        Sheet readableSheet = readable.getSheet(0);
        //get all non empty row count in excel
        int rowCount = readableSheet.getRows();
        //create a duplicate excel to input data
        WritableWorkbook writable = Workbook.createWorkbook(new File("src/Resource/WW_datadriven_Results.xls"),readable);
        //define A WRITEbook to read data
        WritableSheet wSheet = writable.getSheet(0);

        //create a path to chrome
        System.setProperty("webdriver.chrome.driver", "src/Resource/chromedriver.exe");
        //set pre agrs using chromeOPTIONS
        ChromeOptions options = new ChromeOptions();
        //chrome options
        options.addArguments("start-maximized", "incognito");
        WebDriver driver = new ChromeDriver(options);
         String text = "//*[@]/followiing::span";
        for (int i = 1; i < rowCount; i++) {
            String val = "//*[normalize-space(@class='currently__summary next swap')]";
            //*[]
            String hour2 = "call the date command here  current hour + the number you pass";
            if(driver.findElement(By.xpath("//*[contains(@class,'"+ hour2 +"')]")).isDisplayed()){
               //store as a variable //print it is matching CURRENT HOUR + 2
                String messagehour2 = "First Hour from current is " + hour2;
            } else {
                //print it is not matching
            }
            if(driver.findElement(By.xpath("//*[contains(@class,'"+ hour2 +"')]")).isDisplayed()){
                //store as a variable //print it is matching CURRENT HOUR + 2
                //String messagehour4 = "Second Hour from current is " + hour4;
            } else {
                //print it is not matching
            }

            //get data from coulum from 1
            String Zipcode = wSheet.getCell(0, i).getContents();
            //navigate
            driver.navigate().to("https://www.weightwatchers.com/us/");
            Thread.sleep(3000);
            //verify the title matches "weight loss program,RECIPES & HELP  | WEIGHT watchers
            Reusable_Methods.verifyPageTitle(driver, "Find a studio & Meeting Near you ");
            //clicking on find a meeting
            Reusable_Methods.click(driver,"//*[@class='find-a-meeting']","Find a Studio");
            Thread.sleep(3500);
            Reusable_Methods.click(driver,"//*[@class='bx-close-xsvg']","Pop-up Modal");
            Reusable_Methods.type(driver, "//*[@id='meetingSearch']", Zipcode, "Zip Code");
            Reusable_Methods.click(driver, "//*[@spice='SEARCH_BUTTON']", "Search Enter");
            Thread.sleep(5500);
            //capturing the studio name
            String studioInfo = Reusable_Methods.captureTextByIndex(driver,"//*[@class='location__container']",0,"Location Name");
            //caoture distance
            //String locationDistance = Reusable_Methods.captureTextByIndex(driver,"//*[@class='location__distance']",0,"Distance");
            //capture the adress
            //String address = Reusable_Methods.captureTextByIndex(driver,"//*[@class='location__address']",0,"Address");
            //capture the zipcode
            //String cityZip = Reusable_Methods.captureTextByIndex(driver,"//*[@class='location__city-state-zip']",0,"City State Zip");
            //adding it back to excel location column
            Label label1 = new Label(1, i, studioInfo);
            wSheet.addCell(label1);
            //click on location address to go to op hour page
            Reusable_Methods.clickByIndex(driver, "//*[@class='location__container']", 0, "Studio Name Link");
            Thread.sleep(4000);
            String operationHour = Reusable_Methods.captureTextByIndex(driver,"//*[contains(@class,'hours-list--currentday')]",0,"Op Hour");
            Label label2 = new Label(2, i, operationHour);
            wSheet.addCell(label2);
        }//end of the loop

        writable.write();
        writable.close();
        readable.close();
        driver.quit();
    }
}
