package com.kreditech.pages.app;

import com.kreditech.pages.BasePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSocialSectionPresent() {
        return false;
    }
}
