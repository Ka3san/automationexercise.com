package com.automationexercise.testcase1;

import com.automationexercise.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class RegisterUserSteps {
    private WebDriver driver;
    private HomePage homePage;

    @Given("Launch browser")
    public void launchChromeBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);

    }

    @And("^Navigate to url ([^ ]+)")
    public void navigateToUrl(String url) {
        driver.get(url);
    }

    @When("Verify that home page is visible successfully")
    public void loadPageVerification() {
        assertTrue(homePage.checkVisibility());

    }


}

