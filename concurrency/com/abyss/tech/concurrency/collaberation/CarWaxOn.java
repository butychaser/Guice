package com.abyss.tech.concurrency.collaberation;

import java.util.concurrent.TimeUnit;

public class CarWaxOn implements Runnable
{
    
    
    @Override
    public void run ()
    {
        try
        {
        while(!Thread.interrupted())
        {
        
            TimeUnit.MILLISECONDS.sleep(500);
            _car.waxOn();
            _car.waitforWaxOff();
        }  }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            System.out.println("WaxOn is interrupted by shutdownNow()");
        }

      
        System.out.println("CarWaxOn exit due to a exector shutdown!");
    }
    CarWaxOn(Car car)
    {
        _car = car;
    }
    private final Car _car;
}
