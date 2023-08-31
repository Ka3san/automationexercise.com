package com.automationexercise.pages;

import com.automationexercise.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage {
    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmailInputBox;
    @FindBy(id = "subscribe")
    private WebElement subscribeButton;
    @FindBy(css = "a.btn.btn-default.check_out")
    private WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u")
    private WebElement checkoutModalRegisterLoginButton;

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
}
