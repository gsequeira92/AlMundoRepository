@tag
Feature: AlMundo HotelReservation

  @tag1
  Scenario: AlMundo HotelReservation

  @tag2
  Scenario: Search for any accommodation in Berlín
    Given the user is at AlMundo home page
    And the user clicks on "Accomodation" icon
    And the location "city" is set to "Berlín, Berlín, Alemania"
    And the month and year for arrival is "Junio 2020"
    And the date for arrival is "10"
    And the month and for departure is "Septiembre 2020"
    And the date for departure is"20"
    And the room number is set to "1"
    And the adult number will be "3"
    And the children number will be "4"
    And the age option for children is "2"
    When the user finish search
    Then the hotel results page is displayed
