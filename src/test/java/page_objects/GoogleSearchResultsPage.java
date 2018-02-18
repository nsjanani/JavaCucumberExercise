package page_objects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class GoogleSearchResultsPage extends BasePage {

    final static Logger logger = Logger.getLogger(GoogleSearchResultsPage.class);

    @FindBy(how = How.ID, using = "rso")
    private WebElement searchResult;

    public GoogleSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public ArrayList getAllGumTreeLinks(String searckKey) {
        waitForPageload(driver);
        assertTrue("Invalid Page Title", driver.getTitle().equals(searckKey + " - Google Search"));

        ArrayList<String> resultLinksAddress = new ArrayList<String>();

        logger.info("Validating the search results link...");
        List<WebElement> resultLinkParentList = searchResult.findElements(By.tagName("h3"));
        for(WebElement resultLinkParent : resultLinkParentList) {
            if(!(resultLinkParent.getText().equalsIgnoreCase("Top stories"))) {
                WebElement resultLink = resultLinkParent.findElement(By.tagName("a"));
                if(resultLink.getAttribute("href").contains("www.gumtree.com")) {
                    resultLinksAddress.add(resultLink.getAttribute("href"));
                }
            }
        }
        logger.info("Got " + resultLinksAddress.size() +" Gumtree links...");
        return resultLinksAddress;
    }

}
