Feature: Google Search Engine
    
  @Regression @Smoke 
  Scenario: Search in Google for a Specific Data
    Given User  launch google browser
    When User  enters "laptop" in searchbox
    And User  clicks on SearchButton
    Then Search results page Title should contain "Google Search"