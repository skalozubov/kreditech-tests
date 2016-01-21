package com.kreditech.pages.app;

import com.kreditech.helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhoWeArePage extends BaseKreditechPage {
    @FindBy(xpath = "//div[text() = \"Who we are\"]")
    private WebElement pageHeader;

    public WhoWeArePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return SeleniumHelper.isElementPresentAndVisible(pageHeader);
    }
}
