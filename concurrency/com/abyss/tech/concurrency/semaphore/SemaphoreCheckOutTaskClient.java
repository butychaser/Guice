package com.abyss.tech.concurrency.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

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

        CompletableFuture<?> retVal1 = CompletableFuture.supplyAsync(()-> {
            try
            {
                return pool.checkOut();
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                System.out.println("checkOut Interrupted");
            }
            return null;
        }, executor);
          
        //retVal.cancel(true);
        executor.shutdown();
        

    }

}
