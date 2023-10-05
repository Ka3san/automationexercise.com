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
    @FindBy(css = "div.brands_products")
    private WebElement brandsLeftSidebar;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div[1]/div[3]/div/ul/li[1]/a")
    private WebElement poloBrandLink;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div[1]/div[3]/div/ul/li[2]/a")
    private WebElement hmBrandLink;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div[1]/div[3]/div/ul/li[3]/a")
    private WebElement madameBrandLink;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div[1]/div[3]/div/ul/li[4]/a")
    private WebElement mastHarbourBrandLink;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div[1]/div[3]/div/ul/li[5]/a")
    private WebElement babyhugBrandLink;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div[1]/div[3]/div/ul/li[6]/a")
    private WebElement allenSollyJuniorBrandLink;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div[1]/div[3]/div/ul/li[7]/a")
    private WebElement kookieKidsBrandLink;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div[1]/div[3]/div/ul/li[8]/a")
    private WebElement bibaBrandLink;
    private String brandName;

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

    public boolean checkBrandsSidebarVisibility() {
        return brandsLeftSidebar.isDisplayed();
    }

    public void clickPoloBrand() {
        poloBrandLink.click();
    }

    public void clickHmBrand() {
        hmBrandLink.click();
    }

    public void clickMadameBrand() {
        madameBrandLink.click();
    }

    public void clickMastHarbourBrand() {
        mastHarbourBrandLink.click();
    }

    public void clickBabyhugBrand() {
        babyhugBrandLink.click();
    }

    public void clickAllenSollyJuniorBrand() {
        allenSollyJuniorBrandLink.click();
    }

    public void clickKookieKidsBrand() {
        kookieKidsBrandLink.click();
    }

    public void clickBibaBrand() {
        bibaBrandLink.click();
    }

    public String getBrandName() {
        return brandName;
    }

    public ProductsPage setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }
}

