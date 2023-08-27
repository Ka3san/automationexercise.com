package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductsPage {
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li/a")
    private WebElement firstProductViewProductButton;
    @FindBy(id = "search_product")
    private WebElement searchProductInputBox;
    @FindBy(id = "submit_search")
    private WebElement searchButton;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a")
    private WebElement firstProductAddToCartButton;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a")
    private WebElement secondProductAddToCartButton;
    @FindBy(css = "button.btn.btn-success.close-modal.btn-block")
    private WebElement continueShoppingButton;
    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")
    private WebElement viewCartButton;


    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickViewFirstProduct() {
        firstProductViewProductButton.click();
    }

    public void enterProductNameAndClickSearch(String productName) {
        searchProductInputBox.sendKeys(productName);
        searchButton.click();
    }

    public void addFirstProductToCart() {
        firstProductAddToCartButton.click();
    }

    public void clickContinueShopping() {
        continueShoppingButton.click();
    }

    public void clickViewCart() {
        viewCartButton.click();
    }

    public void addSecondProductToCart() {
        secondProductAddToCartButton.click();
    }
}
