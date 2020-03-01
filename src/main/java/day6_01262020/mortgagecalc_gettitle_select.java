package day6_01262020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class mortgagecalc_gettitle_select {


    public static void main(String[] args) throws InterruptedException {

        //define the path of chrome driver
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver.exe");
        //set pre arguments using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        //define the chromedriver
        WebDriver driver = new ChromeDriver(options);

        //navigate to mortgagecalculator
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);

        //verify the page title is Mortage Calculator
        String actualTitle = driver.getTitle();
        if(actualTitle.equals("Mortgage Calculator")){
            System.out.println("Title matches");
        } else {
            System.out.println("Title doesn't match " + actualTitle);
        }

        //select February from start month dropdown
        //first store the locator as WebElement variable
        WebElement startMonth1 = driver.findElement(By.xpath("//*[contains(@name,'start_month')]"));
        //call the select command
        Select smDropdown = new Select(startMonth1);
        //select value by visible text
        //smDropdown.selectByVisibleText(smarray[i]);

        //using try catch to click on start month and value
        try {
            WebElement startMonth = driver.findElement(By.xpath("//[contains(@name,'start_month')]"));
            //click on start month drop down
            startMonth.click();
            //click on the value
            //driver.findElement(By.xpath("//*[text()='"+ smarray[i]+"']")).click();
        } catch (Exception err) {
            System.out.println("Unable to click on start month and value " + err);
        }

        try{

        }catch (Exception err){

        }

        String ppoTYpe = "PPO-LOW";
        //i coming from for loop
        //driver.findElement(By.xpath("//*[@class='"+ppoTYpe[i]+"']")).click();

    }//end of main class




}//end of parent class
