package com.kreditech.pages.google;

import com.kreditech.pages.BasePage;
import com.kreditech.pages.app.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class SearchResultsPage extends BasePage {
    @FindAll({
            @FindBy(className = "g")
    })
    public List<WebElement> searchResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return !searchResults.isEmpty();
    }

    @Step("Select search result with link to Kreditech")
    public HomePage selectResultWithKreditechSite() {
        WebElement kreditechRsult = driver.findElement(By.linkText("Kreditech - Digital Banking for Everyone"));
        kreditechRsult.click();
        return new HomePage(driver);
    }
}
