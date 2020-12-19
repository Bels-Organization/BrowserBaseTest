package browserBaseTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Optional;

public class OpenBrowserTest {

    @Test
    public void openBrowserTest () {
        BrowserBaseTest browserBaseTest = new BrowserBaseTest();
        WebDriver webDriver = BrowserBaseTest.openBrowser("https://www.google.es", "src/main/resources/chromedriver.exe");
        Assert.assertTrue(webDriver.getCurrentUrl().contentEquals("https://www.google.es/"));
    }

    @Test
    public void closeBrowserTest () {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        BrowserBaseTest browserBaseTest = new BrowserBaseTest();
        browserBaseTest.closeBrowser(webDriver);
        Assert.assertTrue(webDriver.getCurrentUrl().contains("error=invalid session id"));
    }

    @Test
    public void waitForPageToLoadTest () {
        BrowserBaseTest browserBaseTest = new BrowserBaseTest();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver webDriver = BrowserBaseTest.openBrowser("https://www.google.es", "src/main/resources/chromedriver.exe");
        webDriver.switchTo().frame(0);
        List<WebElement> agreeBtn = webDriver.findElements(By.xpath("/html/body/div/c-wiz/div[2]/div/div/div/div/div[2]/form/div/span/span"));

        if (agreeBtn.size() != 0) {
            webDriver.findElement(By.id("introAgreeButton")).click();
        }

        WebElement input = webDriver.findElement(By.name("q"));
        input.sendKeys("Mallorca");
        input.submit();
        browserBaseTest.waitForPageToLoad(webDriver);
        Assert.assertTrue(webDriver.getTitle().contains("Mallorca"));
    }
}