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

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean checkVisibility() {
        return mainPageSlider.isDisplayed();
    }

    public void clickSignup() {
        signupButton.click();
    }


}
