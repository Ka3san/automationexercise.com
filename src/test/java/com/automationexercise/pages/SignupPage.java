package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    @FindBy(id = "id_gender1")
    private WebElement titleCheckBox;
    @FindBy(id = "password")
    private WebElement passwordInputBox;
    @FindBy(id = "days")
    private WebElement dayOfBirth;
    @FindBy(id = "months")
    private WebElement monthOfBirth;
    @FindBy(id = "years")
    private WebElement yearOfBirth;

    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

//        wyciągnąć tutaj z daty stringi day month year i podstawić do sendKeys... :)
    }
}
