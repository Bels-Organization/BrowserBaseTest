package browserBaseTest;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserBaseTest {

    /**
     * Opens a browser and navigates to the given url
     * @param url utl we want to open when launching the browser
     */
    public static WebDriver openBrowser(String url) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(url);
        return webDriver;
    }

    /**
     * Closes an open browser
     * @param webDriver webDriver controlling the browser to be closed
     */
    public void closeBrowser(WebDriver webDriver) {
        try {
            webDriver.close();
        } catch (NoSuchSessionException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits until the browser has loaded the page
     */
    public void waitForPageToLoad() {

    }
}
