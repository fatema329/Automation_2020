package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Aetna {

    public static void main(String[] args) throws InterruptedException {
        //set the properties
        System.setProperty("webdriver.chrome.driver","src\\Resource\\chromedriver.exe");
        //set chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("Start-maximized","disable-infobars","incognito");
        //define driver
        WebDriver driver = new ChromeDriver(options);
        //navigate to aetna website
        driver.navigate().to("https://www.aetna.com/");
        Thread.sleep(3000);
        //get titleGet
        String getTitle1 = driver.getTitle();
        if(getTitle1.equals("aetna ")) {
            System.out.println("Title is correct ");
        } else{
            System.out.println("The title is incorrect " + getTitle1);
        }
        //click individual
        driver.findElement(By.xpath("//*[@class='megamenu__primary--item--btn']")).click();
        //click get quote
        driver.findElement(By.xpath("//*[@aria-expanded='false']")).click();
        //click medicare
        driver.findElement(By.xpath("//*[@class='megamenu__tertiary--link link__text--inline--tertiary']")).click();
        Thread.sleep(3000);
        String getTitle2 = driver.getTitle();
        if(getTitle2.equals("quote medicare Aetna")) {
            System.out.println("Title is correct ");
        }else{
            System.out.println("Title is incorrect " +getTitle2 );
        }
        //setup sets of zipcode
        String[] zipcode;
        zipcode = new String[]{"11218","11219","11220"};
        //set up WebElement for search for loop
        WebElement zipcodeSearch = driver.findElement(By.xpath("//*[@title='Enter a valid 5-digit ZIP code']"));
        //clear text
        zipcodeSearch.clear();
        //type zipcode in the zipcodesearch
        zipcodeSearch.sendKeys(zipcode[0]);
        //click view 2020 plans
        driver.findElement(By.xpath("//*[@data-ctahrefholder='${AMstartEvenYear}']")).click();
        Thread.sleep(3000);
        //create a second webelement for zipcodeseach1
        WebElement zipcodeSearch1 = driver.findElement(By.xpath("//*[@data-val-regex='Error: Please enter a valid 5 digit zip code']"));
        zipcodeSearch1.clear();
        //type zipcode in the second zipcode
        zipcodeSearch1.sendKeys(zipcode[0]);
        // Setup the three coverage
        String[] typesCoverages;
        typesCoverages = new String[]{"Medical and drug coverage","Drug coverage","Medical coverage"};
        //substitute typesCoverage based on the array
        WebElement typesCoveragesClicked = driver.findElement(By.xpath("//*[text()='" + typesCoverages[0] + "']"));
        typesCoveragesClicked.click();
        Thread.sleep(3000);
        if(typesCoveragesClicked.equals("//*[text()='" + typesCoverages[0] + "']")) {
            //click under 65
            driver.findElement(By.xpath("//*[text() ='Under 65']")).click();
            //click fair health
            driver.findElement(By.xpath("//*[text()='Fair health']")).click();
            //click i receive partial extra help
            driver.findElement(By.xpath("//*[@name='SubsidyData.SubsidyLevel']")).click();
            Thread.sleep(3000);
        }else if(typesCoveragesClicked.equals("//*[text()='" + typesCoverages[1] + "']")) {
            //click i receive full extra help, but not medicaid
            driver.findElement(By.xpath("//*[text()= 'I receive full extra help, but not Medicaid.']")).click();
        }else{
            //click age range 85 above
            driver.findElement(By.xpath("//*[text()= '85+']")).click();
            //click good health
            driver.findElement(By.xpath("//*[text()='Good health']")).click();
        }
        //click continue
        //driver.findElement(By.xpath("//*[text()= 'Continue'")).click();



    }



}
