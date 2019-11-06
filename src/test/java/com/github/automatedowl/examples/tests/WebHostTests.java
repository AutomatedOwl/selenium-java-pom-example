package com.github.automatedowl.examples.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.BitSet;
import java.util.List;

public class WebHostTests extends WebHostTestCase {

 /*   @Test
    public void contactTest() throws InterruptedException {

        // Navigate to URL.
        getDriver().get(site88Page.getSite88Page().getURL());

        String expectedValue = "contant us at http://testjs.site88.net";

        site88Page.getSite88Page().getContact().click();

        WebElement content = getDriver().findElement(By.className("content"));

        String actualValue = content.getText();

        //Assert.assertEquals(expectedValue, actualValue);

        Assert.assertTrue(expectedValue.equals(actualValue),
                "actual content is not equal to expected one!");

        // Wait before closing browser..
        waitBeforeClosingBrowser();

    }

    @Test
    public void feedBackTest() throws InterruptedException {

        // Navigate to URL.
        getDriver().get(site88Page.getSite88Page().getURL());

        String expectedResult = "Thanks for your amazing feedback!";

        site88Page.getSite88Page().getTextBox().sendKeys("hadar");
        site88Page.getSite88Page().getSubmitButton().click();
        String actualResult = site88Page.getSite88Page().getTextAfterSubmit().getText();

        Assert.assertTrue(expectedResult.equals(actualResult),
                "actual content  after submission is not equal to expected one!");


        // Wait before closing browser..
        waitBeforeClosingBrowser();

    }*/


    @Test
    public void test3() throws InterruptedException {

        // Navigate to URL.
        getDriver().get(site88Page.getSite88Page().getURL());

       /* Thread.sleep(5000);
        getDriver().manage().window().maximize();
        site88Page.getSite88Page().getNavBarLinks().stream().forEach(link -> {
            try {
                performClickAndDelay(link, getDriver());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
*/
        //elementCount = site88Page.getSite88Page().getNavBarLinks().size();
        for (int x = 0; x < site88Page.getSite88Page().getNavBarLinks().size(); x++) {

            List<WebElement> navLinks = site88Page.getSite88Page().getNavBarLinks();
            WebElement client = navLinks.get(x);
            client.click();
            Thread.sleep(2000);
        }


        // Wait before closing browser..
        waitBeforeClosingBrowser();


    }


    }
