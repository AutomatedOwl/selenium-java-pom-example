package com.github.automatedowl.examples.drivers;

import com.google.inject.AbstractModule;
import org.apache.tika.utils.SystemUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Guice configuration module for WebDriver object.
 */
public class DriverModule extends AbstractModule {

    // Define String of chromedriver system property.
    private static final String CHROMEDRIVER_SYSTEM_PROPERTY =
            "webdriver.chrome.driver";

    /** Configure method. It binds a selected type of BrowserDriver. */
    protected synchronized void configure() {

        // Set Chromedriver executable path.
        setChromedriverPath();

        // Bind WebDriver object to ChromeDriver.
        bind(WebDriver.class).toInstance(new ChromeDriver());
    }

    private void setChromedriverPath() {
        System.setProperty(CHROMEDRIVER_SYSTEM_PROPERTY, getChromedriverPath());
    }

    public static String getChromedriverPath() {
        if (SystemUtils.IS_OS_WINDOWS) {
          return System.getProperty("user.dir")
                  + "/src/main/java/com/github/automatedowl" +
                  "/examples/drivers/executable/chromedriver.exe";
        }
        return System.getProperty("user.dir")
                + "/src/main/java/com/github/automatedowl" +
                "/examples/drivers/executable/chromedriver";
    }
}
