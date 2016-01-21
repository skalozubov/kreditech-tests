package com.kreditech.pages.app;

import com.kreditech.helpers.SeleniumHelper;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseKreditechPage {
    public static final String KREDITECH_URL = "https://www.kreditech.com/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageCorrect() {
        return driver.getCurrentUrl().equals(KREDITECH_URL) &&
                SeleniumHelper.isElementPresentAndVisible(footer);
    }
}
