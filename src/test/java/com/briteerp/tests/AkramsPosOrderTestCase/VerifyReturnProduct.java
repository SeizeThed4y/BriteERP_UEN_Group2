package com.briteerp.tests.AkramsPosOrderTestCase;

import com.briteerp.pages.*;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.TestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyReturnProduct extends TestBase {
    public VerifyReturnProduct() {
        PageFactory.initElements(Driver.getDriver(), LoginPage.class);

    }

    @BeforeMethod(alwaysRun = true)
    public void st1() {
        new VerifyClickOrder();
        new EnvironmentPage();
        new POSHomePage();
        new HomePage();
        new OrderPage();
    }

    @Test
    public void VerifyReturn() throws InterruptedException {

        extentLogger = report.createTest("Verify the Orders's page");
        extentLogger.info("Selecting the environment");
        EnvironmentPage.selectEnvironment();
        extentLogger.info("Verifying the title contain Login");
        Assert.assertTrue(driver.getTitle().contains("Login"));
        extentLogger.info("Entering valid user credentials and click login");
        LoginPage.login();
        Thread.sleep(5000);
        extentLogger.info("Verifying the title contains Inbox");
        Assert.assertTrue(driver.getTitle().contains("Inbox"));
        extentLogger.info("Clicking the PointofSale module");
        HomePage.pointOfSaleElement.click();
        Thread.sleep(5000);
        extentLogger.info("Verifying the title contains Point of Sale");
        Assert.assertTrue(driver.getTitle().contains("Point of Sale"));
        extentLogger.info("Clicking the order on the orders");
        POSHomePage.ordersOrdersElement.click();
        Thread.sleep(5000);

        extentLogger.info("Clicking on the order list");
        OrderPage.Prodect0006.click();
        BrowserUtils.wait(5);

        extentLogger.info("Clicking on the ReturnProduct");
        OrderPage.ReturnProduct.click();
        BrowserUtils.wait(3);

    }

}