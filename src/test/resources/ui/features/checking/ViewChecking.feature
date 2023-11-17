@smoke
Feature: View Checking feature

  Scenario: User should be able to view checking cards
    Given User logged in "miaqapro@gmail.com" "Test12345$"
    When User clicks on checking menu button
    And User clicks on view checking
    Then User is on View Checking page
    And User can see checking accounts info
      | accountName             | accountType       | ownership  | accountNumber | interestRate | balance   |
      | Elon Musk Last Checking | Standard Checking | Individual | 486130070     | 0.0%         | 100000.00 |
    And User can see Transaction info
      | date             | category | description               | amount    | balance    |
      | 2023-09-06 17:04 | Income   | 845320070 (DPT) - Deposit | 100000.0 | 100000.0 |
