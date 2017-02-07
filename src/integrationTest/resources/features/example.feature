@smokeTest
Feature: Navigate to Greeting


  Scenario: Navigate to Greeting
    Given we have connection details
    When navigate to the greeting page
    Then the greeting is displayed