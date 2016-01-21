package com.kreditech.pages.google;

import com.kreditech.helpers.SeleniumHelper;
import com.kreditech.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

public class SearchPage extends BasePage {
    @FindBy(name = "q")
    private WebElement searchInputField;

    @FindBy(name = "btnG")
    private WebElement searchSubmitButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return SeleniumHelper.isElementPresentAndVisible(searchInputField);
    }

    @Step("Search in google for {0}")
    public SearchResultsPage searchFor(String searchString) {
        searchInputField.sendKeys(searchString);
        SeleniumHelper.waitForElementToBeClickable(driver, searchSubmitButton);
        searchSubmitButton.click();
        return new SearchResultsPage(driver);
    }
}
