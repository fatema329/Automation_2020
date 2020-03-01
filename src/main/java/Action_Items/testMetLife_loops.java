package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.util.ArrayList;

public class testMetLife_loops {

    public static void main(String[] args) throws InterruptedException, IOException {
        //define the path of the chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/Users/Oshi/Desktop/maven project/src/main/resources/chromedriver.exe");

        //quit all open chrome browsers
        //Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f /t");

        //seeting up the chromeoptions
        ChromeOptions options = new ChromeOptions();
        //add the precondition arguments
        options.addArguments("start-maximized", "incognito");

        //define the chrome web driver
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> postalCode = new ArrayList<>();
        postalCode.add("11218");
        postalCode.add("11219");
        postalCode.add("10001");

        ArrayList<String> ppoType = new ArrayList<>();
        ppoType.add("PPO-LOW");
        ppoType.add("PPO-MEDIUM");
        ppoType.add("PPO-HIGH");

        ArrayList<String> referallCode = new ArrayList<>();
        referallCode.add("111111");
        referallCode.add("2222222");
        referallCode.add("3333aaadfdfdfd");


        for (int i = 0; i < 3; i++) {
            //navigate to Metlife
            driver.navigate().to("https://www.metlife.com/");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[contains(text(),'SOLUTIONS')]")).click();
            Thread.sleep(1500);
            //click on Metline Dental tab
            driver.findElement(By.xpath("//*[contains(text(),'MetLife TakeAlong Dental')]")).click();
            Thread.sleep(3500);
            //click on Enroll Now button
            driver.findElement(By.xpath("//*[contains(text(),'Enroll Now')]")).click();
            //define window handle for tabs
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            //switch to second tab
            driver.switchTo().window(tabs.get(1));
            Thread.sleep(4000);
            //enter zip code
            System.out.println("Now Entering Zip/Postal Code " + postalCode.get(i));
            WebElement zip = driver.findElement(By.xpath("//*[@id='txtZipCode']"));
            zip.clear();
            zip.sendKeys(postalCode.get(i));
            //click on Go button
            driver.findElement(By.xpath("//*[text()='GO']")).click();
            Thread.sleep(5500);
            for(int j=0; j < ppoType.size(); j++) {
                //capture the current ppo page url
                String ppoUrl = driver.getCurrentUrl();
                //click on PPO-LOW
                driver.findElement(By.xpath("//*[@class='" + ppoType.get(j) + "']")).click();
                //click on Enroll In Program Now button
                driver.findElement(By.xpath("//*[contains(text(),'ENROLL IN PROGRAM NOW')]")).click();
                Thread.sleep(4000);
                //enter invalid referall code
                driver.findElement(By.xpath("//*[@id='txtBxPromocode']")).sendKeys(referallCode.get(i));
                //click on Go
                driver.findElement(By.xpath("//*[text()='GO']")).click();
                Thread.sleep(3000);
                //capture error message and verify it matches with your expected text
                String errMessage = driver.findElement(By.xpath("//*[contains(@id,'lblRefCodeError')]")).getText();
                if (errMessage.equals("Referral Code was not recognized")) {
                    System.out.println("Referall code error message matches");
                } else {
                    System.out.println("Referall code error doesn't match " + errMessage);
                }
                //click on Enroll witout a code
                driver.findElement(By.xpath("//*[text()='Enroll without a Referral Code']")).click();
                Thread.sleep(2000);
                //re navigate to ppo url
                driver.navigate().to(ppoUrl);
            }//second loop ends here

            //close your current tab which is second tab
            driver.close();
            //switch to first default tab
            driver.switchTo().window(tabs.get(0));
            Thread.sleep(1500);
        }//end of loop


    }//end of main method

}//end of class
//Action Item due in by Friday 12pm
//
//Please use Xpath selectors.
//
//Use For/While loop and iterate through scenario by creating  following dynamic array variables with 3 values
//
//zipCode, dentalProgram,referralCode
//
//Use WebElement variable to store your locators then use the variable to perform operations
//
//
//
//Steps:
//
//1. Navigate to https://www.metlife.com/
//
//2. Verify that loaded page title matches “Insurance & Employee Benefit | Metlife”
//
//3. Click on on SOLUTIONS tab
//
//4. Click on MetLife TakeAlong Dental button
//
//5. Verify that loaded page title matches “MetLife Take Along Dental – Dental Insurance”(it shouldn’t match)
//
//6. Click on ENROLL NOW button
//
//7. Switch to second tab by using ArrayList
//
//8. Enter Zip Code //zipCode[i] variable will go here for different values
//
//9. Click on ‘Go’ Button
//
//10. Click on a PPO(PPO-LOW, PPO-MEDIUM, PPO-HIGH) //this is where you will pass the dentalProgram[i] in xpath
//
//11. Click on ENROLL IN PROGRAM NOW button
//
//12. On pop up Enter an invalid  Referral code then click on Go button //this is where you will pass referralCode[i] variable
//
//13. Store the error message in string variable using getText()
//
//13. Verify that error message matches the following Referral Code was not recognized
//
//14. Click on ‘Enroll Without a Referral Code’ button
//
//15. Choose first value by clicking on radio button from Self Only section
//
//16. Click on ‘Continue to Step 2’ button
//
//17. Verify you see message  “Step 2: Self Information” //you can use text()=‘Step 2: Self Information’ with isDisplayed() command if(driver.findElement(By.xpath(…).isDisplayed()){ print It is there} else { print it is not there }
//
//18. Then print out System.out.println(“Now on Step 2 and dental program is “ + dentalProgram[i]);
//
//19. Close the second tab by using driver.close(); //inside the loop
//
//20. Now switch back to default tab(first tab)
//
//