package com.kreditech.pages.google;

import com.kreditech.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    @FindBy(name = "q")
    private WebElement searchInputField;

    @FindBy(name = "btnG")
    private WebElement searchSubmitButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }


    public SearchResultsPage searchFor(String searchString) {
        searchInputField.sendKeys(searchString);
        searchSubmitButton.click();
        return new SearchResultsPage(driver);
    }
}
