package com.automationexercise.pages;

import com.automationexercise.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class CartPage {
    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmailInputBox;
    @FindBy(id = "subscribe")
    private WebElement subscribeButton;
    @FindBy(css = "a.btn.btn-default.check_out")
    private WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u")
    private WebElement checkoutModalRegisterLoginButton;
    @FindBy(id = "product-3")
    private WebElement firstItemDetails;
    @FindBy(id = "product-1")
    private WebElement secondItemDetails;
    @FindBy(id = "product-2")
    private WebElement thirdItemDetails;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void enterEmailAndClickArrowButtonForSubscription(UserData userData) {
        subscribeEmailInputBox.sendKeys(userData.getEmail());
        subscribeButton.click();
    }

    public void clickCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public void clickRegisterLogin() {
        checkoutModalRegisterLoginButton.click();
    }


    public String checkItemsInCart() {
        List<String> checkoutProductDetails = new ArrayList<>();
        checkoutProductDetails.add(firstItemDetails.getText());
        checkoutProductDetails.add(secondItemDetails.getText());
        checkoutProductDetails.add(thirdItemDetails.getText());
        return checkoutProductDetails.toString();

    }
}
