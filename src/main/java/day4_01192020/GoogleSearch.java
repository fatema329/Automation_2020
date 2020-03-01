package day4_01192020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

    public static void main(String[] args) throws InterruptedException {

        int grade = 92;

        if(grade <= 90 && grade >= 100){
            System.out.println("My Grade is A");
        }

        String[] cars;
        cars= new String[4];
        cars[0] = "BMW";
        cars[1] = "Mercedes";
        cars[2] = "Lexus";
        cars[3] = "Nissan";

        //define the path of where the chrome driver is stored
        // if you see two "\\" remove them "\\" add one forward "/"
        System.setProperty("webdriver.chrome.driver","C:/Users/Oshi/Desktop/maven project/src/main/resources/chromedriver.exe");
        //defining the actual webdriver(chrome driver)
        WebDriver driver = new ChromeDriver();

        for(int i = 0; i< cars.length;i++) {
            //navigate to google.com
            driver.get("https://www.google.com");
            //maxmize my driver
            driver.manage().window().maximize();
            //sleep statement 1000 millis = 1 second
            Thread.sleep(3000);
            //enter brooklyn in your search field
            driver.findElement(By.name("q")).sendKeys(cars[i]);
            //click on google search
            driver.findElement(By.name("btnK")).submit();
            //wait few seconds
            Thread.sleep(3000);
            //capture the text into a string variable
            String message = driver.findElement(By.id("resultStats")).getText();
            String[] arraymessage = message.split(" ");
            //print out search number
            System.out.println("My search number for " + cars[i] + " is " + arraymessage[1]);
        }//end of for loop
        //quit my driver
        driver.quit();

    }//end of main class

}//end of parent class
