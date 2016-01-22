package com.kreditech.pages.twitter;

import com.kreditech.helpers.SeleniumHelper;
import com.kreditech.pages.BasePage;
import com.kreditech.users.TwitterUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TwitterLoginPage extends BasePage {
    @FindBy(id = "username_or_email")
    private WebElement userNameInputField;

    @FindBy(id = "password")
    private WebElement passwordInputFiled;

    @FindBy(name = "commit")
    private WebElement submitLoginButton;

    public TwitterLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return SeleniumHelper.isElementPresentAndVisible(userNameInputField);
    }

    public TwitterFollowPage loginAndFollow(TwitterUser twitterUser) {
        userNameInputField.sendKeys(twitterUser.getUsername());
        passwordInputFiled.sendKeys(twitterUser.getPassword());
        submitLoginButton.click();
        return new TwitterFollowPage(driver);
    }
}
