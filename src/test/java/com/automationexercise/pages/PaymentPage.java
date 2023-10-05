package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    @FindBy(css = "input.form-control")
    private WebElement nameOnCardInputBox;
    @FindBy(css = "#payment-form > div:nth-child(3) > div > input")
    private WebElement cardNumberInputBox;
    @FindBy(css = "#payment-form > div:nth-child(4) > div.col-sm-4.form-group.cvc > input")
    private WebElement cvcInputBox;
    @FindBy(css = "#payment-form > div:nth-child(4) > div:nth-child(2) > input")
    private WebElement monthExpirationInputBox;
    @FindBy(css = "#payment-form > div:nth-child(4) > div:nth-child(3) > input")
    private WebElement yearExpirationInputBox;
    @FindBy(id = "submit")
    private WebElement payAndConfirmOrderButton;


    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillInPaymentDetails(String nameOnCard, String cardNumber, String cvc, String expirationDate) {
        nameOnCardInputBox.sendKeys(nameOnCard);
        cardNumberInputBox.sendKeys(cardNumber);
        cvcInputBox.sendKeys(cvc);
        String[] dateParts = expirationDate.split("/");
        monthExpirationInputBox.sendKeys(dateParts[0]);
        yearExpirationInputBox.sendKeys(dateParts[1]);
    }

    public void clickPayAndConfirmButton() {
        payAndConfirmOrderButton.click();
    }

}
