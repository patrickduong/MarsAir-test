@ui @BasicSearchFlow_UI
Feature:As a MarsAir Sales Director (Mark). I want potential customers to be able to search for flights to MarsSo that they see what trips are available

  Scenario Outline: A Potential customer is able to search for flights to Mars and can see what trips are available - no promotion code
    Given As a customer at Search home page
    When I select departure with "<departureValue>"
    And I select return with "<returnValue>"
    And I click on search button
    Then I can see the search "<result>" return
    Then I click Back link to make a new search

    Examples:
      | departureValue       | returnValue                   | result              |
      | July                 | December (two years from now) | seatAvailableText   |
      | July                 | December (two years from now) | callNowText         |
      | July                 | July (next year)              | noSeatAvailableText |
      | December (next year) | December (two years from now) | noSeatAvailableText |
      | December             | December (two years from now) | noSeatAvailableText |
