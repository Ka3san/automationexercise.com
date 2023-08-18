package com.automationexercise.pages;

import com.automationexercise.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "name")
    private WebElement nameInputBox;
    @FindBy(css = "#form > div > div > div:nth-child(3) > div > form > input[type=email]:nth-child(3)")
    private WebElement signupEmailInputBox;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
    private WebElement signupButton;
    @FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=email]:nth-child(2)")
    private WebElement loginEmailInputBox;
    @FindBy(css = "#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > input[type=password]:nth-child(3)")
    private WebElement passwordInputBox;
    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
    private WebElement loginButton;
    @FindBy(css = "div.login-form")
    private WebElement loginForm;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillNameAndEmail(UserData userData) {
        nameInputBox.sendKeys(userData.getName());
        signupEmailInputBox.sendKeys(userData.getEmail());
    }

    public void clickSignupButton() {
        signupButton.click();
    }

    public void fillEmailAndPassword(UserData userData) {
        loginEmailInputBox.sendKeys(userData.getEmail());
        passwordInputBox.sendKeys(userData.getPassword());
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean checkVisibility() {
        return loginForm.isDisplayed();
    }
}
