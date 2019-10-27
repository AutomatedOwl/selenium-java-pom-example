package com.github.automatedowl.examples.tests;

import java.util.logging.Logger;

import com.github.automatedowl.examples.drivers.ThreadLocalDriver;
import com.github.automatedowl.examples.pages.Site88PageThreadLocal;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public abstract class WebHostTestCase {

    protected ThreadLocalDriver threadLocalDriver;
    protected Logger logger = Logger.getGlobal();

    // Define Page object for site88 web host.
    protected Site88PageThreadLocal site88Page;

    // Define timeout before closing browser after test.
    protected final int BROWSER_WAIT_MILLISECONDS = 4000;

    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////// TestNG Methods //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////

    @BeforeMethod
    void setTestConfiguration() {
        logger.info("Setting up WebHostTests..");
        threadLocalDriver = new ThreadLocalDriver();
        site88Page = new Site88PageThreadLocal(getDriver());
    }

    @AfterMethod
    void closeBrowser() {
        logger.info("Tearing down WebHostTests..");
        getDriver().quit();
    }

    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////// Generic Methods /////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////

    protected void waitBeforeClosingBrowser() throws InterruptedException {
        Thread.sleep(BROWSER_WAIT_MILLISECONDS);
    }

    protected WebDriver getDriver() {
        return threadLocalDriver.getDriver();
    }
}
