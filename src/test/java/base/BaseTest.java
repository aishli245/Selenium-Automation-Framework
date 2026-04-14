package base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;
import utils.ScreenshotUtil;

public class BaseTest {

    protected WebDriver driver;
    ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void setup(Method method) {

        // Initialize report
        extent = ExtentManager.getReportInstance();
        test = extent.createTest(method.getName());

        // Launch browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void teardown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            String path = ScreenshotUtil.captureScreenshot(driver, result.getName());
            test.fail("Test Failed").addScreenCaptureFromPath(path);
        } 
        else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        }

        extent.flush();
        driver.quit();
    }
}