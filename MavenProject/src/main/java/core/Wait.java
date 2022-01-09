package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.Utils.DEFAULT_TIME_TO_WAIT;

public abstract class Wait {

    private static final WebDriver driver = DriverInitiator.instantiateDriver();

    public static void waitUntilElementIsClickable(WebElement element) {
        new WebDriverWait(driver, DEFAULT_TIME_TO_WAIT).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilElementIsDisplayed(WebElement element) {
        new WebDriverWait(driver, DEFAULT_TIME_TO_WAIT).until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsNotDisplayed(WebElement element) {
        new WebDriverWait(driver, DEFAULT_TIME_TO_WAIT).until(ExpectedConditions.invisibilityOf(element));
    }

    public static boolean waitUntilPageIsLoaded(WebDriver webDriver) {
        return waitForJs(webDriver) && waitForJQuery(webDriver);
    }

    private static boolean waitForJs(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Utils.DEFAULT_TIME_TO_WAIT);
        return wait.until((ExpectedCondition<Boolean>) driver -> ((JavascriptExecutor) driver).executeScript(
                "return document.readyState").equals("complete"));
    }

    private static boolean waitForJQuery(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, Utils.DEFAULT_TIME_TO_WAIT);
        return wait.until((ExpectedCondition<Boolean>) driver -> (Long) ((JavascriptExecutor) driver).executeScript(
                "return jQuery.active") == 0);
    }

}
