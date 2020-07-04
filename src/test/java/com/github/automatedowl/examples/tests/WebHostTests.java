package com.github.automatedowl.examples.tests;

import org.testng.annotations.Test;

public class WebHostTests extends WebHostTestCase {

    @Test
    public void site88Test() throws InterruptedException {

        // Navigate to URL.
        getDriver().get(site88Page.getSite88Page().getURL());

        // Type 'Hello World' to text box.
        site88Page.getSite88Page().getTextBox().sendKeys("Hello World Java");

        // Wait before closing browser..
        waitBeforeClosingBrowser();
    }
}
