package com.automationexercise.pages;

import com.automationexercise.UserData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;


public class SignupPage {

    @FindBy(id = "id_gender1")
    private WebElement titleMrCheckBox;
    @FindBy(id = "id_gender2")
    private WebElement titleMrsCheckBox;
    @FindBy(id = "password")
    private WebElement passwordInputBox;
    @FindBy(id = "days")
    private WebElement dayOfBirthComboBox;
    @FindBy(id = "months")
    private WebElement monthOfBirthComboBox;
    @FindBy(id = "years")
    private WebElement yearOfBirthComboBox;
    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;
    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void fillForm(UserData userData) {

        if (Objects.equals(userData.getTitle(), "Mr.")) {
            titleMrCheckBox.click();
        } else {
            titleMrsCheckBox.click();
        }
        passwordInputBox.sendKeys(userData.getPassword());

        LocalDate birthDate = LocalDate.parse(userData.getDateOfBirth());
        int birthDay = birthDate.getDayOfMonth();
        Month birthMonth = birthDate.getMonth();
        int birthYear = birthDate.getYear();
        dayOfBirthComboBox.sendKeys(String.valueOf(birthDay));
        monthOfBirthComboBox.sendKeys(String.valueOf(birthMonth));
        yearOfBirthComboBox.sendKeys(String.valueOf(birthYear));
    }

    public void signUpForNewsletter() {
        newsletterCheckbox.sendKeys(Keys.TAB);
        newsletterCheckbox.click();
    }

    public void receiveSpecialOffers() {
        specialOffersCheckbox.click();
    }

}
