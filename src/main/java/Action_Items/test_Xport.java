package Action_Items;

import day7_02012020.Reusable_Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static day7_02012020.Reusable_Methods.navigate;
import static day7_02012020.Reusable_Methods.type;

public class test_Xport extends Reusable_Methods{

    static WebDriver driver = null;

    public static void main(String[] args) throws IOException, InterruptedException {

     driver = navigate(driver,"https://cs92.salesforce.com/0063F00000JZzl8QAD");
     type(driver,"//*[@name=\"username\"]","brett.giroux2@xaxis.com.glstaging","User Name Field");
     type(driver,"//*[@id=\"password\"]","xaxisAuto#23","Password Field");
     click(driver,"//*[@id=\"Login\"]","Login Button");
     Thread.sleep(2000);
     click(driver,"//*[@alt=\"Xport\"]","Xport Button");
     switchTab(driver,1);
     Thread.sleep(1500);
     click(driver,"//*[contains(text(),\"Login\")]","Xport Login Button");
     Thread.sleep(2800);
     String val = driver.findElement(By.xpath("//*[text()='CPCV']")).getText();
     System.out.println("My value is " + val);
     type(driver,"//*[text()='CPCV']/following::td[@class='userInput']/div/input[contains(@name,'Viewability_Rate')]","0","CPCV Viewability Rate Field");


    }//end of main




}
