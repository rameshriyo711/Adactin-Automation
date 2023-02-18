@SelectHotel
Feature: verifying Adactin hotel Select Hotel page details

  Scenario Outline: Verifying Select Hotel page by entering all fields
    Given User is on adactin hotel page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login succes message "Hello Rameshriyo711!"
    And User should perform Search by entering all fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrensPerRoom>"
    Then User should verify after Search success message "Select Hotel"
    And User should Select Hotel  and click Continue
    Then User should verify success message "Book A Hotel"

    Examples: 
      | userName      | password | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrensPerRoom |
      | Rameshriyo711 | 30IU88   | Sydney   | Hotel Creek | Standard | 1 - One   | 06/01/2023 | 07/01/2023  | 1 - One       | 1 - One          |

  Scenario Outline: Verifying Select Hotel page without select Hotel
    Given User is on adactin hotel page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login succes message "Hello Rameshriyo711!"
    And User should perform Search by entering all fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrensPerRoom>"
    Then User should verify after Search success message "Select Hotel"
    And User should click Continue without Select Hotel
    Then User should verify  error message "Please Select a Hotel"

    Examples: 
      | userName      | password | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrensPerRoom |
      | Rameshriyo711 | 30IU88   | Sydney   | Hotel Creek | Standard | 1 - One   | 06/01/2023  | 07/01/2023   | 1 - One       | 1 - One          |
