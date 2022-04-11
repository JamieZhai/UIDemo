package pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage {
    public GoogleHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@title=\"Search\"]")
    private WebElement txtSearchInput;

    @FindBy(xpath = "//a[@href=\"https://www.maui-rentals.com/\"]")
    private WebElement lnkMauiMotorHomes;

    @FindBy(xpath = "//a[@href=\"https://www.britz.com/\"]")
    private WebElement lnkBritzMotorHomes;

    public void googleSearch(String search) {
        txtSearchInput.sendKeys(search);
        txtSearchInput.sendKeys(Keys.RETURN);
    }

    public void clickOnSearchLink(String brand) {
        if (brand.equalsIgnoreCase("maui"))
            lnkMauiMotorHomes.click();
        else if (brand.equalsIgnoreCase("britz"))
            lnkBritzMotorHomes.click();
    }
}
