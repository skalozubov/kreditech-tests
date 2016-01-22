package com.kreditech.pages.app;

import com.kreditech.helpers.SeleniumHelper;
import com.kreditech.pages.BasePage;
import com.kreditech.pages.twitter.TwitterLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BaseKreditechPage extends BasePage {
    @FindBy(id = "footer")
    protected WebElement footer;

    @FindBy(xpath = "//a[@title = \"who\"]")
    protected WebElement whoWeAreMenuItem;

    @FindBy(xpath = "//a[@title = \"what\"]")
    protected WebElement whatWeDoMenuItem;

    @FindBy(xpath = "//a[@title = \"work\"]")
    protected WebElement careersMenuItem;

    @FindBy(xpath = "//a[@title = \"contact\"]")
    protected WebElement contactMenuItem;

    @FindBy(xpath = "//li/a[text() = \"Press\"]")
    protected WebElement pressMenuItem;

    @FindBy(xpath = "//li/a[text() = \"Blog\"]")
    protected WebElement blogMenuItem;

    @FindBy(xpath = "//li/a[text() = \"Investor Relations\"]")
    protected WebElement investorRelationsMenuItem;

    @FindBy(id = "twitter-widget-0")
    protected WebElement twitterWidget;

    @FindBy(xpath = ".//iframe[contains(@src, \"youtube\")]")
    protected WebElement youtubeWidget;

    @FindBy(xpath = ".//iframe[contains(@src, \"facebook\")]")
    protected WebElement facebookWidget;

    @FindBy(css = ".follow-button")
    private WebElement followOnTwitterButton;

    public BaseKreditechPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSocialSectionPresent() {
        return SeleniumHelper.isElementDisplayed(driver, twitterWidget) &&
                SeleniumHelper.isElementDisplayed(driver, youtubeWidget) &&
                SeleniumHelper.isElementDisplayed(driver, facebookWidget);
    }

    public WhatWeDoPage openWhatWeDoPage() {
        whatWeDoMenuItem.click();
        return new WhatWeDoPage(driver);
    }

    public CareersPage openCareersPage() {
        careersMenuItem.click();
        return new CareersPage(driver);
    }

    public InvestorRelationsPage openInvestorRelationsPage() {
        investorRelationsMenuItem.click();
        return new InvestorRelationsPage(driver);
    }

    public PressPage openPressPage() {
        pressMenuItem.click();
        return new PressPage(driver);
    }

    public BlogPage openBlogPage() {
        blogMenuItem.click();
        return new BlogPage(driver);
    }

    public ContactPage openContactPage() {
        contactMenuItem.click();
        return new ContactPage(driver);
    }

    public WhoWeArePage openWhoWeArePage() {
        whoWeAreMenuItem.click();
        return new WhoWeArePage(driver);
    }

    public TwitterLoginPage clickFollowOnTwitterButtonAndSwitchContext() {
        String pageContext = driver.getWindowHandle();
        driver.switchTo().frame(twitterWidget);
        followOnTwitterButton.click();
        SeleniumHelper.sleepForOneSecond();
        SeleniumHelper.switchContext(driver, pageContext);
        return new TwitterLoginPage(driver);
    }
}
