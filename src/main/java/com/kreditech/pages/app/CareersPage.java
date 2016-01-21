package com.kreditech.pages.app;

import com.kreditech.helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPage extends BaseKreditechPage {
    @FindBy(xpath = "//div[text() = \"Vacancies\"]")
    private WebElement vacanciesItem;

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return SeleniumHelper.isElementPresentAndVisible(vacanciesItem);
    }
}
