package com.github.automatedowl.examples.pages;

import org.openqa.selenium.WebDriver;

public class Site88PageThreadLocal {

    private static ThreadLocal<Site88Page> site88Page = new ThreadLocal<>();

    public Site88PageThreadLocal(WebDriver driver) {
        site88Page.set(new Site88Page(driver));
    }

    public Site88Page getSite88Page() {
        return this.site88Page.get();
    }
}
