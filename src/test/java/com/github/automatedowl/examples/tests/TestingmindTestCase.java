package com.github.automatedowl.examples.tests;

import java.util.logging.Logger;

import com.github.automatedowl.examples.drivers.ThreadLocalDriver;
import com.github.automatedowl.examples.pages.TestingMindPageThreadLocal;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestingmindTestCase {

    protected ThreadLocalDriver threadLocalDriver;
    protected Logger logger = Logger.getGlobal();

    // Define Page object for site88 web host.
    protected TestingMindPageThreadLocal testingMindPage;

    // Define timeout before closing browser after test.
    protected final int BROWSER_WAIT_MILLISECONDS = 4000;

    /////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////// TestNG Methods //////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////

    @BeforeMethod
    void setTestConfiguration() {
        logger.info("Setting up TestingmindTests..");
        threadLocalDriver = new ThreadLocalDriver();
        testingMindPage = new TestingMindPageThreadLocal(getDriver());
    }

    @AfterMethod
    void closeBrowser() {
        logger.info("Tearing down TestingmindTests..");
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
