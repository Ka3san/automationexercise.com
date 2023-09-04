package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CheckoutPage {
    @FindBy(id = "address_delivery")
    private WebElement addressDeliveryBox;
    @FindBy(id = "product-3")
    private WebElement firstItemDetails;
    @FindBy(id = "product-1")
    private WebElement secondItemDetails;
    @FindBy(id = "product-2")
    private WebElement thirdItemDetails;


    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String checkDeliveryAddress() {
        return addressDeliveryBox.getText();
    }

    public String reviewOrder() {
        List<String> checkoutProductDetails = new ArrayList<>();
        checkoutProductDetails.add(firstItemDetails.getText());
        checkoutProductDetails.add(secondItemDetails.getText());
        checkoutProductDetails.add(thirdItemDetails.getText());
        return checkoutProductDetails.toString();

    }


}
