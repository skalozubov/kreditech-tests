package com.kreditech.tests;

import com.kreditech.BaseTest;
import com.kreditech.pages.app.*;
import com.kreditech.pages.google.SearchPage;
import com.kreditech.pages.google.SearchResultsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.testng.Assert.assertTrue;

@Features("Social widgets")
public class SocialSectionTests extends BaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void prepareState() {
        String searchString = "kreditech";

        SearchPage searchPage = new SearchPage(driver);
        SearchResultsPage searchResultsPage = searchPage.searchFor(searchString);
        homePage = searchResultsPage.selectResultWithKreditechSite();
    }

    @Test
    @Stories("User should see social widgets on the Home page")
    public void userShouldSeeSocialWidgetsOnTheHomePage() {
        assertTrue(homePage.isSocialSectionPresent(), "Social section is absent on the Home page");
    }

    @Test
    @Stories("User should see social widgets on the What We Do page")
    public void userShouldSeeSocialWidgetsOnTheWhatWeDoPage() {
        WhatWeDoPage whatWeDoPage = homePage.openWhatWeDoPage();
        assertTrue(whatWeDoPage.isSocialSectionPresent(), "Social section is absent on the What We Do page");
    }

    @Test
    @Stories("User should see social widgets on the Who We Are page")
    public void userShouldSeeSocialWidgetsOnTheWhoWeArePage() {
        WhoWeArePage whoWeArePage = homePage.openWhoWeArePage();
        assertTrue(whoWeArePage.isSocialSectionPresent(), "Social section is absent on the Who We Are page");
    }

    @Test
    @Stories("User should see social widgets on the Careers page")
    public void userShouldSeeSocialWidgetsOnTheCareersPage() {
        CareersPage careersPage = homePage.openCareersPage();
        assertTrue(careersPage.isSocialSectionPresent(), "Social section is absent on the Careers page");
    }

    @Test
    @Stories("User should see social widgets on the Investor Relations page")
    public void userShouldSeeSocialWidgetsOnTheInvestorRelationsPage() {
        InvestorRelationsPage investorRelationsPage = homePage.openInvestorRelationsPage();
        assertTrue(investorRelationsPage.isSocialSectionPresent(),
                "Social section is absent on the Investor Relations page");
    }

    @Test
    @Stories("User should see social widgets on the Press page")
    public void userShouldSeeSocialWidgetsOnThePressPage() {
        PressPage pressPage = homePage.openPressPage();
        assertTrue(pressPage.isSocialSectionPresent(), "Social section is absent on the Press page");
    }

    @Test
    @Stories("User should see social widgets on the Blog page")
    public void userShouldSeeSocialWidgetsOnTheBlogPage() {
        BlogPage blogPage = homePage.openBlogPage();
        assertTrue(blogPage.isSocialSectionPresent(), "Social section is absent on the Blog page");
    }

    @Test
    @Stories("User should see social widgets on the Contact page")
    public void userShouldSeeSocialWidgetsOnTheContactPage() {
        ContactPage contactPage = homePage.openContactPage();
        assertTrue(contactPage.isSocialSectionPresent(), "Social section is absent on the Contact page");
    }
}
