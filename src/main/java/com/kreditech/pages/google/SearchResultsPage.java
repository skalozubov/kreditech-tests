package com.kreditech.pages.google;

import com.kreditech.pages.BasePage;
import com.kreditech.pages.app.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BasePage {
    public static final String KREDITECH_LINK = "https://www.kreditech.com/";
    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public HomePage selectResultWithKreditechSite() {
        WebElement kreditechRsult = driver.findElement(By.linkText("Kreditech - Digital Banking for Everyone"));
        kreditechRsult.click();
        return new HomePage(driver);
    }
}
