@Login
Feature: verify Adactin Hotel login details

  @1
  Scenario Outline: verifying adactin hotel Login with valid data
    Given User is on adactin hotel page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login succes message "Hello Rameshriyo711!"

    Examples: 
      | userName      | password |
      | Rameshriyo711 | 30IU88   |

  @2
  Scenario Outline: verifying adactin hotel Login with valid data using enter
    Given User is on adactin hotel page
    When User should perform Login "<userName>","<password>" with enter key
    Then User should verify after Login succes message "Hello Rameshriyo711!"

    Examples: 
      | userName      | password |
      | Rameshriyo711 | 30IU88   |

  @3
  Scenario Outline: verifying adactin hotel Login with Invalid credential
    Given User is on adactin hotel page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login error message it contains "Invalid Login details or Your Password might have expired."

    Examples: 
      | userName      | password  |
      | Rameshriyo711 | uvcybrycv |
