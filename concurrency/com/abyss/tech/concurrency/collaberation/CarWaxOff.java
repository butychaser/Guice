package com.abyss.tech.concurrency.collaberation;

import java.util.concurrent.TimeUnit;

public class CarWaxOff implements Runnable
{
    private final Car _car;

    CarWaxOff (Car car)
    {
        _car = car;
    }

    @Override
    public void run ()
    {
        try
        {
            while (!Thread.interrupted())
            {
                // TODO Auto-generated method stub

                _car.waitforWaxOn();
                TimeUnit.MILLISECONDS.sleep(500);
                _car.waxOff();

            }
        }
        catch (InterruptedException e)
        {
            System.out.println("WaxOff is interrupted by shutdownNow()");
        }
        System.out.println("CarWaxOff exit due to a exector shutdown!");

    }
}
