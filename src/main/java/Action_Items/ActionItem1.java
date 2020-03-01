package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionItem1 {


    public static void main(String[] args) throws InterruptedException {
        String[] cities = new String[4];
        cities[0] = "Bronx";
        cities[1] = "Queens";
        cities[2] = "Manhattan";
        cities[3] = "Long Island";

        //define the path of where the chrome driver is stored
        System.setProperty("webdriver.chrome.driver","src\\Resource\\chromedriver.exe");
        //defining the actual webdriver(chrome driver)
        WebDriver driver = new ChromeDriver();

        int i = 0;
        while(i< cities.length) {
            //navigate to bing.com
            driver.navigate().to("https://www.bing.com/");
            //maxmize my driver
            driver.manage().window().maximize();
            //sleep statement 1000 millis = 1 second
            Thread.sleep(3000);
            //enter brooklyn in your search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities[i]);
            //click on bing search
            driver.findElement(By.name("q")).submit();
            //wait few seconds
            Thread.sleep(3000);
            //capture the text into a string variable
            String message = driver.findElement(By.id("b_tween")).getText();
            String[] arraymessage = message.split(" ");
            //print out search number
            System.out.println("My search number for " + cities[i] + " is " + arraymessage[0]);

            i = i + 1;
        }//end of while loop
        //quit my driver
        driver.quit();


    }//end of main method


}//end of parent class
