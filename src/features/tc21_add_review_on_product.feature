Feature: Products Category

  Scenario Outline: Add review on product
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Click on 'Products' button
    And Verify user is navigated to ALL PRODUCTS page successfully
    And Click on View Product button
    And Verify Write Your Review is visible
    Then Enter '<name>', '<email>' and '<review>'
    And Click 'Submit' button
    And Verify success message Thank you for your review.
#    And Quit browser for better performance

    Examples:
      | name   | email             | review       |
      | Albert | al.bert@gmail.com | good shit ;) |

