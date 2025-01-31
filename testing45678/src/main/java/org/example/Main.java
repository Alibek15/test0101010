package org.example;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.net.URL;
import java.util.Map;
import org.testng.Assert;
import io.restassured.response.Response;

public class Main {
    public static final String USERNAME = "bsuser_qIpZGB";
    public static final String AUTOMATE_KEY = "NAYd5vz3nuemhrC7KWmy";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
//    private static final Logger logger = LogManager.getLogger(Main.class);
//    private WebDriver driver;
//    private ExtentReports extent;
//    private ExtentTest test;
//
//    @BeforeSuite
//    public void setupSuite() {
//        logger.info("Setting up test suite.");
//
//        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//        logger.info("Extent Report initialized.");
//    }
//
//    @BeforeClass
//    public void setupClass() {
//        logger.info("Setting up WebDriver.");
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Desktop\\chromedriver.exe");
//        driver = new ChromeDriver();
//        logger.info("WebDriver initialized.");
//    }
//
//    @Test
//    public void testShopKZHomePage() {
//        logger.info("Starting testShopKZHomePage test.");
//        test = extent.createTest("testShopKZHomePage", "Validates Shop.KZ home page title.");
//        driver.get("https://shop.kz/");
//        logger.info("Navigated to Shop.KZ home page.");
//
//        String title = driver.getTitle();
//        logger.info("Page title: " + title);
//        Assert.assertTrue(title.contains("Интернет-магазин Белый Ветер"), "Title does not contain 'Интернет-магазин Белый Ветер'");
//        logger.info("testShopKZHomePage test passed.");
//    }
//
//    @AfterMethod
//    public void tearDownMethod(ITestResult result) {
//        if (result.getStatus() == ITestResult.FAILURE) {
//            logger.error("Test failed: " + result.getName());
//            logger.error("Error: " + result.getThrowable());
//            test.fail("Test failed: " + result.getThrowable());
//
//            // Take screenshot on failure
//            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            String screenshotPath = "screenshots/" + result.getName() + ".png";
//            try {
//                FileUtils.copyFile(screenshot, new File(screenshotPath));
//                test.addScreenCaptureFromPath(screenshotPath);
//                logger.info("Screenshot captured: " + screenshotPath);
//            } catch (IOException e) {
//                logger.error("Failed to save screenshot: " + e.getMessage());
//            }
//        } else if (result.getStatus() == ITestResult.SUCCESS) {
//            logger.info("Test passed: " + result.getName());
//            test.pass("Test passed.");
//        }
//    }
//
//    @AfterClass
//    public void tearDownClass() {
//        logger.info("Closing WebDriver.");
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//
//    @AfterSuite
//    public void tearDownSuite() {
//        logger.info("Flushing Extent Report.");
//        if (extent != null) {
//            extent.flush();
//        }
//    }


    @Test
    public void testGetRequest() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        Response response =  RestAssured.get(url);

        // status code is 200
        Assert.assertEquals(response.getStatusCode(), 200, "Status code should be 200");



        String title = response.jsonPath().getString("title");
        Assert.assertNotNull(title, "Title should not be null");

        System.out.println("API Test Passed. Title: " + title);
    }

    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.openTelemetry.enabled", "false");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", "chrome");
        options.setCapability("browserVersion", "latest");
        options.setCapability("platformName", "Windows 10");


        options.setCapability("bstack:options", Map.of(
                "os", "Windows",
                "osVersion", "10",
                "sessionName", "MyTestSession"
        ));

        WebDriver driver = new RemoteWebDriver(new URL(URL), options);
        driver.get("https://www.google.com");
        System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }
}