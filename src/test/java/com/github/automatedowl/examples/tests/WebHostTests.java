package com.github.automatedowl.examples.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebHostTests extends WebHostTestCase {


    @Test
    public void basicNavBarButtonsTest() throws InterruptedException {

        // Navigate to URL.
        getDriver().get(site88Page.getSite88Page().getURL());

        // iterate each button in the nav bar,
        // click on it and perform 2 seconds delay between each click
        for (int x = 0; x < site88Page.getSite88Page().getNavBarLinks().size(); x++) {

            List<WebElement> navLinks = site88Page.getSite88Page().getNavBarLinks();
            WebElement client = navLinks.get(x);
            client.click();
            twoSecondsDelay();
        }

        // Wait before closing browser..
        waitBeforeClosingBrowser();

    }

    }
