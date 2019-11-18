package com.github.automatedowl.examples.tests;

import com.github.automatedowl.tools.SeleniumDownloadKPI;
import org.testng.annotations.Test;

public class TestingmindTests extends TestingmindTestCase {

    @Test
    void firstTest() throws InterruptedException {

        // Navigate to URL.
        getDriver().get(testingMindPage.getTestingMindPage().getURL());

        // Type 'Hello World' to text box.
        testingMindPage.getTestingMindPage().
                getTextBox().sendKeys("Hello from First Thread using TestNG mechanism");

        // Wait before closing browser..
        waitBeforeClosingBrowser();
    }

    @Test
    void secondTest() throws InterruptedException {

        // Navigate to URL.
        getDriver().get(testingMindPage.getTestingMindPage().getURL());

        // Type 'Hello World' to text box.
        testingMindPage.getTestingMindPage().
                getTextBox().sendKeys("Hello from Second Thread using TestNG mechanism");

        // Wait before closing browser..
        waitBeforeClosingBrowser();
    }

    @Test
    void thirdTest() throws InterruptedException {

        // Navigate to URL.
        getDriver().get(testingMindPage.getTestingMindPage().getURL());

        // Type 'Hello World' to text box.
        testingMindPage.getTestingMindPage().
                getTextBox().sendKeys("Hello from Third Thread using TestNG mechanism");

        // Wait before closing browser..
        waitBeforeClosingBrowser();
    }

    @Test
    void fourthTest() throws InterruptedException {

        // Navigate to URL.
        getDriver().get(testingMindPage.getTestingMindPage().getURL());

        // Type 'Hello World' to text box.
        testingMindPage.getTestingMindPage().
                getTextBox().sendKeys("Hello from Fourth Thread using TestNG mechanism");

        // Wait before closing browser..
        waitBeforeClosingBrowser();
    }

    @Test
    void fifthTest() throws InterruptedException {

        // Navigate to URL.
        getDriver().get(testingMindPage.getTestingMindPage().getURL());

        // Type 'Hello World' to text box.
        testingMindPage.getTestingMindPage().
                getTextBox().sendKeys("Hello from Fifth Thread using TestNG mechanism");

        // Wait before closing browser..
        waitBeforeClosingBrowser();
    }
}
