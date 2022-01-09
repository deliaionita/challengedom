Feature: Account for checkout verifications

  Background:
    Given user navigates to testing page

  Scenario: check the page title
    Then user check the page title is correct

  Scenario:  check the content title
    Then user check the page content title

  Scenario: clicks on first button
    And user clicks on first button
    Then user verifies the id

  Scenario: user clicks on second button
    And user clicks on second button
    Then user verifies the second button id

  Scenario: user clicks on third button
    And user clicks on third button
    Then user verifies the third button id

  Scenario: clicks on first edit
    And user clicks on first edit
    Then user verifies current URL after click on edit

  Scenario: user clicks on first delete
    And user click on first delete
    Then user verifies URL after click on delete


  Scenario: click on fork me on git
    And user clicks on fork me on git
    Then user verifies current URL after click on fork me on git

  Scenario: verify table header
    And user navigates to page table
    Then user verify the table header

  Scenario: user check canvas on refresh
    And user read the canvas content
    And user refresh the page
    Then user check canvas value has changed

