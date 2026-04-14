package tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.*;

public class PurchaseTest extends BaseTest {

    @Test
    public void purchaseTest() {

        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "secret_sauce");

        ProductsPage pp = new ProductsPage(driver);
        pp.addProduct();
        pp.goToCart();

        CheckoutPage cp = new CheckoutPage(driver);
        cp.checkout();
    }
}