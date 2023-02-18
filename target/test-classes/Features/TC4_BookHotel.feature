@BookHotel
Feature: verifying Adactin hotel Book Hotel page details
@1
  Scenario Outline: Verifying Book Hotel page by entering all fields
    Given User is on adactin hotel page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login succes message "Hello Rameshriyo711!"
    And User should perform Search by entering all fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrensPerRoom>"
    Then User should verify after Search success message "Select Hotel"
    And User should Select Hotel  and click Continue
    Then User should verify success message "Book A Hotel"
    And User should perform Book Now by entering all fields "<firstName>","<lastName>" and "<billingAddress>"
      | creditCardNo     | CreditCardType   | expiryMonth | expiryYear | CVVNo |
      | 8282828282828282 | American Express | January     |       2015 |  1234 |
      | 1212121212121212 | VISA             | February    |       2016 |  4321 |
      | 3434343434343434 | Master Card      | March       |       2019 |  4567 |
      | 5656565656565656 | American Express | April       |       2020 |  8798 |
    Then User should verify success message "Booking Confirmation" and save the generated Order Id

    Examples: 
      | userName      | password | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrensPerRoom | firstName | lastName | billingAddress |
      | Rameshriyo711 | 30IU88   | Sydney   | Hotel Creek | Standard | 1 - One   | 06/01/2023  | 07/01/2023   | 1 - One       | 1 - One          | Ramesh    | Riyo     | OMR,chennai    |
@2
  Scenario Outline: Verifying Book Hotel page without enter any fields
    Given User is on adactin hotel page
    When User should perform Login "<userName>","<password>"
    Then User should verify after Login succes message "Hello Rameshriyo711!"
    And User should perform Search by entering all fields "<location>","<hotels>","<roomType>","<noOfRooms>","<checkInDate>","<checkOutDate>","<adultsPerRoom>" and "<childrensPerRoom>"
    Then User should verify after Search success message "Select Hotel"
    And User should Select Hotel  and click Continue
    Then User should verify success message "Book A Hotel"
    And User should perform Book Now without enter any fields
    Then User should verify error message "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName      | password | location | hotels      | roomType | noOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrensPerRoom |
      | Rameshriyo711 | 30IU88   | Sydney   | Hotel Creek | Standard | 1 - One   | 06/01/2023  | 07/01/2023   | 1 - One       | 1 - One          |
