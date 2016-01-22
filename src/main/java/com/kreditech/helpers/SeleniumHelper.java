package com.kreditech.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumHelper {
    public static Boolean isElementDisplayed(WebDriver driver, WebElement webElement) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        try {
            return webElement.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public static void waitForAjax(WebDriver driver, int timeout) throws InterruptedException {
        sleepForOneSecond();
        for (int i = 0; i < timeout; i++) {
            if (isAjaxCompleted(driver)) {
                break;
            } else {
                sleepForOneSecond();
            }
        }
    }

    public static void waitForPageToLoad(WebDriver driver, int timeout) {
        for (int i = 0; i < timeout; i++) {
            if (isDocumentReadyStateComplete(driver)) {
                break;
            } else {
                sleepForOneSecond();
            }
        }
    }

    private static boolean isAjaxCompleted(WebDriver driver) {
        return Boolean.parseBoolean(executeJavascript("return jQuery.active == 0", driver));
    }

    private static boolean isDocumentReadyStateComplete(WebDriver driver) {
        return Boolean.parseBoolean(executeJavascript("return document.readyState == \"complete\"", driver));
    }

    public static String executeJavascript(String javascript, WebDriver driver) throws RuntimeException {
        Object executionResult = null;
        for (int tryCount = 0; tryCount < 3; tryCount++) {
            try {
                executionResult = ((JavascriptExecutor) driver).executeScript(javascript);
                break;
            } catch (WebDriverException e) {
                if (tryCount == 2) {
                    throw new RuntimeException("Failed to execute: \n" + javascript);
                }
            }
        }
        return executionResult == null ? null : executionResult.toString();
    }

    public static void waitUntilUrlContains(final String urlPart, WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {
                String currentUrl = driver.getCurrentUrl();
                return currentUrl != null && currentUrl.contains(urlPart);
            }
        });
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static boolean isElementPresentAndVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        } catch (StaleElementReferenceException e) {
            return false;
        }
    }

    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void switchContext(WebDriver driver, String initContext) {
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(initContext)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }

    public static void switchToDefaultContext(WebDriver driver) {
        sleepFor(5000);
        Set<String> windowHandles = driver.getWindowHandles();
        if (windowHandles.size() == 1) {
            driver.switchTo().window(windowHandles.iterator().next());
        } else {
            driver.close();
            throw new IllegalStateException("Some why popup was not closed");
        }
    }

    public static void sleepFor(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepForOneSecond() {
        sleepFor(1000);
    }
}
