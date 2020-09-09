package core.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonWebdriver {

    private static WebDriver driver;

    public SingletonWebdriver() {
    }

    public static WebDriver getInstance() {

        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void closeInstance() {
        driver.quit();
        driver = null;
    }
}
