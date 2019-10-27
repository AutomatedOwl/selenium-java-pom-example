package com.github.automatedowl.examples.drivers;

import com.google.inject.AbstractModule;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Guice configuration module for WebDriver object.
 */
public class DriverModule extends AbstractModule {

    /** Configure method. It binds a selected type of BrowserDriver. */
    protected synchronized void configure() {

        // Set Chromedriver executable path.
        setChromedriverPath();

        // Bind WebDriver object to ChromeDriver.
        bind(WebDriver.class).toInstance(new ChromeDriver());
    }

    private void setChromedriverPath() {
        WebDriverManager.chromedriver().setup();
    }
}
