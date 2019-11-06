package com.github.automatedowl.examples.drivers;

import com.google.inject.AbstractModule;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Guice configuration module for WebDriver object.
 */
public class DriverModule extends AbstractModule {

    /** Configure method. It binds a selected type of BrowserDriver. */
    protected synchronized void configure() {

        // Set Chromedriver executable path.
        setChromedriverPath();


        // Bind WebDriver object to ChromeDriver.
        try {
            bind(WebDriver.class).toInstance(new RemoteWebDriver(
                    new URL("http://zalenium.elminda.com/wd/hub"), new ChromeOptions()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void setChromedriverPath() {
        //WebDriverManager.chromedriver().setup();
    }
}
