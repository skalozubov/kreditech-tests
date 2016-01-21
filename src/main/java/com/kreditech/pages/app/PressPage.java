package com.kreditech.pages.app;

import com.kreditech.helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PressPage extends BaseKreditechPage {
    @FindBy(xpath = "//div[text() = \"Kreditech at a glance\"]")
    private WebElement pageHeader;

    public PressPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return SeleniumHelper.isElementPresentAndVisible(pageHeader);
    }
}
