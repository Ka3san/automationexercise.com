Feature: Contact Us Form fill

  Scenario Outline: Contact Us Form successfully filled
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Verify that home page is visible successfully
    And Click on 'Contact Us' button
    And Verify 'GET IN TOUCH' is visible
    And Enter '<name>', '<email>', '<subject>' and '<message>'
    And Upload file
    And Click 'Submit' button
#    And Click OK button
#    Then Verify success message 'Success! Your details have been submitted successfully.' is visible
#    And Click 'Home' button and verify that landed to home page successfully

    Examples:
      | name | email      | subject | message      |
      | Adam | ada@mam.io | new     | test message |