@tag
Feature: AlMundo FlightReservation

  @tag1
  Scenario: 
    Select origin and destination for a flight from Rio de Janeiro to Buenos Aires

    Given the user is at AlMundo flight search page
    And the origin "city" is set to "Río de Janeiro, Río de Janeiro, Brasil"
    And the destination "city" is set to "Buenos Aires, Buenos Aires, Argentina"
    And the month/Year for departure is "Junio 2020"
    And the date from is "10"
    And the month/Year for arrival is "Septiembre 2020"
    And the date is set to "20"
    And the adult number is set to "3"
    And the children number is set to "4"
    And the option given for children is "2"
    And the flight class is set to "Business"
    When the user submit search
    Then the flight results page is displayed

  Scenario Outline: 
    Search for any flight with the parameters given

    Given the user is at AlMundo flight search page
    And the origin <typeFrom> is set to <cityFrom>
    And the destination <typeTo> is set to <cityTo>
    And the month/Year for departure is <departure>
    And the date from is <dateFrom>
    And the month/Year for arrival is <arrival>
    And the date is set to <dateTo>
    And the adult number is set to <adults>
    And the children number is set to <children>
    And the option given for children is <option>
    And the flight class is set to <flightClass>
    When the user submit search
    Then the flight results page is displayed

    Examples: 
      | typeFrom  | cityFrom                                                                  | typeTo    | cityTo                                                                              | departure        | dateFrom | arrival           | dateTo | adults | children | option | flightClass |
      | "city"    | "Berlín, Berlín, Alemania"                                                | "city"    | "Buenos Aires, Buenos Aires, Argentina"                                             | "Junio 2020"     | "10"     | "Septiembre 2020" | "25"   | "3"    | "2"      | "1"    | "Business"  |
      | "airport" | "Aeropuerto El Loa, Calama - Chile (CJC)"                                 | "airport" | "Aeropuerto Buenos Aires Ministro Pistarini Ezeiza, Buenos Aires - Argentina (EZE)" | "Agosto 2020"    | "12"     | "Septiembre 2020" | "25"   | "2"    | "1"      | "3"    | "Turista"   |
      | "airport" | "Aeropuerto Internacional Miami, Miami - Estados Unidos de América (MIA)" | "city"    | "Buenos Aires, Buenos Aires, Argentina"                                             | "Diciembre 2020" | "8"      | "Enero 2021"      | "3"    | "4"    | "4"      | "2"    | "Primera"   |
      | "city"    | "Roma, Italia"                                                            | "city"    | "Barcelona, España"                                                                 | "Abril 2020"     | "10"     | "Mayo 2020"       | "22"   | "1"    | "2"      | "3"    | "Business"  |
