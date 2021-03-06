package com.kreditech.pages.twitter;

import com.kreditech.helpers.SeleniumHelper;
import com.kreditech.pages.BasePage;
import com.kreditech.pages.app.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class TwitterFollowPage extends BasePage {
    @FindBy(css = ".follow > button")
    private WebElement followButton;

    @FindBy(css = ".unfollow > button")
    private WebElement unfollowButton;

    public TwitterFollowPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return SeleniumHelper.isElementPresentAndVisible(unfollowButton);
    }

    @Step("Click Unfollow button")
    public void clickUnfollow() {
        unfollowButton.click();
        SeleniumHelper.waitForElementToBeClickable(driver, followButton);
    }

    @Step("Close Twitter popup")
    public HomePage closeWindowAndSwitchContextToDefault() {
        driver.close();
        SeleniumHelper.switchToDefaultContext(driver);
        return new HomePage(driver);
    }
}
