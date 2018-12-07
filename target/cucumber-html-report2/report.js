$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feature/web/TrueFit_GoogleVerification.feature");
formatter.feature({
  "line": 2,
  "name": "google verification",
  "description": "",
  "id": "google-verification",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@TrueFit_GoogleVerification"
    }
  ]
});
formatter.scenarioOutline({
  "line": 5,
  "name": "Enter a search keyword in google search field And verify search page is displayed",
  "description": "",
  "id": "google-verification;enter-a-search-keyword-in-google-search-field-and-verify-search-page-is-displayed",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 4,
      "name": "@TestType-Smoke"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user open page using url :\u003curl\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user enter value :\u003csearch_keyword\u003e in field :\u003csearch_field\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user click on action with id :\u003cid\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "verify page that contains url is displayed :\u003csearch_url\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "google-verification;enter-a-search-keyword-in-google-search-field-and-verify-search-page-is-displayed;",
  "rows": [
    {
      "cells": [
        "url",
        "search_keyword",
        "search_field",
        "id",
        "search_url"
      ],
      "line": 12,
      "id": "google-verification;enter-a-search-keyword-in-google-search-field-and-verify-search-page-is-displayed;;1"
    },
    {
      "cells": [
        "http://www.google.com",
        "TrueFit.com",
        "googleSearchField",
        "googleSearchAction",
        "search?source\u003d,\u003dTrueFit.com"
      ],
      "line": 13,
      "id": "google-verification;enter-a-search-keyword-in-google-search-field-and-verify-search-page-is-displayed;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 13,
  "name": "Enter a search keyword in google search field And verify search page is displayed",
  "description": "",
  "id": "google-verification;enter-a-search-keyword-in-google-search-field-and-verify-search-page-is-displayed;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@TrueFit_GoogleVerification"
    },
    {
      "line": 4,
      "name": "@TestType-Smoke"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "user open page using url :http://www.google.com",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "user enter value :TrueFit.com in field :googleSearchField",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "user click on action with id :googleSearchAction",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "verify page that contains url is displayed :search?source\u003d,\u003dTrueFit.com",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.google.com",
      "offset": 26
    }
  ],
  "location": "GenericStepDefs.openPage(String)"
});
formatter.result({
  "duration": 7386822523,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "TrueFit.com",
      "offset": 18
    },
    {
      "val": "googleSearchField",
      "offset": 40
    }
  ],
  "location": "GenericStepDefs.setValue(String,String)"
});
formatter.result({
  "duration": 218900424,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "googleSearchAction",
      "offset": 30
    }
  ],
  "location": "GenericStepDefs.clickAction(String)"
});
formatter.result({
  "duration": 1897697168,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "search?source\u003d,\u003dTrueFit.com",
      "offset": 44
    }
  ],
  "location": "GenericStepDefs.verifyPageIsDisplayed(String)"
});
formatter.result({
  "duration": 9561678,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 16,
  "name": "Enter an empty search keyword in google search field and verify search page is not displayed",
  "description": "",
  "id": "google-verification;enter-an-empty-search-keyword-in-google-search-field-and-verify-search-page-is-not-displayed",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 15,
      "name": "@TestType-Smoke"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "user open page using url :\u003curl\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "user click on submit for action with id :\u003cid\u003e",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "verify text not present on page :\u003celements\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "verify page url doesn\u0027t contain :\u003curl_text\u003e",
  "keyword": "Then "
});
formatter.examples({
  "line": 21,
  "name": "",
  "description": "",
  "id": "google-verification;enter-an-empty-search-keyword-in-google-search-field-and-verify-search-page-is-not-displayed;",
  "rows": [
    {
      "cells": [
        "url",
        "id",
        "elements",
        "url_text"
      ],
      "line": 22,
      "id": "google-verification;enter-an-empty-search-keyword-in-google-search-field-and-verify-search-page-is-not-displayed;;1"
    },
    {
      "cells": [
        "http://www.google.com",
        "googleSearchAction",
        "googleImageText,googleVideoText",
        "search?source\u003d,\u003dTureFit.com"
      ],
      "line": 23,
      "id": "google-verification;enter-an-empty-search-keyword-in-google-search-field-and-verify-search-page-is-not-displayed;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 23,
  "name": "Enter an empty search keyword in google search field and verify search page is not displayed",
  "description": "",
  "id": "google-verification;enter-an-empty-search-keyword-in-google-search-field-and-verify-search-page-is-not-displayed;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@TrueFit_GoogleVerification"
    },
    {
      "line": 15,
      "name": "@TestType-Smoke"
    }
  ]
});
formatter.step({
  "line": 17,
  "name": "user open page using url :http://www.google.com",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 18,
  "name": "user click on submit for action with id :googleSearchAction",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "verify text not present on page :googleImageText,googleVideoText",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "verify page url doesn\u0027t contain :search?source\u003d,\u003dTureFit.com",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.google.com",
      "offset": 26
    }
  ],
  "location": "GenericStepDefs.openPage(String)"
});
formatter.result({
  "duration": 559935884,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "googleSearchAction",
      "offset": 41
    }
  ],
  "location": "GenericStepDefs.clickActionSubmit(String)"
});
formatter.result({
  "duration": 28280188,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "googleImageText,googleVideoText",
      "offset": 33
    }
  ],
  "location": "GenericStepDefs.verifyPageElementsAreNotPresent(String)"
});
formatter.result({
  "duration": 16299605,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "search?source\u003d,\u003dTureFit.com",
      "offset": 33
    }
  ],
  "location": "GenericStepDefs.verifyPageUrlDoesntContain(String)"
});
formatter.result({
  "duration": 6507139,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 27,
  "name": "Verify google home page elements",
  "description": "",
  "id": "google-verification;verify-google-home-page-elements",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 26,
      "name": "@TestType-Smoke"
    }
  ]
});
formatter.step({
  "line": 28,
  "name": "user open page using url :\u003curl\u003e",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "verify page elements are present :\u003celements\u003e",
  "keyword": "Then "
});
formatter.examples({
  "comments": [
    {
      "line": 30,
      "value": "#    Then close test driver"
    }
  ],
  "line": 31,
  "name": "",
  "description": "",
  "id": "google-verification;verify-google-home-page-elements;",
  "rows": [
    {
      "cells": [
        "url",
        "elements"
      ],
      "line": 32,
      "id": "google-verification;verify-google-home-page-elements;;1"
    },
    {
      "cells": [
        "http://www.google.com",
        "googleImage,googleSearchAction,googleSearchField"
      ],
      "line": 33,
      "id": "google-verification;verify-google-home-page-elements;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 33,
  "name": "Verify google home page elements",
  "description": "",
  "id": "google-verification;verify-google-home-page-elements;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 1,
      "name": "@TrueFit_GoogleVerification"
    },
    {
      "line": 26,
      "name": "@TestType-Smoke"
    }
  ]
});
formatter.step({
  "line": 28,
  "name": "user open page using url :http://www.google.com",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "verify page elements are present :googleImage,googleSearchAction,googleSearchField",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://www.google.com",
      "offset": 26
    }
  ],
  "location": "GenericStepDefs.openPage(String)"
});
formatter.result({
  "duration": 586117167,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "googleImage,googleSearchAction,googleSearchField",
      "offset": 34
    }
  ],
  "location": "GenericStepDefs.verifyPageElement(String)"
});
formatter.result({
  "duration": 55654680,
  "status": "passed"
});
});