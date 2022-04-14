package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {
    public static final WebDriver webdriver;
    public static final HomePage homePage;
    public static final LoginPage loginPage;
    public static final ProfilePage profilePage;

    static {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/org/example/chromedriver.exe");
        webdriver = new ChromeDriver();
        webdriver.manage().window().maximize();
        homePage = new HomePage(webdriver);
        loginPage = new LoginPage(webdriver);
        profilePage = new ProfilePage(webdriver);
    }

    @Given("url of dns-shop {string}")
    public void url_of_dns_shop(String url) {
        homePage.openHomePage(url);
    }

    @When("website is open click login button")
    public void website_is_open_click_login_button() {
        homePage.openLoginPage();
    }

    @Then("click login with password")
    public void click_login_with_password() {
        loginPage.loginWithPassword();
    }

    @Then("enter email {string} and password {string}")
    public void enter_email_and_password(String email, String password) {
        loginPage.enterEmailAndPassword(email, password);
    }
    @Then("click submit button")
    public void click_submit_button() {
        loginPage.submit();
    }

    @Then("click profile link")
    public void click_profile_link() {
        homePage.clickProfileLink();
    }

    @Then("assert login email {string} = profile email")
    public void assert_login_email_profile_email(String loginEmail) {
        assertEquals(loginEmail, profilePage.profileEmail());
    }

    @Then("assert message {string} is visible")
    public void assert_message_is_visible(String errorMessage) {
        assertEquals(errorMessage, loginPage.errorMessage());
    }

}
