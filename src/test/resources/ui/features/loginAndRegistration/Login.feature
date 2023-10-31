@ignore
Feature: Login feature
  This feature is used to test login functionality
// hi
  @positive
  Scenario: Valid username Valid password test

#    Given i'm on login page
    When I enter "miaqapro@gmail.com" and "Test12345$ "
    Then i should get login success message

  @negative
  Scenario Outline: Invalid username Invalid password

#    Given i'm on login page
    When i enter "<username>" and "<password>"
    Then i should get login failure message
    Examples:
      | username               | password         |
      |                        |                  |
      | miaqapro@gmail.com     | invalid password |
      | invalidemail@gmail.com | Test12345!       |
      | invalidemail@gmail.com | invalidPassword  |
      | miaqapro@gmail.com     |                  |
      |                        | Test12345!       |
      | #$%%^^^&&              | !#$%%^%^         |
      |a                       |a                 |

