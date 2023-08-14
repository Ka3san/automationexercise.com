//package com.automationexercise.testcase2;
//
//import com.automationexercise.UserData;
//import com.automationexercise.pages.AccountCreatedPage;
//import com.automationexercise.pages.HomePage;
//import com.automationexercise.pages.LoginPage;
//import com.automationexercise.pages.SignupPage;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//import java.time.Duration;
//
//import static org.junit.Assert.assertEquals;
//
//public class LoginUserWithCorrectEmailAndPasswordSteps {
//
//    private WebDriver driver;
//    private UserData userData;
//    private HomePage homePage;
//    private LoginPage loginPage;
//    private SignupPage signupPage;
//    private AccountCreatedPage accountCreatedPage;
//
//    public void howAbout() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        userData = new UserData(driver);
//        homePage = new HomePage(driver);
//        loginPage = new LoginPage(driver);
//        signupPage = new SignupPage(driver);
//        accountCreatedPage = new AccountCreatedPage(driver);
//    }
//
//
//
//    @And("Verify 'Login to your account' is visible")
//    public void LoginToYourAccountVisibility() {
//        WebElement loginFormText = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
//        String textVisible = loginFormText.getText();
//        assertEquals("Login to your account", textVisible);
//    }
//
//    @And("Enter correct {string} and {string}")
//    public void enterEmailAndPassword(String email, String password) {
//        loginPage.fillEmailAndPassword(userData.setEmail(email).setPassword(password));
//
//    }
//
//
//}
//
//    //    Steps provided by RegisterUserSteps.java:
////    Given Launch browser
////    And Navigate to url http://automationexercise.com
////    When Verify that home page is visible successfully
////    And Click on Signup | Login button
////    And Verify that 'Logged in as username' is visible
//
