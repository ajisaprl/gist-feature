Feature: Public gist

  Background:
    Given logged in user visit gist homePage

  Scenario: Create a public gist page
    When user click create new gist icon
    Then user is on create or edit gist form page

  Scenario: Create a public gist page
    And user click create new gist icon
    And user is on create or edit gist form page
    When user fill the gist content and click submit
    Then user should see review gist form

  Scenario: Edit existing gist
    And user click create new gist icon
    And user click view your gists
    And user open the last created gist
    When user edit gist content
    Then user should see updated gist on the list
