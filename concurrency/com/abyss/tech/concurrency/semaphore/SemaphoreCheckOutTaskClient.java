package com.abyss.tech.concurrency.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SemaphoreCheckOutTaskClient
{
    public static int SIZE = 3;
    public static void main (String[] args) throws Throwable
    {
        Pool<Fat> pool = new Pool<>(SIZE,Fat.class);
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 0;i<SIZE;i++)
        executor.execute(new CheckOutTask<Fat>(pool));
//        List<Fat> fatList = new ArrayList<>();
//        fatList.add(pool.checkOut());
//        pool.checkOut();
        
        Future<?> retVal = executor.submit(
            new Runnable(){
                public void run()
                {
                    try
                    {
                        pool.checkOut();
                    }
                    catch (InterruptedException e)
                    {
                        // TODO Auto-generated catch block
                        System.out.println("checkOut Interrupted");
                    } 
                }
            });
          
        //retVal.cancel(true);
        executor.shutdown();
        

    }

}
