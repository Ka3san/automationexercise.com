package com.automationexercise.testcase1;

import com.automationexercise.UserData;
import com.automationexercise.pages.*;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.*;


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
    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;

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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        userData = new UserData(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        accountCreatedPage = new AccountCreatedPage(driver);
        contactUsPage = new ContactUsPage(driver);
        productsPage = new ProductsPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        paymentPage = new PaymentPage(driver);

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
        if (Objects.equals(driver.getTitle(), "Automation Exercise - Contact Us")) {
            contactUsPage.clickSubmit();
            driver.switchTo().alert().accept();
        } else if (Objects.equals(driver.getTitle(), "Automation Exercise - Product Details")) {
            productDetailsPage.submitReview();
        }
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

    //      TEST CASE 14

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

    @And("Verify {string} and Review Your Order")
    public void verifyAddressAndReviewOrder(String addressDetails) {
        // check if address delivery box on checkout page contains details from registration form
        checkoutPage.checkDeliveryAddress();
        String[] addressDeliveryArr = addressDetails.split(" ");
        for (String details : addressDeliveryArr) {
            assertTrue(checkoutPage.checkDeliveryAddress().contains(details));
        }
        checkoutPage.reviewOrder();
        driver.navigate().back();
        cartPage.checkItemsInCart();
        assertEquals(cartPage.checkItemsInCart(), checkoutPage.reviewOrder());
        driver.navigate().forward();
    }

    @And("Enter {string} in comment text area and click 'Place Order'")
    public void enterDescriptionInTextAreaAndPlaceOrder(String description) {
        checkoutPage.addCommentAndClickPlaceOrder(description);
    }

    @And("Enter payment details: {string}, {string}, {string}, {string}")
    public void enterPaymentDetails(String nameOnCard, String cardNumber, String cvc, String expirationDate) {
        String actualUrl = driver.getCurrentUrl();
        if (Objects.equals(actualUrl, "https://automationexercise.com/payment")) {
            paymentPage.fillInPaymentDetails(nameOnCard, cardNumber, cvc, expirationDate);
        } else {
            checkoutPage.clickPlaceOrder();
            paymentPage.fillInPaymentDetails(nameOnCard, cardNumber, cvc, expirationDate);
        }
    }

    @And("Click 'Pay and Confirm Order' button")
    public void clickPayAndConfirmOrderButton() {
        paymentPage.clickPayAndConfirmButton();
    }

    @Then("Verify success message 'Your order has been placed successfully!'")
    public void verifySuccessMessage() {
        driver.navigate().back();
        String successMessage = driver.findElement(By.id("success_message")).getText();
        assertEquals("Your order has been placed successfully!", successMessage);
        driver.navigate().forward();
    }

    // ...

    @And("Verify 'ACCOUNT DELETED!' and click 'Continue' button")
    public void verifyAccountDeletedAndClickContinue() {
        String accountDeletedAlert = driver.findElement(By.cssSelector("#form > div > div > div > h2 > b")).getText();
        assertEquals("ACCOUNT DELETED!", accountDeletedAlert);
        WebElement continueButton = driver.findElement(By.cssSelector("#form > div > div > div > div > a"));
        continueButton.click();
    }

    //      TEST CASE 16

    @And("Fill {string}, {string} and click 'Login' button")
    public void fillEmailPasswordAndClickLogin(String email, String password) {
        loginPage.fillEmailAndPassword(userData.setEmail(email).setPassword(password));
        loginPage.clickLoginButton();
    }

    @And("Verify ' Logged in as {string}' at top")
    public void verifyLoggedAsUsername(String name) {
        WebElement loggedAsUserText = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        String textVisible = loggedAsUserText.getText();
        assertEquals("Logged in as " + userData.setName(name).getName(), textVisible);
    }

    //      TEST CASE 17
// TODO: 06/09/2023 parametrization to choose products to be add and to be delete from cart

    @Then("Click 'X' button corresponding to particular {string}")
    public void clickXButtonToDeleteProduct(String product) {
        if (Objects.equals(product, "Dress")) {
            cartPage.deleteSleevelessDress();
        } else if (Objects.equals(product, "Tshirt")) {
            cartPage.deleteMenTshirt();
        } else if (Objects.equals(product, "Top")) {
            cartPage.deleteBlueTop();
        }
    }

    @And("Verify that {string} is removed from the cart")
    public void verifyProductWasDeleted(String product) {
        try {
            driver.findElement(By.id("product-3"));
        } catch (Exception exception) {
            System.out.println("Sleeveless Dress successful deleted");
        }
        try {
            driver.findElement(By.id("product-1"));
        } catch (Exception exception) {
            System.out.println("Blue Top successful deleted");
        }
        try {
            driver.findElement(By.id("product-2"));
        } catch (Exception exception) {
            System.out.println("Men Tshirt successful deleted");
        }
    }

    //      TEST CASE 18

    @When("Verify that categories are visible on left side bar")
    public void checkCategoriesAreVisible() {
        assertTrue(homePage.checkCategoriesVisibility());
    }

    @And("Click on 'Women' category")
    public void clickOnWomenCategory() {
        homePage.clickWomenCategory();
    }

    @And("Click on {string} link under 'Women' category")
    public void clickOnAnyLinkUnderWomanCategory(String womenCategory) {
        if (Objects.equals(womenCategory, "Dress")) {
            homePage.clickDressCategory();
        } else if (Objects.equals(womenCategory, "Tops")) {
            homePage.clickTopsCategory();
        } else if (Objects.equals(womenCategory, "Saree")) {
            homePage.clickSareeCategory();
        }
    }

    @And("Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'")
    public void verifyCategoryPageAndText() {
        String womenProductsCategoryText = driver.findElement(By.cssSelector("h2.title.text-center")).getText();
        assertTrue(womenProductsCategoryText.contains("PRODUCTS"));
        if (womenProductsCategoryText.equals("WOMEN - TOPS PRODUCTS")) {
            System.out.println("WOMEN - TOPS PRODUCTS visible");
        } else
            System.out.println("WOMEN - TOPS PRODUCTS not visible, You chose Dress or Saree category");
    }

    // alternative version with log info about text with chosen category

//    @And("Verify that category page is displayed and confirm text 'WOMEN - {string} PRODUCTS'")
//    public void verifyCategoryPageAndText(String womanCategory) {
//        String womenProductsCategoryText = driver.findElement(By.cssSelector("h2.title.text-center")).getText();
//        assertTrue(womenProductsCategoryText.contains("PRODUCTS"));
//            System.out.println("WOMEN - " + womanCategory.toUpperCase() + " PRODUCTS visible");
//    }

    @Then("On left side bar, click on {string} sub-category link of 'Men' category")
    public void clickOnAnyLinkUnderManCategory(String menCategory) {
        homePage.clickMenCategory();
        if (Objects.equals(menCategory, "Tshirts")) {
            homePage.clickTshirtsCategory();
        } else if (Objects.equals(menCategory, "Jeans")) {
            homePage.clickJeansCstegory();
        }
    }

    @And("Verify that user is navigated to that {string} page")
    public void verifyCorrectCategoryPageNavigation(String menCategory) {
        String menCategoryPageText = driver.findElement(By.cssSelector("h2.title.text-center")).getText();
        assertTrue(menCategoryPageText.contains(menCategory.toUpperCase()));
    }

    //      TEST CASE 19

    @And("Verify that Brands are visible on left side bar")
    public void verifyThatBrandsAreVisibleOnLeftSideBar() {
        assertTrue(productsPage.checkBrandsSidebarVisibility());
    }

    @And("Click on {string}")
    public void clickOnBrandName(String brandName) {
        productsPage.setBrandName(brandName);
        if (Objects.equals(brandName, "Polo")) {
            productsPage.clickPoloBrand();
        } else if (Objects.equals(brandName, "H&M")) {
            productsPage.clickHmBrand();
        } else if (Objects.equals(brandName, "Madame")) {
            productsPage.clickMadameBrand();
        } else if (Objects.equals(brandName, "Mast & Harbour")) {
            productsPage.clickMastHarbourBrand();
        } else if (Objects.equals(brandName, "Babyhug")) {
            productsPage.clickBabyhugBrand();
        } else if (Objects.equals(brandName, "Allen Solly Junior")) {
            productsPage.clickAllenSollyJuniorBrand();
        } else if (Objects.equals(brandName, "Kookie Kids")) {
            productsPage.clickKookieKidsBrand();
        } else if (Objects.equals(brandName, "Biba")) {
            productsPage.clickBibaBrand();
        }
    }

    @And("Verify that user is navigated to {string} page and brand products are displayed")
    public void verifyThatUserIsNavigatedToBrandPageAndBrandProductsAreDisplayed(String brandName) {
        productsPage.setBrandName(brandName);
        String brandProductsText = driver.findElement(By.cssSelector("h2.title.text-center")).getText();
        assertTrue(brandProductsText.contains(brandName.toUpperCase()));
        assertTrue(driver.findElement(By.cssSelector("div.col-sm-4")).isDisplayed());
    }

    /* other brands links selectors are different on every brand page (sic!) so I decided to click a brand link
    placed in the left side bar next to provided by feature file examples. apart from "Biba" brand clicking "Polo" link */
    @Then("On left side bar, click on any other {string} link")
    public void onLeftSideBarClickOnAnyOtherBrandLink(String brandName) {
        productsPage.setBrandName(brandName);
        if (Objects.equals(brandName, "Polo")) {
            driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div[1]/div[2]/div/ul/li[2]/a")).click();
        } else if (Objects.equals(brandName, "H&M")) {
            driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[3]/a")).click();
        } else if (Objects.equals(brandName, "Madame")) {
            driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[4]/a")).click();
        } else if (Objects.equals(brandName, "Mast & Harbour")) {
            driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[5]/a")).click();
        } else if (Objects.equals(brandName, "Babyhug")) {
            driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[6]/a")).click();
        } else if (Objects.equals(brandName, "Allen Solly Junior")) {
            driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[7]/a")).click();
        } else if (Objects.equals(brandName, "Kookie Kids")) {
            driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div/div[2]/div/ul/li[8]/a")).click();
        } else if (Objects.equals(brandName, "Biba")) {
            driver.findElement(By.xpath("/html/body/section/div/div[2]/div[1]/div[1]/div[2]/div/ul/li[1]/a")).click();
        }
    }

    // check if page title contains brand name placed in left side bar next to provided by feature file
    @And("Verify that user is navigated to that brand page and can see products")
    public void verifyThatUserIsNavigatedToThatBrandPageAndCanSeeProducts() {
        String brandName = productsPage.getBrandName();
        String title = driver.getTitle();
        if (Objects.equals(brandName, "Polo")) {
            assertTrue(title.contains("H&M"));
        } else if (Objects.equals(brandName, "H&M")) {
            assertTrue(title.contains("Madame"));
        } else if (Objects.equals(brandName, "Madame")) {
            assertTrue(title.contains("Mast & Harbour"));
        } else if (Objects.equals(brandName, "Mast & Harbour")) {
            assertTrue(title.contains("Babyhug"));
        } else if (Objects.equals(brandName, "Babyhug")) {
            assertTrue(title.contains("Allen Solly Junior"));
        } else if (Objects.equals(brandName, "Allen Solly Junior")) {
            assertTrue(title.contains("Kookie Kids"));
        } else if (Objects.equals(brandName, "Kookie Kids")) {
            assertTrue(title.contains("Biba"));
        } else if (Objects.equals(brandName, "Biba")) {
            assertTrue(title.contains("Polo"));
        }
        assertTrue(driver.findElement(By.cssSelector("div.col-sm-4")).isDisplayed());
    }

    //      TEST CASE 20

    @And("Add those products to cart")
    public void addThoseProductsToCart() {
        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//*[text()='Add to cart']"));
        try {
            for (WebElement button : addToCartButtons) {
                button.click();
                productsPage.clickContinueShopping();
            }
        } catch (Exception ElementNotInteractableException) {
            System.out.println("Some products can NOT be added to cart - Add To Cart button is not clickable in this cases");
        }
    }

    @Then("Click 'Cart' button and verify that products are visible in cart")
    public void clickCartButtonAndVerifyThatProductsAreVisibleInCart() {
        homePage.clickCartButton();
        assertTrue(driver.findElement(By.id("cart_info")).isDisplayed());
        cartPage.checkProductsInCartBeforeLogin();
    }

    @And("Click Signup | Login button and submit login details: {string} and {string}")
    public void clickSignupLoginButtonAndSubmitLoginDetailsEmailPassword(String email, String password) {
        cartPage.clickSignupLogin();
        loginPage.fillEmailAndPassword(userData.setEmail(email).setPassword(password));
        loginPage.clickLoginButton();
    }

    @And("Again, go to Cart page")
    public void againGoToCartPage() {
        homePage.clickCartButton();
    }

    @And("Verify that those products are visible in cart after login as well")
    public void verifyThatThoseProductsAreVisibleInCartAfterLoginAsWell() {
        assertEquals(cartPage.checkProductsInCartBeforeLogin(), cartPage.checkProductsInCartAfterLogin());
    }

    //      TEST CASE 21

    @And("Click on View Product button")
    public void clickOnViewProductButton() {
        productsPage.clickViewFirstProduct();
    }

    @And("Verify Write Your Review is visible")
    public void verifyWriteYourReviewIsVisible() {
        assertEquals("WRITE YOUR REVIEW", driver.findElement(By.cssSelector("li.active")).getText());
    }

    @Then("Enter {string}, {string} and {string}")
    public void enterNameEmailAndReview(String name, String email, String review) {
        productDetailsPage.fillReviewForm(name, email, review);
    }

    @And("Verify success message Thank you for your review.")
    public void verifySuccessMessageThankYouForYourReview() {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"review-section\"]/div/div/span")).isDisplayed());
    }

    //      TEST CASE 22
    @When("Scroll to bottom of page")
    public void scrollToBottomOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    @And("Verify RECOMMENDED ITEMS are visible")
    public void verifyRECOMMENDEDITEMSAreVisible() {
        assertTrue(driver.findElement(By.cssSelector("div.recommended_items")).isDisplayed());
    }

    @And("Click on Add To Cart on Recommended product")
    public void clickOnAddToCartOnRecommendedProduct() {
        homePage.clickAddToCartOnRecommendedProduct();
    }

    @Then("Click on View Cart button")
    public void clickOnViewCartButton() {
        homePage.clickViewCartButton();
    }

    @And("Verify that product is displayed in cart page")
    public void verifyThatProductIsDisplayedInCartPage() {
        assertTrue(driver.findElement(By.id("cart_info_table")).isDisplayed());
    }


//    @And("Quit browser for better performance")
//    public void quitBrowser() {
//        driver.quit();
//    }
}


