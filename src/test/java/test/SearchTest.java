package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchResultsPage;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test
    public void basicSearchTest() {
        String searchTerm = "selenium";

        Assert.assertTrue(homePage.isPageLoaded(), "HomePage is not loaded");
        SearchResultsPage searchResultsPage = homePage.search(searchTerm);
        Assert.assertTrue(searchResultsPage.isPageLoaded(), "SearchResults page is not loaded.");
        Assert.assertEquals(searchResultsPage.getSearchResultsCount(), 10,
                "Search results count is wrong.");
        List<String> searchResults = searchResultsPage.getSearchResultsText();
        for (String searchResult : searchResults) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm),
                    "Search term: " + searchTerm + " not found in: \n" + searchResult);
        }

        searchResultsPage.clickOnPageNumber2();

        Assert.assertTrue(searchResultsPage.isPageLoaded(), "SearchResults page is not loaded.");
        Assert.assertEquals(searchResultsPage.getSearchResultsCount(), 10,
                "Search results count is wrong.");
        searchResultsPage.getSearchResultsText();
        for (String searchResult : searchResults) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm),
                    "Search term: " + searchTerm + " not found in: \n" + searchResult);
        }
    }


}

