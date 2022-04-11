package pageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import managers.WebDriverManager;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookMotorHomePage {
    WebDriver driver;

    public BookMotorHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "form_country__main")
    private WebElement txtDestinationCountry;

    @FindBy(xpath = "//button[text()=\"Pick Up Date\"]")
    private WebElement btnPickUpDate;

    @FindBy(xpath = "//button[text()=\"Drop Off Date\"]")
    private WebElement btnDropOffDate;

    @FindBy(xpath = "//div[@id=\"datepicker__main\"]/div/div/div/span[@class=\"ui-datepicker-month\"]")
    private WebElement lblDatePickerMonth;

    @FindBy(xpath = "//div[@id=\"datepicker__main\"]/div/div/div/span[@class=\"ui-datepicker-year\"]")
    private WebElement lblDatePickerYear;

    @FindBy(xpath = "//div[@id=\"datepicker__main\"]/div/div/a[@title=\"Next\"]")
    private WebElement btnNextMonth;

    @FindBy(id = "form_location_pickUp__main")
    private WebElement txtPickUpLocation;

    @FindBy(id = "form_location_dropOff__main")
    private WebElement txtDropOffLocation;

    @FindBy(xpath = "//form[@id=\"form_main\"]/div/div/button[text()=\"Passengers\"]")
    private WebElement txtPassengers;

    @FindBy(xpath = "//form[@id=\"form_main\"]/div/label/div/select[@id=\"form_adults__main\"]")
    private WebElement txtAdults;

    @FindBy(xpath = "//form[@id=\"form_main\"]/div/label/div/select[@id=\"form_children__main\"]")
    private WebElement txtChildren;

    @FindBy(xpath = "//form[@id=\"form_main\"]/div/div[select]")
    private WebElement divDriveLicence;

    @FindBy(xpath = "//div[@class=\"chosen-search\"]/input")
    private WebElement txtChosenLicence;

    @FindBy(xpath = "//form[@id=\"form_main\"]/button[span[text()=\"Search \"]]")
    private WebElement btnSearch;

    @FindBy(xpath = "//div[contains(@data-reactid, \"SearchLoading\")]")
    private WebElement lbnSearchLoading;

    @FindBy(xpath = "//div[@data-brand=\"m\"]/following-sibling::span/span[2]/span")
    private WebElement lblBrandMCount;

    @FindBy(xpath = "//div[@data-brand=\"b\"]/following-sibling::span/span[2]/span")
    private WebElement lblBrandBCount;

    public void waitForRentalPage() {
        FluentWait wait = new FluentWait(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("form_country__main")));
    }

    public void selectDestination (String destination) {
        Select select = new Select(txtDestinationCountry);
        select.selectByVisibleText(destination);
    }

    private int parseMonth (String month) {
        int result = 0;
        switch (month) {
            case "January": result = 1; break;
            case "Jan": result = 1; break;
            case "01": result = 1; break;
            case "February": result = 2; break;
            case "Feb": result = 2; break;
            case "02": result = 2; break;
            case "March": result = 3; break;
            case "Mar": result = 3; break;
            case "03": result = 3; break;
            case "April": result = 4; break;
            case "Apr": result = 4; break;
            case "04": result = 4; break;
            case "May": result = 5; break;
            case "05": result = 5; break;
            case "June": result = 6; break;
            case "Jun": result = 6; break;
            case "06": result = 6; break;
            case "July" : result = 7; break;
            case "Jul" : result = 7; break;
            case "07" : result = 7; break;
            case "August": result = 8; break;
            case "Aug": result = 8; break;
            case "08": result = 8; break;
            case "September": result = 9; break;
            case "Sep": result = 9; break;
            case "09": result = 9; break;
            case "October": result = 10; break;
            case "Oct": result = 10; break;
            case "10": result = 10; break;
            case "November": result = 11; break;
            case "Nov": result = 11; break;
            case "11": result = 11; break;
            case "December": result = 12; break;
            case "Dec": result = 12; break;
            case "12": result = 12; break;

        }
        return result;
    }

    public void selectPickUpDate (String date, String month, String year) {
        btnPickUpDate.click();
        FluentWait wait = new FluentWait(driver);
        wait.until(ExpectedConditions.visibilityOf(lblDatePickerYear));
        int defaultYear = Integer.parseInt(lblDatePickerYear.getText());
        int selectYear = Integer.parseInt(year);
        while (defaultYear <  selectYear) {
            btnNextMonth.click();
            defaultYear = Integer.parseInt(lblDatePickerYear.getText());
        }
        int defaultMonth = parseMonth(lblDatePickerMonth.getText());
        int selectMonth = parseMonth(month);
        while (defaultMonth < selectMonth) {
            btnNextMonth.click();
            defaultMonth = parseMonth(lblDatePickerMonth.getText());
        }
        driver.findElement(By.xpath("//a[@class=\"ui-state-default\" and text()="+date+"]")).click();
    }
    public void selectDropOffDate(String date, String month, String year) {

        btnDropOffDate.click();
        FluentWait wait = new FluentWait(driver);
        wait.until(ExpectedConditions.visibilityOf(lblDatePickerYear));
        int defaultYear = Integer.parseInt(lblDatePickerYear.getText());
        int selectYear = Integer.parseInt(year);
        while (defaultYear <  selectYear) {
            btnNextMonth.click();
            defaultYear = Integer.parseInt(lblDatePickerYear.getText());
        }
        int defaultMonth = parseMonth(lblDatePickerMonth.getText());
        int selectMonth = parseMonth(month);
        while (defaultMonth < selectMonth) {
            btnNextMonth.click();
            defaultMonth = parseMonth(lblDatePickerMonth.getText());
        }
        driver.findElement(By.xpath("//a[@class=\"ui-state-default\" and text()="+date+"]")).click();
    }

    public void selectPickUpLocation (String location) {
        Select select = new Select(txtPickUpLocation);
        select.selectByVisibleText(location);
    }

    public void selectDropOffLocation (String location) {
        Select select = new Select(txtDropOffLocation);
        select.selectByVisibleText(location);
    }

    public void fillPassengers(String a, String c) {
        txtPassengers.click();
        Select select = new Select(txtAdults);
        select.selectByVisibleText(a);
        select = new Select(txtChildren);
        select.selectByVisibleText(c);
        txtPassengers.click();
    }

    public void selectDriverLicence (String licence) {
        divDriveLicence.click();
        txtChosenLicence.sendKeys(licence);
        txtChosenLicence.sendKeys(Keys.RETURN);
    }

    public void clickOnSearch() {
        btnSearch.click();
    }

    public void waitForLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForResult() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.invisibilityOfAllElements(lbnSearchLoading));
    }

    public String getBrandMCount() {
        return lblBrandMCount.getText();
    }

    public String getBrandBCount() {
        return lblBrandBCount.getText();
    }

}
