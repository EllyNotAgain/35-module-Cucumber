package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public record ProfilePage(WebDriver webdriver) {
    private static final String PROFILE_EMAIL_XPATH = "//input[@type='email']";

    public String profileEmail() {
        return  webdriver.findElement(By.xpath(PROFILE_EMAIL_XPATH)).getAttribute("value");
    }
}
