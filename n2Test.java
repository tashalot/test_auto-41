import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class n2Test
{

    private AppiumDriver driver;
    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/Users/natalya.lapkovskaya/Desktop/JavaAppiumAutomation_01/apks/org.wikipedia.apk");
        capabilities.setCapability("automationName", "UiAutomator1"); //когда запускала аппиум, он зафэйлился с ошибкой, где в трейсе были указаны эти параметры, которые нужно добавить, если хочу продолжать использвать дальше эту версию

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown()
    {
        driver.quit();

    }
    @Test
    public void n2Test()
    {
        WebElement skipButton = driver.findElementByXPath("//*[contains(@text, 'SKIP')]");
        skipButton.click();

        waitForElementAndClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Cannot find Search Wikipedia",
                5
        );
        assertElementHasText(
                By.id("org.wikipedia:id/search_src_text"),
                "Search Wikipedia",
                "Cannot find 'text Search Wikipedia'",
                15);
    }
    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message,timeoutInSeconds);
        element.click();
        return element;

    }
    private WebElement assertElementHasText(By by, String text, String error_message, long timeoutInSeconds)
    {
        WebElement element = waitForElementPresent(by, error_message,timeoutInSeconds);
        element.getAttribute("text");
        return element;
    }
}