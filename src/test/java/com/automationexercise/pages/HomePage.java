package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    @FindBy(css = "div.carousel-inner")
    private WebElement mainPageSlider;
    @FindBy(css = "i.fa.fa-lock")
    private WebElement signupButton;
    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a")
    private WebElement deleteAccountButton;
    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a")
    private WebElement logoutButton;
    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(8) > a")
    private WebElement contactUsButton;
    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a")
    private WebElement testCasesButton;
    @FindBy(css = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a > i")
    private WebElement productsButton;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean checkVisibility() {
        return mainPageSlider.isDisplayed();
    }

    public void clickSignup() {
        signupButton.click();
    }

    public void clickDeleteAccount() {
        deleteAccountButton.click();
        deleteAccountButton.click();
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public void clickContactUs() {
        contactUsButton.click();
    }

    public void clickTestCases() {
        testCasesButton.click();
        testCasesButton.click();

    }

    public void clickProducts() {
        productsButton.click();
        productsButton.click();
    }
}

