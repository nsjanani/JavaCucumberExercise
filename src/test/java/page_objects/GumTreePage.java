package page_objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.TestCase.assertTrue;

public class GumTreePage extends BasePage {

    final static Logger logger = Logger.getLogger(GumTreePage.class);

    @FindBy(how = How.CLASS_NAME, using = "gumtree-text-svg")
    private WebElement gumTreeTitle;

    public GumTreePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void verifyGumTreeTitle() {
        waitForPageload(driver);
        logger.info("Verifying title displayed...");
        assertTrue("Gumtree title not displayed", gumTreeTitle.isDisplayed());
    }

}
