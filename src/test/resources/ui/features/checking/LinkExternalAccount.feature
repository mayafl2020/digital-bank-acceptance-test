@ignore
Feature: Link External Account
  This feature is used to link external account

  Scenario: Link External Account
    Given the user logged in as "miaqapro@gmail.com" "Test1234!"
    When the user add open Banking Account with the following data
      | openBankingProviders | username             | password     |
      |                      | "miaqapro@gmail.com" | "Test12345!" |
    Then the user should see successfull message


