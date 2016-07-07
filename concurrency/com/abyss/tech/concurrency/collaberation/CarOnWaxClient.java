package com.abyss.tech.concurrency.collaberation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CarOnWaxClient
{

    public static void main (String[] args) throws InterruptedException
    {
        Car car = new Car();
        ExecutorService exec = Executors.newFixedThreadPool(2);
        exec.execute(new CarWaxOff(car));
        exec.execute(new CarWaxOn(car));
        TimeUnit.MILLISECONDS.sleep(5500);
        exec.shutdownNow();

    }

}
