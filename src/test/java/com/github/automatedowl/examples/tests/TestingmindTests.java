package com.github.automatedowl.examples.tests;

import org.testng.annotations.Test;

public class TestingmindTests extends TestingmindTestCase {

    @Test
    public void site88Test() throws InterruptedException {

        // Navigate to URL.
        getDriver().get(site88Page.getSite88Page().getURL());

        // Type 'Hello World' to text box.
        site88Page.getSite88Page().getTextBox().sendKeys("Hello TestingMind !");

        // Wait before closing browser..
        waitBeforeClosingBrowser();
    }
}
