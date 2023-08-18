package com.automationexercise.testcase1;

import com.automationexercise.UserData;
import com.automationexercise.pages.AccountCreatedPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.SignupPage;
import com.google.common.base.Verify;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;


import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RegisterUserSteps {
    private WebDriver driver;
    private UserData userData;
    private HomePage homePage;
    private LoginPage loginPage;
    private SignupPage signupPage;
    private AccountCreatedPage accountCreatedPage;


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

//        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"aswift_1\"]")));
//        driver.findElement(By.id("dismiss-button"));
//        driver.switchTo().defaultContent();

        driver.get("http://automationexercise.com");


//        if (driver instanceof JavascriptExecutor) {
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//        }

//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("document.querySelectorAll(\"iframe\").forEach((elem)=> { elem.remove() })");


        WebElement loggedAsUserText = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        String textVisible = loggedAsUserText.getText();
        assertEquals("Logged in as " + userData.getName(), textVisible);
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

        driver.get("https://automationexercise.com/delete_account");

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


}


