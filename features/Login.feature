Feature: Login
  Scenario: Test mail.ru positive login
    Given  I am on main page mailru
    When I login with correct login and password
    Then user name is visible

    Scenario: Test mail.ru negative login
      Given  I am on main page mailru
      When I login with correct login and incorrect password
      Then errorMessage "Неверное имя или пароль" is visible