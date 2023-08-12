package com.automationexercise.pages;

import com.automationexercise.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.Month;


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

    }
    public void fillDate(UserData userData) {
        String dateOfBirth = userData.getDateOfBirth();

        LocalDate birthDate = LocalDate.parse(dateOfBirth);
        int day = birthDate.getDayOfMonth();
        Month month = birthDate.getMonth();
        int year = birthDate.getYear();

        dayOfBirth.sendKeys(String.valueOf(day));
        monthOfBirth.sendKeys(String.valueOf(month));
        yearOfBirth.sendKeys(String.valueOf(year));

    }

}
