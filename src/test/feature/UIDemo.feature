Feature: This is a UIDemo feature
  Scenario Outline: Verify Book Motor homes return expected search results
    Given user is on Google Home Page
    When user searches for "<brand>"
    Then user goes to "<brand>" rental home page
    When user provides "<destination>"
    And user provides book details "<pickUpDate>", "<dropOffDate>", "<pickUpLocation>", "<dropOffLocation>", "<passengers>" and "<driverLicence>"
    And user clicks on SEARCH button
    Then there should be "<searchResult>" results returned
    Examples:
    |brand|destination|pickUpDate|dropOffDate|pickUpLocation|dropOffLocation|passengers|driverLicence|searchResult|
    |maui|New Zealand|30-April-2022|08-May-2022|Auckland   |Auckland       |A2-C2      |New Zealand|2 Results|
    |britz|New Zealand|30-April-2022|08-May-2022|Auckland   |Auckland       |A2-C2      |New Zealand|4 Results|

