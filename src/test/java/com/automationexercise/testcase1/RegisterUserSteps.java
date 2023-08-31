package com.automationexercise.testcase1;

import com.automationexercise.UserData;
import com.automationexercise.pages.*;
import com.google.common.base.Verify;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RegisterUserSteps {
    private WebDriver driver;
    private UserData userData;
    private HomePage homePage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private AccountCreatedPage accountCreatedPage;
    private ContactUsPage contactUsPage;
    private ProductsPage productsPage;
    private ProductDetailsPage productDetailsPage;
    private CartPage cartPage;

    @AfterStep
    public void closeFrames() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelectorAll(\"iframe\").forEach((elem)=> { elem.parentNode.removeChild(elem); });");
        js.executeScript("document.querySelectorAll(\"ins.adsbygoogle\").forEach((elem) => { elem.parentNode.removeChild(elem) });");
    }

    @Given("Launch browser")
    public void launchChromeBrowser() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        userData = new UserData(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        contactUsPage = new ContactUsPage(driver);
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);

    }

    @And("^Navigate to url ([^ ]+)")
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    @When("Verify that home page is visible successfully")
    public void loadPageVerification() {
        assertTrue(homePage.checkVisibility());
    }

    @And("Click on Signup | Login button")
    public void clickOnSignupLoginButton() {
        homePage.clickSignup();
    }

    @And("Verify 'New User Signup!' is visible")
    public void newUserSignupVisibility() {
        WebElement signUpFormText = driver.findElement(By.cssSelector("#form > div > div > div:nth-child(3) > div > h2"));
        String textVisible = signUpFormText.getText();
        assertEquals("New User Signup!", textVisible);
    }

    @And("Enter {string} and {string}")
    public void enterNameAndEmail(String name, String email) {
        loginPage.fillNameAndEmail(userData.setName(name).setEmail(email));
    }

    @And("Click 'Signup' button")
    public void clickSignupButton() {
        loginPage.clickSignupButton();
    }

    @And("Verify that 'ENTER ACCOUNT INFORMATION' is visible")
    public void enterAccountInformationVisibility() {
        WebElement loginFormText = driver.findElement(By.cssSelector("#form > div > div > div > div.login-form > h2 > b"));
        String textVisible = loginFormText.getText();
        assertEquals("ENTER ACCOUNT INFORMATION", textVisible);
    }

    @And("Fill details: {string}, {string}, {string}, {string}, {string}")
    public void fillLoginForm(String title, String name, String email, String password, String dateOfBirth) {
        signupPage.fillLoginForm(userData.setTitle(title).setName(name).setEmail(email).setPassword(password).setDateOfBirth(dateOfBirth));
    }

    @And("Select checkbox 'Sign up for our newsletter!'")
    public void selectNewsletterCheckbox() {
        signupPage.signUpForNewsletter();
    }

    @And("Select checkbox 'Receive special offers from our partners!'")
    public void selectReceiveSpecialOffers() {
        signupPage.receiveSpecialOffers();
    }

    @And("Fill details: {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void fillAddressDetails(String firstName, String lastName, String company, String address, String address2, String country, String state, String city, String zipcode, String mobileNumber) {
        signupPage.fillAddressInformationForm(userData.setFirstName(firstName).setLastName(lastName).setCompany(company).setAddress(address).setAddress2(address2).setCountry(country).setState(state).setCity(city).setZipCode(zipcode).setMobileNumber(mobileNumber));
    }

    @And("Click 'Create Account button'")
    public void clickCreateAccountButton() {
        signupPage.clickCreateAccount();
    }

    @Then("Verify that 'ACCOUNT CREATED!' is visible")
    public void newAccountCreatedVisibility() {
        WebElement accountCreatedPageText = driver.findElement(By.cssSelector("#form > div > div > div > h2 > b"));
        String textVisible = accountCreatedPageText.getText();
        assertEquals("ACCOUNT CREATED!", textVisible);
    }

    @And("Click 'Continue' button")
    public void clickContinueButton() {
        accountCreatedPage.clickContinue();
    }

    @And("Verify that 'Logged in as username' is visible")
    public void loggedInAsUsernameVisibility() {
        WebElement loggedAsUserText = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        String textVisible = loggedAsUserText.getText();
        assertEquals("Logged in as " + userData.getName(), textVisible);

//        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"aswift_1\"]")));
//        driver.findElement(By.id("dismiss-button"));
//        driver.switchTo().defaultContent();

//        driver.navigate().to("http://automationexercise.com");

//        WebElement frame = driver.findElement(By.xpath("/html/body/script[3]"));
//        Point location = frame.getLocation();
//        int x = location.getX();
//        int y = location.getY();
//        Robot r = new Robot();
//        r.mouseMove(x, y);
//        r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        Thread.sleep(Duration.ofSeconds(5));

    }

