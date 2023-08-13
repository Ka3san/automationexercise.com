package com.automationexercise.testcase1;

import com.automationexercise.UserData;
import com.automationexercise.pages.AccountCreatedPage;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.pages.SignupPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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


}


