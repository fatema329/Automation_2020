package day5_01252020;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class mlcalc_webelement {

    public static void main(String[] args) throws InterruptedException {

        //define the path of chrome driver
        System.setProperty("webdriver.chrome.driver","src/Resource/chromedriver.exe");
        //set pre arguments using ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        //define the chromedriver
        WebDriver driver = new ChromeDriver(options);

        //array for down payment
        String[] dpArray = new String[]{"0","20"};

        for(int i=0;i<dpArray.length; i ++) {

            //navigate to mlcalc.com
            driver.navigate().to("https://www.mlcalc.com");
            //wait few seconds
            Thread.sleep(3000);
            //store purchase price locator as webelemnt variable to reuse
            WebElement pPrice = driver.findElement(By.xpath("//*[@name='ma']"));
            //clear purchase price
            pPrice.clear();
            //enter new value on purchase price
            pPrice.sendKeys("350000");

            //store down payment in webelement variable
            WebElement dp = driver.findElement(By.xpath("//*[@name='dp']"));
            dp.clear();
            dp.sendKeys(dpArray[i]);

            //click on calculate button
            driver.findElement(By.xpath("//*[@alt='Calculate']")).click();

            //wait few seconds
            Thread.sleep(2000);

            //capture total monthly payment
            String mntPay = driver.findElements(By.xpath("//*[@class='big']")).get(0).getText();
            //capture the Payoff Date title
            String payOffTitle = driver.findElements(By.xpath("//*[@nowrap='nowrap']")).get(2).getText();
            String payoffDate;
            if (payOffTitle.equals("Mortgage payoff date")) {
                //capture payoff date
                payoffDate = driver.findElements(By.xpath("//*[@class='big']")).get(2).getText();
            } else {
                //capture payoff date
                payoffDate = driver.findElements(By.xpath("//*[@class='big']")).get(3).getText();
            }

            //capture the 360 payment title
            String payTitle = driver.findElements(By.xpath("//*[@nowrap='nowrap']")).get(1).getText();
            String payValue;
            if (payTitle.equals("Total of 360 payments")) {
                //capture payoff date
                payValue = driver.findElements(By.xpath("//*[@class='big']")).get(1).getText();
            } else {
                //capture payoff date
                payValue = driver.findElements(By.xpath("//*[@class='big']")).get(2).getText();
            }

            //capture the Total monthly payment after Jan, 2030
            String payTitleAfter = driver.findElements(By.xpath("//*[@nowrap='nowrap']")).get(1).getText();
            String payValueAfter= null;
            if (payTitleAfter.contains("Total monthly payment")) {
                //capture payoff date
                payValueAfter = driver.findElements(By.xpath("//*[@class='big']")).get(1).getText();
            } else {
                payValueAfter = "doesn't exist";
            }

            //print out the results
            System.out.println("My monthly pay is " + mntPay + " and my total monthly pay after " + payValueAfter + " and 360 payment " + payValue + " and my pay off date is " + payoffDate);

        }//end of for loop


    }//end of main method




}
