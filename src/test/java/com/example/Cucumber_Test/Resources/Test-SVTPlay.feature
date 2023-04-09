Feature: SVT Play Test
  Scenario: SVT Play should show correct title
    Given SVT Play is available
    When User visits SVT Play
    Then Title should be "SVT Play"

  Scenario: SVT Play should show Correct Logo
    Given SVT Play is available
    When User visits SVT Play
    Then Logo should be visible

  Scenario: SVT Play should show the correct menu names
    Given SVT Play is available
    When User visits SVT Play
    Then The link names in the main menu should be "Start, Program, Kanaler"

  Scenario: Tillgänglighet i SVT Play should show the correct link text
    Given SVT Play is available
    When User visits SVT Play
    Then link text for Tillgänglighet i SVT Play should show the correct link text

  Scenario: The count of total no of programs should be same
    Given SVT Play is available
    When User visits SVT Play
    And  User clicks on Program link
    Then Count the total number of programs

  Scenario: URL has to update for related date selection
    Given SVT Play is available
    When User visits SVT Play
    And User  click on Kanaler link
    And User select particular date
    Then URL has to update with selected date

  Scenario: Count of categories should be same
    Given SVT Play is available
    When User visits SVT Play
    And User  click on Kanaler link
    Then Count the total number of categories

  Scenario: Heading for Tillgänglighet i SVT Play should be related
    Given SVT Play is available
    When User visits SVT Play
    And User clicks on Tillgänglighet i SVT Play link
    Then the heading should be "Så arbetar SVT med tillgänglighet"

  Scenario: Find the heading
    Given SVT Play is available
    When User visits SVT Play
    And User clicks on Tillgänglighet i SVT Play link
    And user clicks on om oss
    Then Om Oss Heading should be match
