package com.abyss.tech.concurrency.semaphore;

import java.util.concurrent.TimeUnit;

public class CheckOutTask<T> implements Runnable
{
    public final Pool<T> _pool;
    private static int counter = 0;
    private int id =counter++;
    CheckOutTask(Pool<T> pool)
    {
        _pool = pool;
    }
    @Override
    public void run ()
    {
        try
        {
            T item = _pool.checkOut();
            System.out.println(this+"check out "+item);
            TimeUnit.SECONDS.sleep(1);
            _pool.checkIn(item);
            System.out.println(this+"check in "+item);
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
    
    public String toString()
    {
        return "CheckOutTask "+id +" ";
    }

}
