package functionLibrary;

import io.cucumber.java.bs.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CommonFunctions {

    public static WebDriver driver;
    public static String configFilePath = new File("src/main/resources/testData/config.properties").getAbsolutePath();
    public static String screenShotPath = new File("src/main/resources/scrShots").getAbsolutePath();
    public void openBrowser()
    {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    public void closeBrowser()
    {
        driver.quit();
    }

    public void waitForTime(int waittime)
    {
        driver.manage().timeouts().implicitlyWait(waittime, TimeUnit.SECONDS);
    }

    public String readPropertyFile(String key) throws Exception
    {
        FileInputStream inputStream = new FileInputStream(configFilePath);
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties.getProperty(key);
    }

    public static void selectDropDown(WebElement element, String value)
    {
        new Select(element).selectByVisibleText(value);
    }

    public static void enterText (WebElement element, String value)
    {
        element.sendKeys(value);
    }

    public static void mouseOver (WebElement element)
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public static void jsClick(WebElement element)
    {

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
    }

    public static void handleCookies(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions
                .visibilityOf(element)).click();
    }

    public static void takeScreenShot(String fileName) throws Exception
    {

        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File virtualFile = screenshot.getScreenshotAs(OutputType.FILE);
        File physicalFile = new File (screenShotPath + fileName);
        FileUtils.copyFile(virtualFile, physicalFile);
    }


}
