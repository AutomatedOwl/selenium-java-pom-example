package com.github.automatedowl.examples.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

import com.github.automatedowl.examples.pages.TestingMindPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumThread implements Runnable {

    private final Logger LOGGER = Logger.getLogger(SeleniumThread.class.getName());
    private CountDownLatch latch;
    private Thread thread;
    private String threadName;
    private WebDriver driver;
    
    public SeleniumThread(String name, CountDownLatch latch) {
        System.out.println("Creating " + name);
        this.latch = latch;
        this.threadName = name;
    }

    public void run() {

        System.out.println("Running " + threadName);
        try {
            driver = new RemoteWebDriver(
                    new URL("http://10.0.0.20:31112/wd/hub"), new ChromeOptions());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        TestingMindPage testingMindPage = new TestingMindPage(driver);

        // Navigate to URL.
        driver.get(testingMindPage.getURL());

        // Type 'Hello World' to text box.
        testingMindPage.getTextBox().
                sendKeys("Hello from " + threadName + " Using Self-Developed Java Code");

        // Wait before closing browser..
        try {
            waitBeforeClosingBrowser();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Perform countDown.
        latch.countDown();
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

    protected void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,
                60);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitForAttributeChange(
            WebElement element, String attribute, String value) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    protected void waitForElementText(WebElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    protected void waitBeforeClosingBrowser() throws InterruptedException {
        Thread.sleep(90000);
    }
}