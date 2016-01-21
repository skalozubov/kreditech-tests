package com.kreditech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Step;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        verifyPage();
    }

    @Step("Check that page is correct")
    private void verifyPage() {
        if (!isPageCorrect()) {
            throw new IllegalStateException(this.toString() +
                    " was not verified. Current URL is: " + driver.getCurrentUrl());
        }
    }

    public abstract boolean isPageCorrect();

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
