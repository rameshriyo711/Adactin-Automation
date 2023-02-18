@SearchHotel
Feature: verifying Adactin hotel Search Hotel page details
@1
  Scenario Outline: Verifying Search Hotel page by entering all fields
    Given User is on adactin hotel page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login succes message "Hello Rameshriyo711!"
    And User should perform Search by entering all fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrensPerRoom>"
    Then User should verify after Search success message "Select Hotel"

    Examples: 
      | userName      | password | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrensPerRoom |
      | Rameshriyo711 | 30IU88   | Sydney   | Hotel Creek | Standard | 1 - One   | 06/01/2023  | 07/01/2023   | 1 - One       | 1 - One          |
@2
  Scenario Outline: Verifying Search Hotel page by entering only mandatory fields
    Given User is on adactin hotel page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login succes message "Hello Rameshriyo711!"
    And User should perform Search by entering only mandatory fields  "<location>","<noOfRooms>","<checkInDate>","<checkOutDate>" and "<adultsPerRoom>"
    Then User should verify after Search success message "Select Hotel"

    Examples: 
      | userName      | password | location | noOfRooms | checkInDate | checkOutDate | adultsPerRoom |
      | Rameshriyo711 | 30IU88   | Sydney   | 1 - One   | 06/01/2023  | 07/01/2023   | 1 - One       |
@3
  Scenario Outline: Verifying Search Hotel page by entering all fields
    Given User is on adactin hotel page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login succes message "Hello Rameshriyo711!"
    And User should perform Search by entering all fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrensPerRoom>"
    Then User should verify after Search error message in Date "Check-In Date shall be before than Check-Out Date" , "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName      | password | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrensPerRoom |
      | Rameshriyo711 | 30IU88   | Paris   | Hotel Creek | Standard | 1 - One   | 06/01/2024  | 07/01/2023   | 1 - One       | 1 - One          |
@4
  Scenario Outline: Verifying Search Hotel page without entering any fields
    Given User is on adactin hotel page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login succes message "Hello Rameshriyo711!"
    And User should perform Search without entering any fields
    Then User should verify after Search error message in Location "Please Select a Location"

    Examples: 
      | userName      | password |
      | Rameshriyo711 | 30IU88   |
