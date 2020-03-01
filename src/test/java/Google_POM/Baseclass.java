package Google_POM;

import Reusable_Library.Abstract_Class;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.cdbg.BaseClass;

public class Baseclass extends Abstract_Class_Regular {

    public BaseClass (WebDriver driver) {
        super();
        PageFactory.initElements(driver, page: this);
        this.logger = super.logger;
            }//end of page object constructor

  /// Object for google home page
    public static Homepage homepage() {
        Homepage homepage = new Homepage(driver);
        return homepage
    }
}
