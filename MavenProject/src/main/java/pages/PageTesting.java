package pages;

import core.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static core.JavaScriptsMethods.clickElement;
import static core.JavaScriptsMethods.scrollToElement;
import static core.Wait.waitUntilElementIsClickable;
import static core.Wait.waitUntilElementIsDisplayed;

public class PageTesting extends PageObject {

    @FindBy(xpath = "//h3")
    private WebElement contentTitle;

    @FindBy(xpath = "//a[@class='button']")
    private WebElement firstButton;

    @FindBy(xpath = "//a[@class='button alert']")
    private WebElement secondButton;

    @FindBy(xpath = "//a[@class='button success']")
    private WebElement thirdButton;

    @FindBy(xpath = "//tbody/tr[1]")
    private WebElement firstRow;

    @FindBy(xpath = "//a/img[@alt = 'Fork me on GitHub']")
    private WebElement forkMeOnGit;

    @FindBy(xpath = "//thead/tr/th[1]")
    private WebElement tableHeaderFirst;

    @FindBy(xpath = "//thead/tr/th[2]")
    private WebElement tableHeaderSecond;

    @FindBy(xpath = "//thead/tr/th[3]")
    private WebElement tableHeaderThird;

    @FindBy(xpath = "//thead/tr/th[4]")
    private WebElement tableHeaderFour;

    @FindBy(xpath = "//thead/tr/th[5]")
    private WebElement tableHeaderFive;

    @FindBy(xpath = "//thead/tr/th[6]")
    private WebElement tableHeaderSix;

    @FindBy(xpath = "//thead/tr/th[7]")
    private WebElement tableHeaderSeven;

    @FindBy(xpath = "//div[@id='content']/script")
    private WebElement canvasScript;

    //canvas
    public String getCanvasText(){
       String allText = canvasScript.getAttribute("innerHTML");
        String canvasNumber = allText.substring(allText.indexOf("Answer:") +8, allText.lastIndexOf('\''));

       return canvasNumber;

    }

    //page h3 title text
    public String getTextContentTitle(){
        return contentTitle.getText();
    }
    // table header
    public void scrollToTable(){
        scrollToElement(tableHeaderFirst);
    }
    public String getTextFirstHeader() {
        return tableHeaderFirst.getText();
    }
    public String getTextSecondTableHeader() {
        return tableHeaderSecond.getText();
    }
    public String getTextThirdTableHeader() {
        return tableHeaderThird.getText();
    }
    public String getTextFourTableHeader() {
        return tableHeaderFour.getText();
    }
    public String getTextFiveTableHeader() {
        return tableHeaderFive.getText();
    }
    public String getTextSixTableHeader() {
        return tableHeaderSix.getText();
    }
    public String getTextSevenTableHeader() {
        return tableHeaderSeven.getText();
    }

    //third button methods
    public void clickOnThirdButton() {
        thirdButton.click();
    }

    public String getThirdButtonID() {
        return thirdButton.getAttribute("id");
    }

    public void waitForThirdButton() {
        waitUntilElementIsDisplayed(thirdButton);
    }

    // second button from page - red one
    public void clickOnSecondButton() {
        secondButton.click();
    }

    public String getSecondButtonID() {
        return secondButton.getAttribute("id");
    }

    public void waitForScondButton() {
        waitUntilElementIsDisplayed(secondButton);
    }

    //fork me on git
    public void waitForkMeOnGitClickable() {
        waitUntilElementIsClickable(forkMeOnGit);
    }

    public void clickOnForkMeOnGit() {
        clickElement(forkMeOnGit);
    }

    //edit button from first row
    public WebElement getFirstRowEditButton() {
        return firstRow.findElement(By.xpath(".//a[@href = '#edit']"));
    }

    public void clickOnFirstEditButton() {
        getFirstRowEditButton().click();
    }

    public String getHrefFirstEdit() {
        return getFirstRowEditButton().getAttribute("href");
    }

    //delete button from first row
    public WebElement getFirstRowDeleteButton() {
        return firstRow.findElement(By.xpath(".//a[@href = '#delete']"));
    }

    public void clickOnFirstDeleteButton() {
        getFirstRowDeleteButton().click();
    }

    public String getHrefFirstDelete() {
        return getFirstRowDeleteButton().getAttribute("href");
    }

    //first button
    public void clickOnFirstButton() {
        firstButton.click();
    }

    public String getIdForFirstButton() {
        return firstButton.getAttribute("id");
    }

    public void waitFirstButtonToBeDisplayed() {
        waitUntilElementIsDisplayed(firstButton);
    }


    public PageTesting(WebDriver webDriver) {
        super(webDriver);
    }
}
