# Author

@SmokeScenario
Feature: feature to test functionality

  @Scenario1
  Scenario: Check login is successful with valid credential
    Given user is on login page
    When user enters username and password
    And clicks on login button
    Then user is navigated to the home page

  @Scenario2
  Scenario: Check login is unsuccessful with invalid credential
    Given user is on login page
    When user enters invalid username and password
    And clicks on login button
    Then user is display error username and password
    
    @Scenario3
  Scenario: Check login is unsuccessful without input any field
    Given user is on login page
    And clicks on login button
    Then user is display error username required
    
     @Scenario4
  Scenario: Check login is unsuccessful without input password field
    Given user is on login page
    When user enters valid username
    And clicks on login button
    Then user is display error password required