package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends PageObject{

    @FindBy(xpath = "//div[@class = 'nav__right utility-nav--container']//a[@title = 'Store']")
    private WebElement storeLinkHeader;

    @FindBy(xpath = "//div[@id = 'site-logo']/a[@title = 'Pearson logo']")
    private WebElement pearsonLogo;

    @FindBy(xpath = "//div[@class = 'pearson-banner section']//button[@title = 'Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class = 'c-breadcrumb__container']//li[@class = 'active']")
    private WebElement signInBreadcrumb;

    @FindBy(xpath = "//div[@class= 'col-xs-12 no-padding']/child::a/i")
    private WebElement forgotUsernameOrPasswordLink;

    @FindBy(xpath = "//div[@class = 'form-group has-error']/child::input[@id = 'emailID']")
    private WebElement emailAddressInputField;

    @FindBy(xpath = "//div[@class='c-terms-conditions-area']//span[@class = 'c-checkbox__check']")
    private WebElement termsOfUsecheckbox;

    @FindBy(xpath = "//div[@class = 'col-xs-12 col-sm-6 no-padding button-container']/button[@type = 'submit']")
    private WebElement createAccountButton;

    @FindBy(id = "username")
    private WebElement usernameInputField;

    @FindBy(id = "password")
    private WebElement currentPasswordInputField;

    @FindBy(xpath = "//div[@class='checkbox no-margin']//input[@type = 'checkbox']")
    private WebElement checkBoxRememberMe;

    @FindBy(xpath = "//*[@id='pearsonLoginForm']/div[4]/div/div/button")
    private WebElement signInButton;

    @FindBy(xpath = "//button[@class = 'button-ghost--on-dark button--primary hasArrow arrowRight js-cookie-notification-accept']")
    private WebElement closePopUpCookies;

    @FindBy(xpath = "//button[@class='pop-up-close']")
    private WebElement closePopUpOurStores;


    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public boolean isStoreLinkDisplayed() {
        return storeLinkHeader.isDisplayed();
    }

    public void clickOnPearsonLogo() {
        pearsonLogo.click();
    }

    public boolean isSignInBreadcrumbDisplayed() {
        return signInBreadcrumb.isDisplayed();
    }

    public void enterUsername(String username) {
        this.usernameInputField.sendKeys(username);
    }

    public void enterCurrentPassword(String currentPassword) {
        this.currentPasswordInputField.sendKeys(currentPassword);
    }

    public void clickClosePopUp() {
        closePopUpCookies.click();
    }

    public void clickClosePopUpOurStores() {
        closePopUpOurStores.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void checkRememberMeCheckbox() {
        checkBoxRememberMe.click();
    }

}
