package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public record LoginPage(WebDriver webdriver) {
    private static final String LOGIN_WITH_PASSWORD_LINK_CLASS = "block-other-login-methods__password-caption";
    private static final String EMAIL_INPUT_XPATH = "//input[@type='text']";
    private static final String PASSWORD_INPUT_XPATH = "//input[@type='password']";
    private static final String SUBMIT_BUTTON_CLASS = "base-ui-button";
    private static final String ERROR_MESSAGE_CLASS = "error-message-block";

    public void loginWithPassword() {
        (new WebDriverWait(webdriver, Duration.ofSeconds(30)))
                .until(ExpectedConditions.elementToBeClickable(By.className(LOGIN_WITH_PASSWORD_LINK_CLASS)));
        webdriver.findElement(By.className(LOGIN_WITH_PASSWORD_LINK_CLASS)).click();
    }

    public void enterEmailAndPassword(String email, String password) {
        webdriver.findElement(By.xpath(EMAIL_INPUT_XPATH)).sendKeys(email);
        webdriver.findElement(By.xpath(PASSWORD_INPUT_XPATH)).sendKeys(password);
    }

    public void submit() {
        webdriver.findElement(By.className(SUBMIT_BUTTON_CLASS)).click();
    }

    public String errorMessage() {
        return webdriver.findElement(By.className(ERROR_MESSAGE_CLASS)).getText();
    }
}
