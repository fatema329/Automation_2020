
package Cucumber;

import Reusable_Library.reusable_methods;
import com.beust.jcommander.JCommander;
import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import day3_01182020.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.lang.invoke.DelegatingMethodHandle$Holder;

public class GoogleTestCases {
    //declare webdriver outside outside since it will be used on all methods
    WebDriver driver;

    @Given ("^I navigate to google home$")
    public void navigate() throws IOException, InterruptedException {
        //set pre agrs using ChromeOptions
        //quit all open chrome browsers
        //Runtime.getRuntime().exec( command:"taskkill /im chromedriver.exe /f /t");

       //create a path to chrome
       System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
       //set pre agrs using chromeOPTIONS
        ChromeOptions options = new ChromeOptions();

        //add the precondition arguments
        options.addArguments("start-maximized", "incognito");
        //define the chrome web driver
        driver=new ChromeDriver(options);
        driver.navigate().to("https://www.google.com/");
    }//end of given method

        @When("^I verify the expected title as google$")
        public void VerifyTitle() {
            reusable_methods.verifyPageTitle(driver, "Google");
        }//end of when

        @When("^I type a Cars ( .*) in google search fields$")
                public void typeOnSearch(String cars) throws IOException {
                reusable_methods.type(driver, "//*[@name='q']","cars","Search field" );
        }//end of second when

        @And("^I submit or click on google search$")
                public void clickOnSearch(){
           reusable_methods.submit(driver,"//*[@name='q']","Search Field");
                   } //end of And

        @Then("^I capture and extract the search numbers$")
    public void getsearchnumber(){
        String message = reusable_methods.captureText(driver, "//*[@id='mBHK']", "searchresult");
        String[] arraymsg = message.split(" ");
            Reporter.addStepLog ("My search number for car is " + arraymsg[1]);

        System.out.println("My search number for cars is "+ arraymsg[1]);


    }





}
