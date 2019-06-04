package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage{

@FindBy(xpath = "//input[@name='q']")
private WebElement searchField;

@FindBy(xpath = "//*[@id='center_col']")
private WebElement searchResultsContainer;

@FindBy(xpath = "//div[@class='r']/a/h3")
private List<WebElement> searchResultElements;

@FindBy(xpath = "//*[@id='nav']//td[3]/a")
private WebElement pageNumber2;



    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnPageNumber2() {
        pageNumber2.click();
    }

    public boolean isPageLoaded() {
        return searchResultsContainer.isDisplayed();
    }

    public int getSearchResultsCount() {
        return searchResultElements.size();
    }

    public List<String> getSearchResultsText() {
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchResultElement : searchResultElements) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }
}
