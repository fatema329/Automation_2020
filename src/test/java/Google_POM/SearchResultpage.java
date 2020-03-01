package Google_POM;

import Reusable_Library.Abstract_Class;
import com.relevantcodes.extentreports.ExtentTest;
import day7_02012020.Reusable_Methods;
import org.graalvm.compiler.core.sparc.SPARCLIRGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends Abstract_Class_Regular {
    //declare your logger locally when you use page object
    ExtentTest logger;
    //constructor method is when a child/sub-class having identical
    //name as parent class
    public Homepage(WebDriver driver){
        super();
        PageFactory.initElements(driver, page this);
        this.logger = super.logger;
            }//end of page object constructor
    String searchFieldLoc = "//*[@name= 'q']";

    public Homepage userSearch(String useValue) {
        Reusable_Methods_Reports.type(driver, locator: "", useValue, logger, ele)

        return new Homepage(driver);
    }//end of userSearch method

    //clicking on submit
    public Homepage submitOnSearchField(){
        Reusable_Methods_Reports.submit(driver,searchFieldLoc, logger, elementName: "Search Field");
        return new Homepage(driver);

    }//end of submit method


}
