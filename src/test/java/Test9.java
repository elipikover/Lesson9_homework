import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.io.File;
import java.io.IOException;


public class Test9 {

    public static WebDriver driver;

    @BeforeClass
    public void runBeforeTests() {
        driver.manage().window().maximize();

    }

    @Test(priority = 1)

    public void CalculatorTest() {
        WebCalculatorPage calculatorPage = new WebCalculatorPage();
        driver.get("https://dgotlieb.github.io/WebCalculator/");

//        get button 7 dimentions
        WebElement button7 = driver.findElement(By.id("seven"));
        int height = button7.getRect().getHeight();
        int width = button7.getRect().getWidth();
        System.out.println("button 7 dimentions are:\n Height = " + height + "\n Width = " + width);
//        check if 6 is displayed
        WebElement button6 =  driver.findElement(By.id("six"));
        Assert.assertTrue(button6.isDisplayed());

//        check formula on calculator
        String expectedCalcResult = "10";
        calculatorPage.pressClear();
        calculatorPage.pressTwo();
        calculatorPage.pressMultiply();
        calculatorPage.pressFive();
        calculatorPage.pressEquals();

        WebElement resultScreen = driver.findElement(By.id("screen"));
        Assert.assertEquals(expectedCalcResult, resultScreen.getText());
//
    }
//
//    @Test (priority = 2)
//     public void URLAssertionTest(){
//        driver.get("https://www.google.com/doodles");
//        String URL = driver.getCurrentUrl();
//        Assert.assertEquals(URL, "https://www.google.com/doodles" );
//    }
//
//        @Test(priority = 3)
//     public void titleAssertionTest(){
//            driver.get("https://www.google.com/doodles");
//        String title = driver.getTitle();
//        driver.navigate().refresh();
//        Assert.assertEquals(title, driver.getTitle());
//    }
//
//
//    @Test (priority = 4)
//    public void browserwithoutExtentions(){
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--disable-extensions");
//        driver.get("https://www.google.com/doodles");
//
//    }


        @Test(priority = 5)
        public void GitTest () {
            driver.get("https://dgotlieb.github.io/Actions/");
            WebElement element = driver.findElement(By.id("div1"));
            takeElementScreenshot(element);
            WebElement doubleClickButton = driver.findElement(By.xpath("/html/body/p[2]"));
            Actions actions = new Actions(driver);
            actions.doubleClick(doubleClickButton);
            actions.perform();
            WebElement demo = driver.findElement(By.id("demo"));
            Assert.assertTrue(demo.isDisplayed());
            WebElement Xbutton = driver.findElement(By.id("close"));
            actions.moveToElement(Xbutton).perform();
            Select foodlist = new Select(driver.findElement(By.cssSelector("select[name=food]")));
            foodlist.selectByIndex(0);
            foodlist.selectByVisibleText("Pasta");
            foodlist.deselectAll();
            String filePath = "/Users/epikover/Downloads/oneFile";
            WebElement chooseFile = driver.findElement(By.tagName("input"));
            chooseFile.click();
        }


        @AfterClass
        public void runAfterTests () throws InterruptedException {
            Thread.sleep(3000);
            driver.quit();
        }


        private void takeElementScreenshot (WebElement element){
            File screenShotFile = element.getScreenshotAs(OutputType.FILE); // take the screenshot
            try {
                FileUtils.copyFile(screenShotFile, new File("element-screenshot.png")); // save screenshot to disk
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

