package com.automationexercise.pages;

import com.automationexercise.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    @FindBy(name = "name")
    private WebElement nameInputBox;
    @FindBy(name = "email")
    private WebElement emailInputBox;
    @FindBy(name = "subject")
    private WebElement subjectInputBox;
    @FindBy(name = "message")
    private WebElement messageInputBox;

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillInContactUsForm(UserData userData) {
        nameInputBox.sendKeys(userData.getName());
        emailInputBox.sendKeys(userData.getEmail());
        subjectInputBox.sendKeys(userData.getSubject());
        messageInputBox.sendKeys(userData.getMessage());
    }
}
