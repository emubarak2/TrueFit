@TrueFit_GoogleVerification
Feature: google verification

  @TestType-Smoke
  Scenario Outline:Enter a search keyword in google search field And verify search page is displayed
    Given user open page using url :<url>
    And click element if exit : <link_text>
    And user enter value :<search_keyword> in field :<search_field>
    And user click on action with id :<id>
    Then verify page elements are present :<elements>
    Then verify page that contains url is displayed :<search_url>

    Examples:
      |url|link_text|search_keyword|search_field|id|elements|search_url|
      |http://www.google.com|googleHomeEnglish|TrueFit.com|googleSearchField|googleSearchAction|googleImageText,googleVideoText|search?source=,=TrueFit.com|

  @TestType-Smoke
  Scenario Outline:Enter an empty search keyword in google search field and verify search page is not displayed
    Given user open page using url :<url>
    And user click on submit for action with id :<id>
    Then verify text not present on page :<elements>
    Then verify page url doesn't contain :<url_text>
    Then close test driver
    Examples:
      |url|id|elements|url_text|
      |http://www.google.com|googleSearchAction|googleVideoText|search?source=,=TureFit.com|


