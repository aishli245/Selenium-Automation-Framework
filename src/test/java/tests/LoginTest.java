package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

        test.info("Starting Login Test");   // 🔥 log step

        LoginPage lp = new LoginPage(driver);
        
        test.info("Entering username and password");
        lp.login("standard_user", "secret_sauce");

        test.pass("Login Successful");   // 🔥 mark pass
    }
}