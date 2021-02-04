$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/sample.feature");
formatter.feature({
  "name": "Google Search Engine",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search in Google for a Specific Data",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Regression"
    },
    {
      "name": "@Smoke"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User  launch google browser",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.sampleSteps.user_launch_google_browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User  enters \"laptop\" in searchbox",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.sampleSteps.user_enters_in_searchbox(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User  clicks on SearchButton",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.sampleSteps.user_clicks_on_search_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Search results page Title should contain \"Google Search\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.sampleSteps.search_results_page_title_should_contain(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});