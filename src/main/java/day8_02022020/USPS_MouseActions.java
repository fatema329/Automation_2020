package day8_02022020;

import day7_02012020.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class USPS_MouseActions {


    public static void main(String[] args) throws InterruptedException {

        //define the path of chrome driver
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver.exe");
        //set pre arguments using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        //define the chromedriver
        WebDriver driver = new ChromeDriver(options);

        //navigate to usps
        driver.navigate().to("https://www.usps.com");

        //wait few seconds
        Thread.sleep(5000);

        //move to Quick tools element
        Reusable_Methods.mouseHover(driver,"//*[text()='Quick Tools']","Quick Tools");

        Thread.sleep(2000);

        //click on track a package as a webelement variable
        Reusable_Methods.clickByMouse(driver,"//*[text()='Track a Package']","Track a Package");

        Thread.sleep(4000);

        //enter a keyword on tracking field
        Reusable_Methods.typeUsingMouse(driver,"//*[@id='tracking-input']","11111111","Track Field");

    }//end of main method


}//end of class
