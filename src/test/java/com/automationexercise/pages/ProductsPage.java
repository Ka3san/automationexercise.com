package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li/a")
    private WebElement firstProductViewProductButton;


    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickViewFirstProduct() {
        firstProductViewProductButton.click();
    }
}
