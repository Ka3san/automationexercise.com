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
    @FindBy(id = "first_name")
    private WebElement firstNameInputBox;
    @FindBy(id = "last_name")
    private WebElement lastNameInputBox;
    @FindBy(id = "company")
    private WebElement companyInputBox;
    @FindBy(id = "address1")
    private WebElement addressInputBox;
    @FindBy(id = "address2")
    private WebElement address2InputBox;
    @FindBy(id = "country")
    private WebElement countryInputBox;
    @FindBy(id = "state")
    private WebElement stateInputBox;
    @FindBy(id = "city")
    private WebElement cityInputBox;
    @FindBy(id = "zipcode")
    private WebElement zipcodeInputBox;
    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInputBox;
    @FindBy(css = "button.btn.btn-default")
    private WebElement createAccountButton;

    public SignupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public void fillLoginForm(UserData userData) {

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

    public void fillAddressInformationForm(UserData userData) {
        firstNameInputBox.sendKeys(userData.getFirstName());
        lastNameInputBox.sendKeys(userData.getLastName());
        companyInputBox.sendKeys(userData.getCompany());
        addressInputBox.sendKeys(userData.getAddress());
        address2InputBox.sendKeys(userData.getAddress2());
        countryInputBox.sendKeys(userData.getCountry());
        stateInputBox.sendKeys(userData.getState());
        cityInputBox.sendKeys(userData.getCity());
        zipcodeInputBox.sendKeys(userData.getZipCode());
        mobileNumberInputBox.sendKeys(userData.getMobileNumber());
    }

    public void clickCreateAccount() {
        createAccountButton.submit();
    }


}
