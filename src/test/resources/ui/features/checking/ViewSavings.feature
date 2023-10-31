Feature: View Savings feature

  Scenario: User should be able to view Savings
    Given the user logged in as "miaqapro@gmail.com" "Test1234!"
    When the user clicks on the savings menu button
    And the user clicks on savings view button
    Then the user is on the view savings page
    Then the user should see saving account cards with the following info
      | accountName               | accountType       | ownership  | accountNumber | interestRate | balance |
      | Elon Musk Last Checking | Saving Checking | Individual | 486131099     | 0.0%         | 100000.00|
    Then the user should see the following transactions
      | date             | category | description               | amount     | balance     |
      | 2023-09-06 17:04 | Income   | 84321798 (DPT) - Deposit | 100000.00 | 1000000.00 |