package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

import managers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import pageObject.BookMotorHomePage;
import pageObject.GoogleHomePage;

public class Steps {
    String searchBrand;
    WebDriver driver;
    WebDriverManager webDriverManager;
    GoogleHomePage googleHomePage;
    BookMotorHomePage bookMotorHomePage;
    FluentWait wait;

    @Before
    public void beforeScenario() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        driver.manage().window().maximize();
        googleHomePage = new GoogleHomePage(driver);
        bookMotorHomePage = new BookMotorHomePage(driver);
        wait = webDriverManager.getFluentWait();
    }

    @Given("user is on Google Home Page")
    public void userIsOnGoogleHomePage() {
        driver.get("https://www.google.com/");
    }

    @When("user searches for {string}")
    public void userSearchesFor(String brand) {
        searchBrand = brand;
        googleHomePage.googleSearch(brand);
    }

    @Then("user goes to {string} rental home page")
    public void userGoesToRentalHomePage(String brand) {
        googleHomePage.clickOnSearchLink(brand);
        bookMotorHomePage.waitForRentalPage();
    }

    @When("user provides {string}")
    public void userProvides(String destination) {
        bookMotorHomePage.selectDestination(destination);
    }

    @And("user provides book details {string}, {string}, {string}, {string}, {string} and {string}")
    public void userProvidesBookDetailsAnd(String pickUpDate, String dropOffDate, String pickUpLocation,
            String dropOffLocation, String passengers, String driverLicence) {

        String splits[] = pickUpDate.split("-");

        bookMotorHomePage.selectPickUpDate(splits[0], splits[1], splits[2]);
        splits = dropOffDate.split("-");
        bookMotorHomePage.selectDropOffDate(splits[0], splits[1], splits[2]);
        bookMotorHomePage.selectPickUpLocation(pickUpLocation);
        bookMotorHomePage.selectDropOffLocation(dropOffLocation);
        splits = passengers.split("-");
        bookMotorHomePage.fillPassengers(splits[0].substring(1),splits[1].substring(1));
        //bookMotorHomePage.waitForLicenseElement();
        bookMotorHomePage.selectDriverLicence(driverLicence);
    }

    @And("user clicks on SEARCH button")
    public void userClicksOnSEARCHButton() {
        bookMotorHomePage.clickOnSearch();
    }

    @Then("there should be {string} results returned")
    public void thereShouldBeResultsReturned(String searchResult) {
        bookMotorHomePage.waitForResult();
        int searchResultCount=0;
        if (searchBrand.equalsIgnoreCase("maui"))
            assertEquals(searchResult,bookMotorHomePage.getBrandMCount());
        else
            assertEquals(searchResult,bookMotorHomePage.getBrandBCount());
    }

    @After
    public void afterScenario() {
        driver.close();
        driver.quit();
    }

}
