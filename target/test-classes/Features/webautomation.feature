@AllTestCase
Feature: web automation

  @CaseSelectMenu
  Scenario: select menu
    Given User go to https://demoqa.com/select-menu
    When User in select menu page
    And User choose select value Another root option
    And User choose select one Other
    And User choose old style select menu Aqua
    And User choose multi select drop down all color
    Then User success input all select menu

  @CaseSearchBook
  Scenario: search book
    Given User go to https://demoqa.com/books
    When User in Book Store page
    And User search book qa engineer
    Then User see No rows found

  @CaseVerifyBook
  Scenario: verify book
    Given User go to page books
    When User at Books store page
    And User search book Git Pocket Guide
    And User click book Git Pocket Guide
    Then User see Git Pocket Guide
