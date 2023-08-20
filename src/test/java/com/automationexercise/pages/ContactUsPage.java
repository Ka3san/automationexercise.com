package com.automationexercise.pages;

import com.automationexercise.UserData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.InputEvent;

public class ContactUsPage {
    @FindBy(name = "name")
    private WebElement nameInputBox;
    @FindBy(name = "email")
    private WebElement emailInputBox;
    @FindBy(name = "subject")
    private WebElement subjectInputBox;
    @FindBy(name = "message")
    private WebElement messageInputBox;
    @FindBy(name = "upload_file")
    private WebElement uploadInputBox;

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillInContactUsForm(UserData userData) {
        nameInputBox.sendKeys(userData.getName());
        emailInputBox.sendKeys(userData.getEmail());
        subjectInputBox.sendKeys(userData.getSubject());
        messageInputBox.sendKeys(userData.getMessage());
    }

    public void uploadFile() {
        uploadInputBox.sendKeys("/Users/ka3/Desktop/IntelliJIDEA_ReferenceCard.pdf");
    }

    public void clickSubmit() {
        uploadInputBox.submit();
    }

}
