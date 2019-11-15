package com.github.automatedowl.examples.tests;

import com.github.automatedowl.tools.SeleniumDownloadKPI;
import org.testng.annotations.Test;

public class TestingmindTests extends TestingmindTestCase {

    private SeleniumDownloadKPI seleniumDownloadKPI = new SeleniumDownloadKPI("/tmp/mounted");

    @Test
    void site88Test() throws InterruptedException {

        // Navigate to URL.
        getDriver().get(testingMindPage.getTestingMindPage().getURL());

        // Type 'Hello World' to text box.
        testingMindPage.getTestingMindPage().getTextBox().sendKeys("Hello TestingMind !");

        // Wait before closing browser..
        waitBeforeClosingBrowser();
    }

    @Test
    void downloadTest() throws InterruptedException {

        // Navigate to URL.
        getDriver().get(testingMindPage.getTestingMindPage().getURL());

        // Click on download link.
        seleniumDownloadKPI.fileDownloadKPI(testingMindPage.getTestingMindPage().getDownloadLink(),
                   "test-file", true);

        // Wait before closing browser..
        waitBeforeClosingBrowser();
    }
}
