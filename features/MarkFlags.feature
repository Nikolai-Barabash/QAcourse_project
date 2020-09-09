Feature: Mark messages by flags
  Scenario: Test - mark three messages by flags
    Given I am on main page mailru
    And I login with correct login and password
    When I select three messages
    And click button mark with flag
    Then red flags icons are displayed on selected messages
