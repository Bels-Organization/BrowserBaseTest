package browserBaseTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowserTest {

    @Test
    public void openBrowserTest () {
        BrowserBaseTest browserBaseTest = new BrowserBaseTest();
        WebDriver webDriver = BrowserBaseTest.openBrowser("https://www.google.es");
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
}