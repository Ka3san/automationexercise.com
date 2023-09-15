Feature: Products Category

  Scenario Outline: View & Cart Brand Products
    Given Launch browser
    And Navigate to url http://automationexercise.com
    When Click on 'Products' button
    And Verify that Brands are visible on left side bar
    And Click on '<brand name>'
    And Verify that user is navigated to '<brand name>' page and brand products are displayed
    Then On left side bar, click on any other '<brand name>' link
    And Verify that user is navigated to that brand page and can see products
#    And Quit browser for better performance

    Examples:
      | brand name |
      | Babyhug    |

#    type brand name: "Biba", "Kookie Kids", "Allen Solly Junior", "Babyhug", "Mast & Harbour", "Madame", "H&M" or "Polo"