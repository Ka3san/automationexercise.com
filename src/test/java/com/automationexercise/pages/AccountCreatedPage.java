package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    private WebElement continueButton;


    public AccountCreatedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickContinue() {
        continueButton.click();
        continueButton.click();
    }
}
