package com.automationexercise.pages;

import com.automationexercise.UserData;
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
    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmailInputBox;
    @FindBy(id = "subscribe")
    private WebElement subscribeButton;
    @FindBy(css = "i.fa.fa-shopping-cart")
    private WebElement cartButton;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div[1]/div[26]/div/div[2]/ul/li/a")
    private WebElement pureCottonNeonGreenTShirtViewProductButton;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div[1]/div[4]/div/div[1]/div[1]/a")
    private WebElement sleevelessDressAddToCartButton;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a")
    private WebElement blueTopAddToCartButton;
    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a")
    private WebElement menTShirtAddToCartButton;
    @FindBy(css = "div.left-sidebar")
    private WebElement categoryLeftSidebar;
    @FindBy(xpath = "//*[@id=\"accordian\"]/div[1]/div[1]/h4/a")
    private WebElement womenCategoryLink;
    @FindBy(xpath = "//*[@id=\"Women\"]/div/ul/li[1]/a")
    private WebElement womenCategoryDressLink;
    @FindBy(xpath = "//*[@id=\"Women\"]/div/ul/li[2]/a")
    private WebElement womenCategoryTopsLink;
    @FindBy(xpath = "//*[@id=\"Women\"]/div/ul/li[3]/a")
    private WebElement womenCategorySareeLink;
    @FindBy(xpath = "//*[@id=\"accordian\"]/div[2]/div[1]/h4/a")
    private WebElement menCategoryLink;
    @FindBy(xpath = "//*[@id=\"Men\"]/div/ul/li[1]/a")
    private WebElement menCategoryTshirtsLink;
    @FindBy(xpath = "//*[@id=\"Men\"]/div/ul/li[2]/a")
    private WebElement menCategoryJeansLink;
    @FindBy(xpath = "//*[@id=\"recommended-item-carousel\"]/div/div[2]/div[2]/div/div/div/a")
    private WebElement middleRecommendedItemAddToCartButton;
    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")
    private WebElement viewCartButton;
    @FindBy(id = "scrollUp")
    private WebElement scrollUpButton;

// TODO:
//    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div[1]/div[9]/div/div[1]/div[2]/div/a")
//    private WebElement fancyGreenTopAddToCartButton;
//    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div[1]/div[25]/div/div[1]/div[1]/a")
//    private WebElement premiumPoloTShirtsAddToCartButton;

    @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
    private WebElement continueShoppingButton;

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
//        deleteAccountButton.click();
        // TODO: uncomment second click if necessary
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

    public void enterEmailAndClickArrowButtonForSubscription(UserData userData) {
        subscribeEmailInputBox.sendKeys(userData.getEmail());
        subscribeButton.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void clickViewProductPureCottonNeonGreenTshirt() {
        pureCottonNeonGreenTShirtViewProductButton.click();
        pureCottonNeonGreenTShirtViewProductButton.click();
    }

    public void addProductsToCart() {
        sleevelessDressAddToCartButton.click();
        continueShoppingButton.click();
        blueTopAddToCartButton.click();
        continueShoppingButton.click();
        menTShirtAddToCartButton.click();
        continueShoppingButton.click();
    }

    public boolean checkCategoriesVisibility() {
        return categoryLeftSidebar.isDisplayed();
    }

    public void clickWomenCategory() {
        womenCategoryLink.click();
    }

    public void clickDressCategory() {
        womenCategoryDressLink.click();
        womenCategoryDressLink.click();
    }

    public void clickTopsCategory() {
        womenCategoryTopsLink.click();
        womenCategoryTopsLink.click();
    }

    public void clickSareeCategory() {
        womenCategorySareeLink.click();
        womenCategorySareeLink.click();
    }

    public void clickMenCategory() {
        menCategoryLink.click();
    }

    public void clickTshirtsCategory() {
        menCategoryTshirtsLink.click();
    }

    public void clickJeansCstegory() {
        menCategoryJeansLink.click();
    }

    public void clickAddToCartOnRecommendedProduct() {
        middleRecommendedItemAddToCartButton.click();
    }

    public void clickViewCartButton() {
        viewCartButton.click();
    }

    public void clickScrollUp() {
        scrollUpButton.click();
    }
}


