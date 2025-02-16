package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ShopKz {
    WebDriver driver;

    @Given("I open the Shop.KZ website")
    public void openShopKZ() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://shop.kz/");
    }

    @Then("the page title should contain {string}")
    public void verifyTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Title verification failed!");
        driver.quit();
    }
}
