package StepsDef;

import core.DriverInitiator;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.PageTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PageTestingStepDefs {

    WebDriver driver = DriverInitiator.instantiateDriver();
    PageTesting pageTesting = new PageTesting(driver);
    String testVar = "";
    String basePageUrl = "https://the-internet.herokuapp.com/challenging_dom";
    String gitURL = "https://github.com/saucelabs/the-internet";
    String[] headerArray = {"Lorem", "Ipsum", "Dolor", "Sit", "Amet", "Diceret", "Action"};


    @After
    public void close_driver() {
        driver.close();
    }

    /**
     * Asserts
     * <p>
     * assertEquals - assertNotEquals
     * assertTrue - assertFalse
     * assertThat
     */

    @Given("user navigates to testing page")
    public void user_navigates_to_testing_page() {
        driver.get(basePageUrl);
    }

    //first button
    @And("user clicks on first button")
    public void user_clicks_on_first_button() {
        pageTesting.waitFirstButtonToBeDisplayed();
        testVar = pageTesting.getIdForFirstButton();
        pageTesting.clickOnFirstButton();
    }

    @And("user verifies the id")
    public void user_verifies_the_id() {
        assertNotEquals("The ids are equals!", testVar, pageTesting.getIdForFirstButton());
    }

    //second button
    @And("user clicks on second button")
    public void user_clicks_on_second_button() {
        pageTesting.waitForScondButton();
        testVar = pageTesting.getSecondButtonID();
        pageTesting.clickOnSecondButton();
    }

    @And("user verifies the second button id")
    public void user_check_secondButton_id() {
        assertNotEquals("The IDs are equals", testVar, pageTesting.getSecondButtonID());
    }

    //third button
    @And("user clicks on third button")
    public void user_clicks_on_thirdButton() {
        pageTesting.waitForThirdButton();
        testVar = pageTesting.getThirdButtonID();
        pageTesting.clickOnThirdButton();
    }

    @And("user verifies the third button id")
    public void user_check_thirdButton_ID() {
        assertNotEquals("Third button ids are equal", testVar, pageTesting.getThirdButtonID());
    }

    //edit button
    @And("user clicks on first edit")
    public void user_clicks_on_first_edit() {
        testVar = pageTesting.getHrefFirstEdit();
        pageTesting.clickOnFirstEditButton();
    }

    @And("user verifies current URL after click on edit")
    public void user_gets_current_url_after_edit() {
        String URL = driver.getCurrentUrl();
        assertEquals("The links are not equal", testVar, URL);
    }

    //delete button
    @And("user click on first delete")
    public void user_clicks_on_first_delete() {
        testVar = pageTesting.getHrefFirstDelete();
        pageTesting.clickOnFirstDeleteButton();
    }

    @And("user verifies URL after click on delete")
    public void user_gets_url_after_delete() {
        String URL2 = driver.getCurrentUrl();
        assertEquals("The links are not equal", testVar, URL2);
    }

    //fork me on git
    @And("user clicks on fork me on git")
    public void user_clicks_on_fork_me_on_git() {
        pageTesting.waitForkMeOnGitClickable();
        testVar = driver.getCurrentUrl();
        pageTesting.clickOnForkMeOnGit();

    }

    @And("user verifies current URL after click on fork me on git")
    public void user_gets_current_url_after_fork_to_git() {
        String URL = driver.getCurrentUrl();
        assertEquals("The links are not equal", gitURL, URL);
        assertNotEquals("the links are equal", testVar, URL);
    }

    //table header
    @And("user navigates to page table")
    public void user_scroll_to_table() {
        pageTesting.scrollToTable();
    }

    @And("user verify the table header")
    public void user_verify_table_header() {
        testVar = pageTesting.getTextFirstHeader();
        assertEquals("First header Value is not equal", headerArray[0].toString(), testVar);
        assertEquals("Second header Value is not equal", headerArray[1].toString(), pageTesting.getTextSecondTableHeader().toString());
        assertEquals("Third header Value is not equal", headerArray[2].toString(), pageTesting.getTextThirdTableHeader().toString());
        assertEquals("Four header Value is not equal", headerArray[3].toString(), pageTesting.getTextFourTableHeader().toString());
        assertEquals("Five header Value is not equal", headerArray[4].toString(), pageTesting.getTextFiveTableHeader().toString());
        assertEquals("Six header Value is not equal", headerArray[5].toString(), pageTesting.getTextSixTableHeader().toString());
        assertEquals("Seven header Value is not equal", headerArray[6].toString(), pageTesting.getTextSevenTableHeader().toString());

    }
    // page title

    @And("user check the page title is correct")
    public void check_page_title() {
        testVar = driver.getTitle();
        assertEquals("Page title is not the right one", "The Internet", testVar);
    }

    //page content title

    @And("user check the page content title")
    public void check_page_content_title() {
        testVar = pageTesting.getTextContentTitle();
        assertEquals("Page content title is not the right one", "Challenging DOM", testVar);
    }

    // canvas
    @And("user read the canvas content")
    public void user_read_canvas_number() {
        testVar = pageTesting.getCanvasText();
        System.out.println("Value of canvas is " + testVar);
    }

    @And("user refresh the page")
    public void user_refresh_the_page() {
        driver.navigate().refresh();
        System.out.println("Page was refreshed ");
    }

    @And("user check canvas value has changed")
    public void user_check_canvas_value_changed() {
        assertNotEquals("Canvas values are equal", testVar, pageTesting.getCanvasText());
        System.out.println("Old of canvas is " + testVar);
        System.out.println("New Value of canvas is " + pageTesting.getCanvasText());
    }

    @And("user gets current URL")
    public void user_gets_current_url() {
        String URL = driver.getCurrentUrl();
    }


}
