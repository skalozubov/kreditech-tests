package com.kreditech.tests;

import com.kreditech.pages.google.SearchPage;
import com.kreditech.pages.app.HomePage;
import com.kreditech.pages.google.SearchResultsPage;
import org.testng.annotations.Test;
import com.kreditech.BaseTest;

import static org.testng.Assert.assertTrue;

public class GoogleSearchTest extends BaseTest {

    @Test
    public void userShouldBeAbleToFindKreditechSiteInGoogle() {
        String searchString = "kreditech";

        SearchPage searchPage = new SearchPage(driver);
        SearchResultsPage searchResultsPage = searchPage.searchFor(searchString);
        HomePage homePage = searchResultsPage.selectResultWithKreditechSite();
        assertTrue(homePage.isSocialSectionPresent(), "Social section is absent on the Home page");
    }
}
