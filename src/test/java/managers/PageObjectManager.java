package managers;

import org.openqa.selenium.WebDriver;
import pageObject.BookMotorHomePage;
import pageObject.GoogleHomePage;

public class PageObjectManager {
    private final WebDriver driver;
    private GoogleHomePage googleHomePage;
    private BookMotorHomePage bookMotorHomePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public GoogleHomePage getGoogleHomePage() {
        return (googleHomePage == null) ?
                googleHomePage = new GoogleHomePage(driver) :
                googleHomePage;
    }

    public BookMotorHomePage getBookMauiPage() {
        return (bookMotorHomePage == null) ? bookMotorHomePage = new BookMotorHomePage(driver) : bookMotorHomePage;
    }
}
