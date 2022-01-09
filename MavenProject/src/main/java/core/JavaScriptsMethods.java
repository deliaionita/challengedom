package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class JavaScriptsMethods {

    private static final WebDriver driver = DriverInitiator.instantiateDriver();

    public static void clickElement(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollAndClick(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public String getPseudoElementProperty(WebElement element, String pseudoElementName, String property) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        return executor
                .executeScript(format("return window.getComputedStyle(arguments[0], ':%s').getPropertyValue('%s');",
                                pseudoElementName,
                                property), element).toString().replaceAll("\"", "");
    }
}
