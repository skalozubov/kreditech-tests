package com.kreditech;

import com.kreditech.helpers.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    private WebDriverManager webDriverManager = new WebDriverManager();

    @BeforeMethod
    public void setUp() {
        driver = webDriverManager.getWebDriver("FIREFOX");
        driver.get("https://www.google.com.ua/");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        webDriverManager.killDriver();
    }
}
