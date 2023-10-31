@ignore
Feature: Deposit

  Scenario: User makes a deposit to an account
    Given  the user logged in as "miaqapro@gmail.com" "Test1234!"
    And the following bank accounts with their respective balances
      | accountName                                          | balance  |
      | Elon Musk second checking account (Standard Checking) | 100000.00 |

    When the user deposits deposit amount to an account
      | accountName                                          | depositAmount |
      | Elon Musk second checking account (Standard Checking) | 200000.00      |

    And the user clicks on the submit button
    Then the user will see the new account balance
      | accountName                                          | newBalance |
      | Elon Musk second checking account (Standard Checking) | 300000.00   |

