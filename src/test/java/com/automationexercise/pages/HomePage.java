package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    @FindBy(css = "div.carousel-inner")
    private WebElement mainPageSlider;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean checkVisibility() {
        return mainPageSlider.isDisplayed();
    }


}
