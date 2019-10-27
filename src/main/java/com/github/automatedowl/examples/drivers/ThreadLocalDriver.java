package com.github.automatedowl.examples.drivers;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.openqa.selenium.WebDriver;

public class ThreadLocalDriver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public ThreadLocalDriver() {
        Injector injector = Guice.createInjector(new DriverModule());
        driver.set(injector.getInstance(WebDriver.class));
    }

    public WebDriver getDriver() {
        return this.driver.get();
    }
}
