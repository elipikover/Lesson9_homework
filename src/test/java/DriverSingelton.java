import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSingelton {
public static WebDriver driver;

    public static WebDriver getDriverInstance(){
    if (driver == null){
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER);
        driver = new ChromeDriver();
    }
    return driver;
    }

}
