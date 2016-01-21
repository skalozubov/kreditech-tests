package com.kreditech.pages.app;

import com.kreditech.helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvestorRelationsPage extends  BaseKreditechPage {
    @FindBy(xpath = "//div[text() = \"Board Members\"]")
    private WebElement investorsItem;

    public InvestorRelationsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return SeleniumHelper.isElementPresentAndVisible(investorsItem);
    }
}
