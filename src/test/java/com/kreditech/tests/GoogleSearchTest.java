package com.kreditech.tests;

import com.kreditech.pages.google.SearchPage;
import com.kreditech.pages.app.HomePage;
import com.kreditech.pages.google.SearchResultsPage;
import org.testng.annotations.Test;
import com.kreditech.BaseTest;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.testng.Assert.assertTrue;

@Features("Kreditech in Google")
public class GoogleSearchTest extends BaseTest {

    @Test
    @Stories("User should be able to find Kreditech site in Google")
    public void userShouldBeAbleToFindKreditechSiteInGoogle() {
        String searchString = "kreditech";

        SearchPage searchPage = new SearchPage(driver);
        SearchResultsPage searchResultsPage = searchPage.searchFor(searchString);
        HomePage homePage = searchResultsPage.selectResultWithKreditechSite();
        assertTrue(homePage.isPageCorrect(), "This is not Kreditech Home page");
    }
}
