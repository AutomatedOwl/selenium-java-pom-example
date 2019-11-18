package com.github.automatedowl.examples.tests;


import org.testng.annotations.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestingmindTest extends TestingmindTestCase {

    private static final int NUMBER_OF_THREADS = 5;

    @Test
    void multiThreadTest() throws InterruptedException {

        // Create latch.
        CountDownLatch latch = new CountDownLatch(NUMBER_OF_THREADS);

        // Create executor.
        ExecutorService seleniumThreadsExecutor =
                Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i=0; i < NUMBER_OF_THREADS; i++) {
            seleniumThreadsExecutor.execute(new SeleniumThread("Selenium Thread " + i, latch));
        }
        latch.await(120, TimeUnit.SECONDS);
        seleniumThreadsExecutor.shutdown();
    }
}
