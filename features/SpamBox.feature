Feature: actions with SpamBox
  Scenario: Test moving letter to SpamBox
    Given I am on main page mailru
    And I login with correct login and password
    When I select one message
    And click button Spam
    Then this message appears in SpamBox
  Scenario: Test moving letter from SpamBox to Inbox
    Given I am on main page mailru
    And I login with correct login and password
    And I go to SpamBox
    When I select one message
    And click button NotSpam
    Then this message removes from SpamBox