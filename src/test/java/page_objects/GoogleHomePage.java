package page_objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;

public class GoogleHomePage extends BasePage {

    final static Logger logger = Logger.getLogger(GoogleHomePage.class);

    @FindBy(how = How.ID, using = "lst-ib")
    private WebElement searchTextBox;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void performSearch(String searckKey) {
        waitForPageload(driver);
        assertTrue("Incorrect Page Title", driver.getTitle().equals("Google"));
        assertTrue("Search Textbox is missing", searchTextBox.isDisplayed());
        logger.info("Perform search...");
        searchTextBox.sendKeys(searckKey + "\n");
    }

}
