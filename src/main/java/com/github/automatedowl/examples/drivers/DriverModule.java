package com.github.automatedowl.examples.drivers;

import com.github.automatedowl.tools.SeleniumDownloadKPI;
import com.google.inject.AbstractModule;
import org.openqa.selenium.WebDriver;
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

        ChromeOptions chromeOptions =
                SeleniumDownloadKPI.generateDownloadFolderCapability("/tmp/mounted");

        // Bind WebDriver object to ChromeDriver.
        try {
            bind(WebDriver.class).toInstance(new RemoteWebDriver(
                    new URL("http://10.0.0.20:31300/wd/hub"), chromeOptions));
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
