package day5_01252020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class USPS_xpath {

    public static void main(String[] args) throws InterruptedException {

        //define the path of chrome driver
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver.exe");
        //set pre arguments using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        //define the chromedriver
        WebDriver driver = new ChromeDriver(options);
        //navigate to usps.com
        driver.navigate().to("https://www.usps.com");
        //maximize the browser
        //driver.manage().window().maximize();
        //wait few seconds to load the page
        Thread.sleep(3000);
        //using xpath property to click on Quick Tools tab
        WebElement quickTools = driver.findElement(By.xpath("//*[text()='Quick Tools' or @class='nav-first-element menuitem']"));
        quickTools.click();





    }//end o main method



}//end of parent class
