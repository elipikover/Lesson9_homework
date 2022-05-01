import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.swing.*;
import java.io.File;
import java.io.IOException;


public class Test9 {

private static WebDriver driver;


    @BeforeTest
    public void runBeforeTests(){

        System.setProperty("webdriver.chrome.driver", "/Users/epikover/IdeaProjects/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

//    @Test (priority = 1)

//    public void CalculatorTest(){
//        driver.get("https://dgotlieb.github.io/WebCalculator/");
//
////        get button 7 dimentions
//        WebElement button7 =  driver.findElement(By.id("seven"));
//        int height = button7.getRect().getHeight();
//        int width = button7.getRect().getWidth();
//        System.out.println("button 7 dimentions are:\n Height = "+height+"\n Width = "+width);
////        check if 6 is displayed
//        WebElement button6 =  driver.findElement(By.id("six"));
//        Assert.assertTrue(button6.isDisplayed());
//
////        check formula on calculator
//        String expectedCalcResult = "10";
//        WebElement clear = driver.findElement(By.id("clear"));
//        clear.click();
//        WebElement two = driver.findElement(By.id("two"));
//        two.click();
//        WebElement multiply = driver.findElement(By.id("multiply"));
//        multiply.click();
//        WebElement five = driver.findElement(By.id("five"));
//        five.click();
//        WebElement equal = driver.findElement(By.id("equal"));
//        equal.click();
//        WebElement resultScreen = driver.findElement(By.id("screen"));
//
//        Assert.assertEquals(expectedCalcResult,resultScreen.getText());
//
//    }

//    @Test (priority = 2)
//     public void URLAssertionTest(){
//        driver.get("https://www.google.com/doodles");
//        String URL = driver.getCurrentUrl();
//        Assert.assertEquals(URL, "https://www.google.com/doodles" );
//    }

//        @Test(priority = 3)
//     public void titleAssertionTest(){
//            driver.get("https://www.google.com/doodles");
//        String title = driver.getTitle();
//        driver.navigate().refresh();
//        Assert.assertEquals(title, driver.getTitle());
//    }


//    @Test (priority = 4)
//    public void browserwithoutExtentions(){
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-extensions");
//        driver.get("https://www.google.com/doodles");
//
//    }


@Test(priority = 5)
public void GitTest(){
    driver.get("https://dgotlieb.github.io/Actions/");
    WebElement element = driver.findElement(By.id("div1"));
    takeElementScreenshot(element);
    WebElement doubleClickButton = driver.findElement(By.xpath("/html/body/p[2]"));
    Actions doubleClick = new Actions(driver);
    doubleClick.doubleClick(doubleClickButton);
    doubleClick.perform();
    WebElement demo = driver.findElement(By.id("demo"));
    Assert.assertTrue(demo.isDisplayed());
}



    @AfterTest
    public void runAfterTests() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }



    private static void takeElementScreenshot(WebElement element){
        File screenShotFile = element.getScreenshotAs(OutputType.FILE); // take the screenshot
        try {
            FileUtils.copyFile(screenShotFile, new File("element-screenshot.png")); // save screenshot to disk
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
