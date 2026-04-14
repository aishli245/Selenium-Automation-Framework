package utils;

import java.io.File;
import org.openqa.selenium.*;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String testName) {

        String path = "screenshots/" + testName + ".png";

        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(path);
            FileUtils.copyFile(src, dest);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}