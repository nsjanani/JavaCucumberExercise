Feature: Search for ‘Cars in London’ in Google and validate Gumtree links in it

  @automated
  Scenario:
    When I open "www.google.co.uk"
    And search for "Cars in London"
    Then get all Gumtree links from search results displayed for "Cars in London"
    And go to all Gumtree links to validate Gumtree title displayed
