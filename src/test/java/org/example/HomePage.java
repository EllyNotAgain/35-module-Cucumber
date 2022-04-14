package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public record HomePage(WebDriver webdriver) {
    private static final String LOGIN_BUTTON_CLASS = "header__login_button";
    private static final String PROFILE_LINK_CLASS = "homepage-auth__links-profile";

    public void openHomePage(String url) {
        webdriver.get(url);
    }

    public void openLoginPage() {
        webdriver.findElement(By.className(LOGIN_BUTTON_CLASS)).click();
    }

    public void clickProfileLink() {
        (new WebDriverWait(webdriver, Duration.ofSeconds(30)))
                .until(ExpectedConditions.elementToBeClickable(By.className(PROFILE_LINK_CLASS)));
        webdriver.findElement(By.className(PROFILE_LINK_CLASS)).click();
    }
}
