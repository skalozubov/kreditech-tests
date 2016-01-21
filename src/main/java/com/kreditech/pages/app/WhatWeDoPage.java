package com.kreditech.pages.app;

import com.kreditech.helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhatWeDoPage extends BaseKreditechPage {
    @FindBy(xpath = "//div[text() = \"What we do\"]")
    private WebElement pageHeader;

    public WhatWeDoPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return SeleniumHelper.isElementPresentAndVisible(pageHeader);
    }
}