//      TEST CASE 2

    @And("Verify 'Login to your account' is visible")
    public void LoginToYourAccountVisibility() {
        WebElement loginFormText = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
        String textVisible = loginFormText.getText();
        assertEquals("Login to your account", textVisible);
    }

    @And("Enter correct {string} and {string}")
    public void enterEmailAndPassword(String email, String password) {
        loginPage.fillEmailAndPassword(userData.setEmail(email).setPassword(password));
    }

    @And("Click 'login' button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @And("Verify that 'Logged in as {string}' is visible")
    public void loggedInAsUsernameXVisibility(String name) {
        WebElement loggedAsUserText = driver.findElement(By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a"));
        String textVisible = loggedAsUserText.getText();
        assertEquals("Logged in as " + userData.setName(name).getName(), textVisible);
    }

    @Then("Click 'Delete Account' button")
    public void clickDeleteAccountButton() {
        homePage.clickDeleteAccount();
    }

    @And("Verify that 'ACCOUNT DELETED!' is visible")
    public void accountDeletedVisibility() {
        WebElement accountDeletedText = driver.findElement(By.cssSelector("#form > div > div > div > h2 > b"));
        String textVisible = accountDeletedText.getText();
        assertEquals("ACCOUNT DELETED!", textVisible);
    }

    //      TEST CASE 3

    @And("Verify error 'Your email or password is incorrect!' is visible")
    public void yourEmailOrPasswordIsIncorrectErrorVisibility() {
        WebElement loginErrorText = driver.findElement(By.cssSelector("#form > div > div > div.col-sm-4.col-sm-offset-1 > div > form > p"));
        String textVisible = loginErrorText.getText();
        assertEquals("Your email or password is incorrect!", textVisible);
    }

    //      TEST CASE 4

    @Then("Click 'Logout' button")
    public void clickLogoutButton() {
        homePage.clickLogout();
    }

    @And("Verify that user is navigated to login page")
    public void checkIfNavigatedToLoginPage() {
        loginPage.checkVisibility();
    }

    //      TEST CASE 5

    @And("Verify error 'Email Address already exist!' is visible")
    public void emailAddressAlreadyExistsErrorVisibility() {
        WebElement loginErrorText = driver.findElement(By.cssSelector("#form > div > div > div:nth-child(3) > div > form > p"));
        String textVisible = loginErrorText.getText();
        assertEquals("Email Address already exist!", textVisible);
    }

    //      TEST CASE 6

    @And("Click on 'Contact Us' button")
    public void clickOnContactUsButton() {
        homePage.clickContactUs();
    }

    @And("Verify 'GET IN TOUCH' is visible")
    public void getInTouchVisibility() {
        WebElement getInTouchText = driver.findElement(By.cssSelector("#contact-page > div.row > div.col-sm-8 > div > h2"));
        String textVisible = getInTouchText.getText();
        assertEquals("GET IN TOUCH", textVisible);
    }

    @And("Enter {string}, {string}, {string} and {string}")
    public void fillInContactUsForm(String name, String email, String subject, String message) {
        contactUsPage.fillInContactUsForm(userData.setName(name).setEmail(email), subject, message);
    }

    @And("Upload file")
    public void fileUpload() {
        contactUsPage.uploadFile();
    }

    @And("Click 'Submit' button")
    public void submit() {
        contactUsPage.clickSubmit();
        driver.switchTo().alert().accept();
    }

    @And("Click OK button")
    public void clickOk() {
        contactUsPage.clickOk();
    }

    @Then("Verify success message 'Success! Your details have been submitted successfully.' is visible")
    public void successfulContactMessageVisibility() {
        WebElement successText = driver.findElement(By.cssSelector("div.status.alert.alert-success"));
        String textVisible = successText.getText();
        assertEquals("Success! Your details have been submitted successfully.", textVisible);
    }

    @And("Click 'Home' button and verify that landed to home page successfully")
    public void clickHomeAndVerifyLandingPage() {
        contactUsPage.clickHome();
        String title = driver.getTitle();
        assertEquals("Automation Exercise", title);
    }

    //      TEST CASE 7

    @And("Click on 'Test Cases' button")
    public void clickTestCasesButton() {
        homePage.clickTestCases();
    }

    @And("Verify user is navigated to test cases page successfully")
    public void verifyNavigationToTestCasesPage() {
        String title = driver.getTitle();
        assertEquals("Automation Practice Website for UI Testing - Test Cases", title);
    }

    //      TEST CASE 8

    @And("Click on 'Products' button")
    public void clickProductsButton() {
        homePage.clickProducts();
    }

    @And("Verify user is navigated to ALL PRODUCTS page successfully")
    public void verifyNavigationToAllProductsPage() {

//        driver.navigate().to("https://automationexercise.com/products");

        String title = driver.getTitle();
        assertEquals("Automation Exercise - All Products", title);
    }

    @And("The products list is visible")
    public void productListVisibility() {
        driver.findElement(By.cssSelector("div.features_items")).isDisplayed();
    }

    @And("Click on 'View Product' of first product")
    public void clickViewProduct() {
        productsPage.clickViewFirstProduct();
    }

    @Then("User is landed to product detail page")
    public void checkProductDetailPageLanding() {
        String title = driver.getTitle();
        assertEquals("Automation Exercise - Product Details", title);
    }

    @And("Verify that detail detail is visible: product name, category, price, availability, condition, brand")
    public void checkProductDetailsVisibility() {
        productDetailsPage.checkProductDetails();
    }

    //      TEST CASE 9

    @And("Enter {string} in search input and click search button")
    public void enterProductName(String productName) {
        productsPage.enterProductNameAndClickSearch(productName);
    }

    @And("Verify 'SEARCHED PRODUCTS' is visible")
    public void searchedProductsVisibility() {
        WebElement searchedProductsText = driver.findElement(By.cssSelector("h2.title.text-center"));
        String textVisible = searchedProductsText.getText();
        assertEquals("SEARCHED PRODUCTS", textVisible);
    }

    @And("Verify all the products related to search are visible")
    public void verifySearchProductsVisibility() {

        // get phrase provided to search input box
        String productName = driver.findElement(By.id("search_product")).getAttribute("value");
        // navigate back and count all products containing search phrase
        driver.navigate().back();
        // parametrization in xpath selector do not work :/ have to put phrase manually
        int countAll = driver.findElements(By.xpath("//*[contains(text(),'\" + productName + \"')]")).size();
        // navigate forward to searched products and count products containing search phrase
        driver.navigate().forward();
        // parametrization in xpath selector do not work :/ have to put phrase manually
        int countSearched = driver.findElements(By.xpath("//*[contains(text(),'\" + productName + \"')]")).size();
        assertEquals(countAll, countSearched);

//        try {
//            driver.findElement(By.cssSelector("div.productinfo.text-center")).isDisplayed();
//            System.out.println("Search Results Visible");
//        } catch (NoSuchElementException noSearchResults) {
//            System.out.println("No Visible Search Results");
//        }

    }

    //      TEST CASE 10

    @And("Scroll down to footer")
    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    @And("Verify text 'SUBSCRIPTION'")
    public void subscriptionTextVisibility() {
        WebElement subscriptionText = driver.findElement(By.cssSelector("#footer > div.footer-widget > div > div > div.col-sm-3.col-sm-offset-1 > div > h2"));
        String textVisible = subscriptionText.getText();
        assertEquals("SUBSCRIPTION", textVisible);
    }

    @And("Enter {string} in input and click arrow button")
    public void enterEmailAndSubmitForSubscription(String email) {
        String pageTitle = driver.getTitle();
        // test case 10
        if (Objects.equals(pageTitle, "Automation Exercise")) {
            homePage.enterEmailAndClickArrowButtonForSubscription(userData.setEmail(email));
            // test case 11
        } else if (Objects.equals(pageTitle, "Automation Exercise - Checkout")) {
            cartPage.enterEmailAndClickArrowButtonForSubscription(userData.setEmail(email));
        }
    }

    @And("Verify success message 'You have been successfully subscribed!' is visible")
    public void checkSubscriptionAlertVisibility() {
        WebElement successAlert = driver.findElement(By.id("success-subscribe"));
        String textVisible = successAlert.getText();
        assertEquals("You have been successfully subscribed!", textVisible);
    }

    //      TEST CASE 11

    @And("Click 'Cart' button")
    public void clickCartButton() {
        homePage.clickCartButton();
    }

    //      TEST CASE 12

    @And("Hover over first product and click 'Add to cart'")
    public void hoverOverFirstProduct() throws AWTException, InterruptedException {
        WebElement element = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a"));

        productsPage.addFirstProductToCart();

//        // content window size
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        int contentHeight = ((Number) js.executeScript("return window.innerHeight")).intValue();
//        int contentWidth = ((Number) js.executeScript("return window.innerWidth")).intValue();
//        System.out.println(contentHeight + " " + contentWidth);
//
//        Point location = element.getLocation();
//        // System.out.println("location: " + location);
//        double xCoordinate = location.getX();
//        double yCoordinate = location.getY();
//        int x = (int) xCoordinate;
//        int y = (int) yCoordinate;
//        Robot robot = new Robot();
//        robot.mouseMove(x + 10, y + 180);
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//

    }

    @And("Click 'Continue Shopping' button")
    public void clickContinueShoppingButton() {
        productsPage.clickContinueShopping();
    }

    @And("Hover over second product and click 'Add to cart'")
    public void hoverOverSecondProduct() throws AWTException {
        WebElement element = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[1]/a"));

        productsPage.addSecondProductToCart();

        // here it workED yesterday but not today??? something is def wrong with this page elements location...
//
//        Point location = element.getLocation();
////        System.out.println("location: " + location);
//        double xCoordinate = location.getX();
//        double yCoordinate = location.getY();
//        int x = (int) xCoordinate;
//        int y = (int) yCoordinate;
//        Robot robot = new Robot();
//        robot.mouseMove(x, y);
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

    }

    @And("Click 'View Cart' button")
    public void clickViewCartButton() {
        productsPage.clickViewCart();
    }

    @And("Verify both products are added to Cart")
    public void verifyProductsInCart() {
        WebElement firstProduct = driver.findElement(By.id("product-1"));
        WebElement firstProductName = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[2]/h4/a"));
        assertTrue(firstProduct.isDisplayed());
        assertEquals("Blue Top", firstProductName.getText());
        WebElement secondProduct = driver.findElement(By.id("product-2"));
        WebElement secondProductName = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[2]/h4/a"));
        assertTrue(secondProduct.isDisplayed());
        assertEquals("Men Tshirt", secondProductName.getText());
    }

    @And("Verify their prices, quantity and total price")
    public void verifyProductsInCartPurchaseDetails() {
        // first product
        WebElement firstPrice = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[3]/p"));
        WebElement firstQuantity = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[4]/button"));
        WebElement firstTotal = driver.findElement(By.xpath("//*[@id=\"product-1\"]/td[5]/p"));
        String firstProductPriceText = firstPrice.getText();
        String firstProductPriceValue = firstProductPriceText.replaceAll("Rs. ", "");
        int firstProductPrice = Integer.parseInt(firstProductPriceValue);
        String firstProductQuantityText = firstQuantity.getText();
        int firstProductQuantity = Integer.parseInt(firstProductQuantityText);
        String firstProductTotalText = firstTotal.getText();
        String firstProductTotalValue = firstProductTotalText.replaceAll("Rs. ", "");
        int firstProductTotalPrice = Integer.parseInt(firstProductTotalValue);
        assertEquals(firstProductPrice * firstProductQuantity, firstProductTotalPrice);

        // second product
        WebElement secondPrice = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[3]/p"));
        WebElement secondQuantity = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[4]/button"));
        WebElement secondTotal = driver.findElement(By.xpath("//*[@id=\"product-2\"]/td[5]/p"));
        String secondProductPriceText = secondPrice.getText();
        String secondProductPriceValue = secondProductPriceText.replaceAll("Rs. ", "");
        int secondProductPrice = Integer.parseInt(secondProductPriceValue);
        String secondProductQuantityText = secondQuantity.getText();
        int secondProductQuantity = Integer.parseInt(secondProductQuantityText);
        String secondProductTotalText = secondTotal.getText();
        String secondProductTotalValue = secondProductTotalText.replaceAll("Rs. ", "");
        int secondProductTotalPrice = Integer.parseInt(secondProductTotalValue);
        assertEquals(secondProductPrice * secondProductQuantity, secondProductTotalPrice);
    }

    //      TEST CASE 13

    @And("Click 'View Product' for any product on home page")
    public void clickViewAnyProduct() {
        homePage.clickViewProductPureCottonNeonGreenTshirt();
    }

    @And("Verify product detail is opened")
    public void checkProductDetailPageIsOpened() {
        String title = driver.getTitle();
        assertEquals("Automation Exercise - Product Details", title);
    }

    @And("Increase quantity to {string}")
    public void increaseQuantityTo(String pcs) {
        productDetailsPage.changeQuantity(pcs);
    }

    @And("Click 'Add to cart' button")
    public void clickAddToCart() {
        productDetailsPage.clickAddToCartButton();
    }

//    @And("Click 'View Cart' button")
//    public void clickViewCartButton() {
//        here should be called method from ProductDetailsPage but 'Added!' dialog is the same for all sites
//        with the same 'View Cart' button, so feature file can use method from ProductsPage and it works
//    }

    @And("Verify that product is displayed in cart page with exact quantity")
    public void verifyProductQuantityInCart() {
        String quantityInCart = driver.findElement(By.xpath("//*[@id=\"product-31\"]/td[4]/button")).getText();
//        System.out.println("In cart: " + quantityInCart);
        driver.navigate().back();
        // same case, 'Continue Shopping' button in dialog 'Added!' clicked by ProductPage
        productsPage.clickContinueShopping();
        String providedQuantity = driver.findElement(By.xpath("//*[@id=\"quantity\"]")).getAttribute("value");
//        System.out.println("Provided quantity: " + providedQuantity);
        assertEquals(providedQuantity, quantityInCart);
    }

    //      TEST CASE 13

    @And("Add products to cart")
    public void addProductsToCart() {
        homePage.addProductsToCart();
    }

    @And("Verify that cart page is displayed")
    public void verifyCartPageIsDisplayed() {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"cart_items\"]/div/div[1]/ol/li[2]")).isDisplayed());
    }

    @And("Click Proceed To Checkout")
    public void clickProceedToCheckout() {
        cartPage.clickCheckoutButton();
    }

    @And("Click Register | Login button")
    public void clickRegisterLoginButton() {
        cartPage.clickRegisterLogin();
    }

    @And("Fill {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} in Signup and create account")
    public void fillAllDetailsAndCreateAccount(String name, String email, String password, String firstName, String lastName, String address, String country, String state, String city, String zipcode, String mobileNumber) {
        loginPage.fillNameAndEmail(userData.setName(name).setEmail(email));
        loginPage.clickSignupButton();
        signupPage.fillAllDetailsToRegisterUserWhileCheckout(userData.setPassword(password).setFirstName(firstName).setLastName(lastName).setAddress(address).setCountry(country).setState(state).setCity(city).setZipCode(zipcode).setMobileNumber(mobileNumber));
        signupPage.clickCreateAccount();
    }

    @And("Verify 'ACCOUNT CREATED!' and click 'Continue' button")
    public void verifyAccountCreatedAndClickContinue() {
        WebElement accountCreatedPageText = driver.findElement(By.cssSelector("#form > div > div > div > h2 > b"));
        String textVisible = accountCreatedPageText.getText();
        assertEquals("ACCOUNT CREATED!", textVisible);
        accountCreatedPage.clickContinue();
    }

    @And("Verify ' Logged in as username' at top")
    public void verifyLoggedAsUsername() {
        WebElement loggedAsUserText = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        String textVisible = loggedAsUserText.getText();
        assertEquals("Logged in as " + userData.getName(), textVisible);
    }

    @And("Click 'Proceed To Checkout' button")
    public void clickProceedToCheckoutButton() {
        cartPage.clickCheckoutButton();
    }


    @And("Quit browser for better performance")
    public void quitBrowser() {
        driver.quit();
    }


}


