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

public class debug_WW {
    public static void main(String[] args) throws InterruptedException, IOException, BiffException, WriteException, WriteException {

        //define the path of your readable excel file
        Workbook readableFile= Workbook.getWorkbook(new File("src/Resource/WeightWatchers.xls"));
        //define the worksheet for the data
        Sheet readableSheet= readableFile.getSheet(0);
        //Get count of all non empty rows
        int rowCount= readableSheet.getRows();
        //Create duplicate workbook to wirte back
        WritableWorkbook writeableFile = Workbook.createWorkbook(new File("src/Resource/WeightWatchers_Result.xls"),readableFile);
        //Define the writable worksheet
        WritableSheet wSheet= writeableFile.getSheet(0);

        // define the path of chrome driver
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver.exe");
        //set pre arguments using chrome options
        ChromeOptions options= new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        //define the chrome driver
        WebDriver driver = new ChromeDriver(options);


        for(int i = 1; i < rowCount; i++){
            String Zipcode=wSheet.getCell(0,i).getContents();

            // navigate to Weight Watchers
            driver.navigate().to("https://www.weightwatchers.com/us/");
            Thread.sleep(4000);

            //verify the page is Weight Loss Program
            String actualTitle= driver.getTitle();
            if(actualTitle.equals("Weight Loss Program, Recipes & Help | Weight Watchers")){
                System.out.println("Title Matches");
            }else {
                System.out.println("Title does not Match " + actualTitle);
            }

            // CLick on "Find a Studio"
            driver.findElement(By.xpath("//*[@class='find-a-meeting']")).click();
            Thread.sleep(2000);
            // Click on X
            driver.findElement(By.xpath("//*[@class='bx-close-xsvg']")).click();
            Thread.sleep(2000);

            // verify the page is Find a Studio and Meeting Near You
            String correctTitle= driver.getTitle();
            if (correctTitle.equals("Find a Studio & Meeting Near You |")){
                System.out.println("Title Matches");
            }else{
                System.out.println("Title does not Match " + correctTitle);
            }

            Reusable_Methods.type(driver, "//*[@id='meetingSearch']", Zipcode,"Enter Location");
            Reusable_Methods.click(driver,"//*[@spice='SEARCH_BUTTON']","Search Enter");
            Thread.sleep(5000);

            //Store the Search Result
            String searchResult= driver.findElement(By.xpath("//*[@class='location__name']")).getText();
            Thread.sleep(1500);
            //Capture location Result
            String locationDistance=driver.findElement(By.xpath("//*[@class='location__distance']")).getText();
            Thread.sleep(3000);
            // Capture Operation Hours Result
            String operationHours=driver.findElement(By.xpath("//*[@class='schedule__time']")).getText();
            Thread.sleep(2000);

            Reusable_Methods.clickByIndex(driver, "//*[@class='location__address']", 0, "address name");

            Label resultAndDistance= new Label(1,i,searchResult + locationDistance);
            wSheet.addCell(resultAndDistance);
            Label operationHour= new Label(2,i,operationHours);
            wSheet.addCell(operationHour);

        }//end of for loop

        readableFile.close();
        writeableFile.write();
        writeableFile.close();

        driver.quit();

    }//end of main method
}
