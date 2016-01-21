package com.kreditech;

import com.kreditech.helpers.PropertiesLoader;
import com.kreditech.helpers.WebDriverManager;
import com.kreditech.listeners.ExecutionListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(ExecutionListener.class)
public class BaseTest {
    public WebDriver driver;
    private WebDriverManager webDriverManager = new WebDriverManager();
    private PropertiesLoader propertiesLoader = new PropertiesLoader();

    @BeforeMethod
    public void setUp() {
        String browser = propertiesLoader.getStringPropertyValue("browser");
        String baseUrl = propertiesLoader.getStringPropertyValue("baseUrl");
        driver = webDriverManager.getWebDriver(browser);
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        webDriverManager.killDriver();
    }
}
