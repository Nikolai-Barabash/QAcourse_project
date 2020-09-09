Feature: Sending message to group
  Scenario: Test sending email to group from Inbox
    Given I am on main page mailru
    And I login with correct login and password
    When I click the button create new message
    And Send it to emails from DB with subject "test" and text "bla-bla-bla"
    Then Confirmation phrase "Отправлено" is displayed