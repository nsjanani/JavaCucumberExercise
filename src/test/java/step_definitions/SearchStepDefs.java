package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import page_objects.GoogleHomePage;
import page_objects.GoogleSearchResultsPage;
import page_objects.GumTreePage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchStepDefs {

    WebDriver driver;
    Scenario scenario;

    GoogleHomePage googleHomePage;
    GoogleSearchResultsPage googleSearchResultsPage;
    GumTreePage gumTreePage;

    ArrayList<String> validGumTreeLinks;

    @Before
    public void setUp(Scenario scenario) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        initPageObjects();
        this.scenario = scenario;
    }

    @After
    public void cleanUp() {
        scenario.write("Finished scenario " + scenario.getName());
        driver.quit();
    }

    public void initPageObjects() {
        googleHomePage = new GoogleHomePage(driver);
        googleSearchResultsPage = new GoogleSearchResultsPage(driver);
        gumTreePage = new GumTreePage(driver);
    }

    @When("^I open \"([^\"]*)\"$")
    public void iOpenA(String webAddress) throws Throwable {
       driver.get("http://" + webAddress);
       scenario.write("Opened " +webAddress);
    }

    @And("^search for \"([^\"]*)\"$")
    public void searchFor(String searchKey) throws Throwable {
        googleHomePage.performSearch(searchKey);
        scenario.write("Searched for " + searchKey);
    }

    @Then("^get all Gumtree links from search results displayed for \"([^\"]*)\"$")
    public void getAllGumtreeLinksFromSearchResultsDisplayedFor(String searchKey) throws Throwable {
        validGumTreeLinks = googleSearchResultsPage.getAllGumTreeLinks(searchKey);
        scenario.write("Got " + validGumTreeLinks.size() + " Gumtree links in search results");
    }

    @And("^go to all Gumtree links to validate Gumtree title displayed$")
    public void goToAllGumtreeLinksToValidateGumtreeTitleDisplayed() throws Throwable {
        for(String resultLinkAddress : validGumTreeLinks) {
            driver.get(resultLinkAddress);
            gumTreePage.verifyGumTreeTitle();
        }
        scenario.write("Validated Gumtree Title in all the result links available");
    }

}

