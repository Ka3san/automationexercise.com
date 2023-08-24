package com.automationexercise.pages;

import com.automationexercise.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

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
    @FindBy(css = "a.btn.btn-success")
    private WebElement homeButton;

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillInContactUsForm(UserData userData, String subject, String message) {
        nameInputBox.sendKeys(userData.getName());
        emailInputBox.sendKeys(userData.getEmail());
        subjectInputBox.sendKeys(subject);
        messageInputBox.sendKeys(message);
    }

    public void uploadFile() {
        uploadInputBox.sendKeys("/Users/ka3/Desktop/IntelliJIDEA_ReferenceCard.pdf");
    }

    public void clickSubmit() {
        uploadInputBox.submit();
    }

    public void clickOk() {
        System.out.println("click ;)");
    }

    public void clickHome() {
        homeButton.click();
        homeButton.click();
    }

}
