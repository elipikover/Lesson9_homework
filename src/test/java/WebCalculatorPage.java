import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.xml.sax.Locator;

public class WebCalculatorPage extends BasePage{


    public void pressClear(){
        clickElement(By.id("clear"));
    }
    public void pressTwo(){
        clickElement(By.id("two"));
    }
    public void pressMultiply(){
        clickElement(By.id("multiply"));
    }
    public void pressFive(){
        clickElement(By.id("five"));
    }
    public void pressEquals(){
        clickElement(By.id("equal"));

    }


}
