package com.github.automatedowl.examples;

import org.testng.annotations.Test;

public class WebHostTest extends WebHostTestCase {

    @Test
    public void site88Test() throws InterruptedException {

        // Navigate to URL.
        getDriver().get(site88Page.getURL());

        // Type 'Hello World' to text box.
        site88Page.getTextBox().sendKeys("Hello World");

        // Wait before closing browser.
        waitBeforeClosingBrowser();
    }
}
