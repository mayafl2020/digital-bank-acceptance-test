Feature: Creating a new savings account


  Scenario: Create an individual savings account

    Given the user logged in as "miaqapro@gmail.com" "Test1234!"
    When the user creates a new savings account with the following data
      | selectSavingsAccountType | selectAccountOwnership | accountName                     | initialDeposit |
      | Savings                  | Individual             | Elon Musk first Savings Account | 100000.00      |
    Then user should see a successful message "Successfully created new Savings account named Elon Musk first Savings Account"

