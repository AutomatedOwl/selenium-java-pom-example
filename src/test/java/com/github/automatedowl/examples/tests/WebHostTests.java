package com.github.automatedowl.examples.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WebHostTests extends WebHostTestCase {

    @Test
    public void site88Test() throws InterruptedException {

        System.out.println("Running site88Test");

        System.out.println(getDriver().equals(null));

        System.out.println(site88Page.equals(null));

        System.out.println(site88Page.getSite88Page().equals(null));

        // Navigate to URL.
        getDriver().get(site88Page.getSite88Page().getURL());

        // Type 'Hello World' to text box.
        site88Page.getSite88Page().getTextBox().sendKeys("Hello World");

        // Wait before closing browser..
        waitBeforeClosingBrowser();
    }
/*
    @Test
    public void failureTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("TEST 2");
        }
        // Assert failure.
        Assert.assertTrue(false);
    }*/

    @Test(enabled = false)
    public void failureTwoTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("TEST 2");
        }
        // Assert failure.
        Assert.assertTrue(false);
    }
}
