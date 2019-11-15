package com.github.automatedowl.examples.pages;

import org.openqa.selenium.WebDriver;

public class TestingMindPageThreadLocal {

    private static ThreadLocal<TestingMindPage> site88Page = new ThreadLocal<>();

    public TestingMindPageThreadLocal(WebDriver driver) {
        site88Page.set(new TestingMindPage(driver));
    }

    public TestingMindPage getTestingMindPage() {
        return this.site88Page.get();
    }
}
