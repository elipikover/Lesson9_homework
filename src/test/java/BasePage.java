import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {


    public void clickElement(By locator){
        getWeElement(locator).click();}


    public void sendKeys(By locator, String keyz){
        getWeElement(locator).sendKeys(keyz);}


    public WebElement getWeElement(By locator){
        return DriverSingelton.getDriverInstance().findElement(locator);}

}
