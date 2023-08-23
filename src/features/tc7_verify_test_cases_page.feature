Feature: Test Cases Page

  Scenario: Verify Test Cases Page
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Click on 'Test Cases' button
    And Verify user is navigated to test cases page successfully
#    And Quit browser for better performance
