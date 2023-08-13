package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
    @FindBy(css = "a.btn.btn-primary")
    private WebElement continueButton;


    public AccountCreatedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickContinue() {
        continueButton.click();
    }
}
