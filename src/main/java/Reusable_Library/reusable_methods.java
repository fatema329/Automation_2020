package Reusable_Library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

//import static jxl.read.biff.DateRecord.dateFormat;

    public class reusable_methods {

        public static void click(WebDriver driver, String locator, String elementName) {
            try {
                Thread.sleep(1500);
                System.out.println("Clicking on element " + elementName + " by index number ");
                driver.findElement(By.xpath(locator)).click();
            } catch (Exception e) {
                System.out.println("Unable to click on element - " + elementName + " by index number... " + e);
            }
        }//end of click on element by index number method


        public static void submit(WebDriver driver, String locator, String elementName){
            try{
                Thread.sleep(1500);
                System.out.println("Submitting an element " + elementName + " by index number ");
                driver.findElement(By.xpath(locator)).submit();
            } catch (Exception e) {
                System.out.println("Unable to Submit an element - " + elementName + " by index number... " + e);
            }
        }//end of click on element by index number method



        //********************************************************************
        //method to click using mouse Actions on an element
        public static void clickByMouse(WebDriver driver, String locator, String elementName){
            Actions mouseAction = new Actions(driver);
            try{
                Thread.sleep(1500);
                System.out.println("Clicking on element " + elementName);
                WebElement element = driver.findElement(By.xpath(locator));
                mouseAction.moveToElement(element).click().perform();
            } catch (Exception e) {
                System.out.println("Unable to click on element - " + elementName + e);
            }
        }//end of mouse click method

        //********************************************************************
        //method to click on an element by index number
        public static void click(WebDriver driver, String locator, int indexNum, String elementName){
            try{
                Thread.sleep(1500);
                System.out.println("Clicking on element " + elementName + " by index number " + indexNum);
                driver.findElements(By.xpath(locator)).get(indexNum).click();
            } catch (Exception e) {
                System.out.println("Unable to click on element - " + elementName + " by index number... " + e);
            }
        }//end of click on element by index number method

        //********************************************************************
        //method to move to element using mouse Actions
        public static void mouseHover(WebDriver driver, String locator, String elementName){
            Actions mouseAction = new Actions(driver);
            try{
                Thread.sleep(1500);
                System.out.println("Hovering on element " + elementName);
                WebElement element = driver.findElement(By.xpath(locator));
                mouseAction.moveToElement(element).perform();
            } catch (Exception e) {
                System.out.println("Unable to hover on element - " + elementName + e);
            }
        }//end of hover method

        //********************************************************************
        //method to enter a keyword on an element
        public static void type(WebDriver driver, String locator, String userValue, String elementName){
            try{
                Thread.sleep(1500);
                System.out.println("Entering " + userValue + " on element " + elementName);
                WebElement input = driver.findElement(By.xpath(locator));
                input.clear();
                input.sendKeys(userValue);
            } catch (Exception e) {
                System.out.println("Unable to enter keyword on element - " + elementName + e);
            }
        }//end of send keys method

        //********************************************************************
        //method to enter a keyword on an element by index number
        public static void typeByIndex(WebDriver driver, String locator, String userValue, int indexNum, String elementName){
            try{
                Thread.sleep(1500);
                System.out.println("Entering " + userValue + " on element " + elementName + " by index number " + indexNum);
                WebElement input = driver.findElements(By.xpath(locator)).get(indexNum);
                input.clear();
                input.sendKeys(userValue);
            } catch (Exception e) {
                System.out.println("Unable to enter keyword on element - " + elementName + " by index number... " + e);
            }
        }//end of send keys by index number method

        //********************************************************************
        //method to enter a keyword on an element using mouse movement
        public static void typeUsingMouse(WebDriver driver, String locator, String userValue, String elementName){
            Actions mouseAction = new Actions(driver);
            try{
                Thread.sleep(1500);
                System.out.println("Entering " + userValue + " on element " + elementName);
                WebElement input = driver.findElement(By.xpath(locator));
                mouseAction.moveToElement(input).click().sendKeys(Keys.CLEAR);
                mouseAction.moveToElement(input).click().sendKeys(userValue);
            } catch (Exception e) {
                System.out.println("Unable to enter keyword on element - " + elementName + e);
            }
        }//end of send keys method

        //********************************************************************
        //method to switch tab
        public static void switchTab(WebDriver driver, int tabNumber) throws InterruptedException {
            System.out.println("Switching to tab " + tabNumber);
            //define window handle for tabs
            Thread.sleep(2000);
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            //switch to specific tab
            driver.switchTo().window(tabs.get(tabNumber));
        }//end of switch to tab method

        //********************************************************************
        //method to select an element by visiable tag using select command
        public static void dropDownSelect(WebDriver driver, String locator, String userSelect, String elementName){
            try{
                Thread.sleep(1500);
                System.out.println("Selecting " + userSelect + " from drop down " + elementName);
                WebElement element = driver.findElement(By.xpath(locator));
                Select select = new Select(element);
                select.selectByVisibleText(userSelect);
            } catch (Exception e) {
                System.out.println("Unable to select value from drop down - " + elementName + " - " + e);
            }
        }//end of select method

        //********************************************************************
        //method to compare two text... Expected vs Actual
        public static void verifyText(WebDriver driver, String locator, String expectedText, String elementName){
            try{
                Thread.sleep(1500);
                System.out.println("Verify text expected text on " + elementName);
                WebElement element = driver.findElement(By.xpath(locator));
                String actualtext = element.getText();
                if(expectedText.equals(actualtext)){
                    System.out.println("Text verification matches for " + elementName);
                } else {
                    System.out.println("Expected doesn't match actual and actual text is " + actualtext);
                }
            } catch (Exception e) {
                System.out.println("Unable to get text value from " + elementName + " - " + e);
            }
        }//end of verifytext method

        //********************************************************************
        //method to capture and return text from a webElement
        public static String captureText(WebDriver driver, String locator, String elementName){
            String textElement = null;
            try{
                Thread.sleep(1500);
                System.out.println("Capture text from " + elementName);
                WebElement element = driver.findElement(By.xpath(locator));
                textElement = element.getText();
            } catch (Exception e) {
                System.out.println("Unable to get text value from " + elementName + " - " + e);
            }
            return textElement;
        }//end of capture text method

        //********************************************************************
        //method to compare expected vs actual title
        public static void verifyPageTitle(WebDriver driver, String expectedTitle) {
            try {
                Thread.sleep(1500);
                System.out.println("Verifying page expected title on");
                String actualTitle = driver.getTitle();
                if (expectedTitle.equals(actualTitle)) {
                    System.out.println("Title matches for - " + expectedTitle);
                } else {
                    System.out.println("Expected doesn't match actual and actual title is " + actualTitle);
                }
            } catch (Exception e) {
                System.out.println("Unable to get page title - " + e);

            }
            //*******************

        }//end of comparing expected vs actual title method


    }//end of parent class



