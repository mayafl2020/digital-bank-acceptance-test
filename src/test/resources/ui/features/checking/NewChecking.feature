Feature: Creating a new checking account

  Scenario: Create an individual checking account
    Given  the user logged in as "miaqapro@gmail.com" "Test1234!"
    When the user creates a new checking account with the following data
      |checkingAccountType|accountOwnership|accountName|initialDepositAccount|
      |Standard Checking  |Individual      |Elon Musk Last Checking| 100000.0|
    Then the user should see the green "Confirmation Successfully created new Standard Checking account named Elon Musk Last Checking"
    And the user should see newly added card
      | accountName               | accountType       | ownership  | accountNumber | interestRate | balance |
      | Elon Musk Last Checking | Standard Checking | Individual | 486131099     | 0.0%         | 100000.00|
    And the user should see the transactions
      | date             | category | description               | amount     | balance     |
      | 2023-09-06 17:04 | Income   | 845321798 (DPT) - Deposit | 100000.00 | 1000000.00 |

