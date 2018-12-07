@TrueFit_GoogleVerification
Feature: google verification

  @TestType-Smoke
  Scenario Outline:Enter a search keyword in google search field And verify search page is displayed
    Given user open page using url :<url>
    And user enter value :<search_keyword> in field :<search_field>
    And user click on action with id :<id>
    Then verify page that contains url is displayed :<search_url>

    Examples:
      |url|search_keyword|search_field|id|search_url|
      |http://www.google.com|TrueFit.com|googleSearchField|googleSearchAction|search?source=,=TrueFit.com|

  @TestType-Smoke
  Scenario Outline:Enter an empty search keyword in google search field and verify search page is not displayed
    Given user open page using url :<url>
    And user click on submit for action with id :<id>
    Then verify text not present on page :<elements>
    Then verify page url doesn't contain :<url_text>
    Examples:
      |url|id|elements|url_text|
      |http://www.google.com|googleSearchAction|googleImageText,googleVideoText|search?source=,=TureFit.com|


  @TestType-Smoke
  Scenario Outline:Verify google home page elements
    Given user open page using url :<url>
    Then verify page elements are present :<elements>
#    Then close test driver
    Examples:
      |url|elements|
      |http://www.google.com|googleImage,googleSearchAction,googleSearchField|


