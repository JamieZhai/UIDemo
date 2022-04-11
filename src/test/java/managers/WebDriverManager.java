package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class WebDriverManager {
    FluentWait wait;
    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null)
            driver = createDriver();
        wait = new FluentWait(driver);
        return driver;
    }

    public FluentWait getFluentWait() {
        return wait;
    }

    private WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver",
                "D:\\Jamie\\UIDemo\\src\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
