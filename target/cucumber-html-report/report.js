$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("search.feature");
formatter.feature({
  "line": 1,
  "name": "Search for ‘Cars in London’ in Google and validate Gumtree links in it",
  "description": "",
  "id": "search-for-‘cars-in-london’-in-google-and-validate-gumtree-links-in-it",
  "keyword": "Feature"
});
formatter.before({
  "duration": 5427317700,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "",
  "description": "",
  "id": "search-for-‘cars-in-london’-in-google-and-validate-gumtree-links-in-it;",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@automated"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I open \"www.google.co.uk\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "search for \"Cars in London\"",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "get all Gumtree links from search results displayed for \"Cars in London\"",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "go to all Gumtree links to validate Gumtree title displayed",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "www.google.co.uk",
      "offset": 8
    }
  ],
  "location": "SearchStepDefs.iOpenA(String)"
});
formatter.write("Opened www.google.co.uk");
formatter.result({
  "duration": 1247522100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Cars in London",
      "offset": 12
    }
  ],
  "location": "SearchStepDefs.searchFor(String)"
});
formatter.write("Searched for Cars in London");
formatter.result({
  "duration": 1873575000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Cars in London",
      "offset": 57
    }
  ],
  "location": "SearchStepDefs.getAllGumtreeLinksFromSearchResultsDisplayedFor(String)"
});
formatter.write("Got 2 Gumtree links in search results");
formatter.result({
  "duration": 626887600,
  "status": "passed"
});
formatter.match({
  "location": "SearchStepDefs.goToAllGumtreeLinksToValidateGumtreeTitleDisplayed()"
});
formatter.write("Validated Gumtree Title in all the result links available");
formatter.result({
  "duration": 8660972900,
  "status": "passed"
});
formatter.write("Finished scenario ");
formatter.after({
  "duration": 1434812600,
  "status": "passed"
});
});