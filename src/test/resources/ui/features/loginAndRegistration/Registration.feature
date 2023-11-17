@Registration
  @regression
Feature: Digital Bank Registration Page

  Background:
    Given The user with "miaqapro1@gmail.com" is not in DB
    And User navigates to Digital Bank signup page

  Scenario: Positive Case, As a user i want to successfully create Digital Bank Account

    When the user creates a new account with the following data
      | title | firstName | lastName | gender | dateOfBirth | ssn         | email              | password   | confirmPassword | address | locality   | region | postalCode | country | homePhone | mobilePhone | workPhone |
      | Mrs.  | Maya      | F        | F      | 06/28/1971  | 323-44-3336 | miaqapro1@gmail.com | Test12345$ | Test12345$      | 1324    | Cape Coral | Lee    | 33909      | USA     | 55555     | 33333       | 11111     |

    Then the user should see the message  "Success Registration Successful. Please Login"
    Then the following user info should be saved in the db
      | title | firstName | lastName | gender | dateOfBirth | ssn         | email              | password   | confirmPassword | address | locality   | region | postalCode | country | homePhone | mobilePhone | workPhone |
      | Mrs.  | Maya      | F        | F      | 06/28/1971  | 323-44-3336 | miaqapro1@gmail.com | Test12345$ | Test12345$      | 1324    | Cape Coral | Lee    | 33909      | USA     | 55555     | 33333       | 11111     |

  Scenario Outline: Negative Test Case.As a Digital Bank Admin i want to make sure users cannot register without providing all valid data
    Given User navigates to Digital Bank signup page
    When the user creates a new account with the following data
      | title   | firstName   | lastName   | gender   | dateOfBirth   | ssn   | email   | password   | confirmPassword   | address   | locality   | postalCode   | region   | country   | homePhone   | mobilePhone   | workPhone   | fieldWithError   | errorMessage   |
      | <title> | <firstName> | <lastName> | <gender> | <dateOfBirth> | <ssn> | <email> | <password> | <confirmPassword> | <address> | <locality> | <postalCode> | <region> | <country> | <homePhone> | <mobilePhone> | <workPhone> | <fieldWithError> | <errorMessage> |

    Then the user should see the following "<fieldWithError>" required field error message "<errorMessage>"
    And the user clicked on the submit button
    Examples:
      | title | firstName | lastName | gender | dateOfBirth | ssn    | email  | password  | confirmPassword | address | locality | region | postalCode | country | homePhone | mobilePhone | workPhone | fieldWithError  | errorMessage                        |
      |       |           |          |        |             |        |        |           |                 |         |          |        |            |         |           |             |           | title           | Please select an item in the list.  |
      | Mr.   |           |          |        |             |        |        |           |                 |         |          |        |            |         |           |             |           | firstName       | Please fill out this field.         |
      | Mr.   | Bill      |          |        |             |        |        |           |                 |         |          |        |            |         |           |             |           | lastName        | Please fill out this field.         |
      | Mr.   | Bill      | Gates    |        |             |        |        |           |                 |         |          |        |            |         |           |             |           | gender          | Please select one of these options. |
      | Mr.   | Bill      | Gates    | M      |             |        |        |           |                 |         |          |        |            |         |           |             |           | dateOfBirth     | Please fill out this field.         |
      | Mr.   | Bill      | Gates    | M      | 02/07/1956  |        |        |           |                 |         |          |        |            |         |           |             |           | ssn             | Please fill out this field.         |
      | Mr.   | Bill      | Gates    | M      | 02/07/1956  | random |        |           |                 |         |          |        |            |         |           |             |           | email           | Please fill out this field.         |
      | Mr.   | Bill      | Gates    | M      | 02/07/1956  | random | random |           |                 |         |          |        |            |         |           |             |           | password        | Please fill out this field.         |
      | Mr.   | Bill      | Gates    | M      | 02/07/1956  | random | random | Test1234! | Test1234!       |         |          |        |            |         |           |             |           | confirmPassword |                                     |


