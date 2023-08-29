package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class ProductDetailsPage {
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")
    private WebElement product1Name;
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]")
    private WebElement product1Category;
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span")
    private WebElement product1Price;
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]")
    private WebElement product1Availability;
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]")
    private WebElement product1Condition;
    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]")
    private WebElement product1Brand;
    @FindBy(xpath = "//*[@id=\"quantity\"]")
    private WebElement productQuantityInputBox;
    @FindBy(css = "button.btn.btn-default.cart")
    private WebElement addToCartButton;

    public ProductDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkProductDetails() {
        assertTrue(product1Name.isDisplayed());
        assertTrue(product1Category.isDisplayed());
        assertTrue(product1Price.isDisplayed());
        assertTrue(product1Availability.isDisplayed());
        assertTrue(product1Condition.isDisplayed());
        assertTrue(product1Brand.isDisplayed());
    }

    public void changeQuantity(String pcs) {
        productQuantityInputBox.clear();
        productQuantityInputBox.sendKeys(pcs);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

}
