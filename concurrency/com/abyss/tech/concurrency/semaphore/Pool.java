package com.abyss.tech.concurrency.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Pool<T>
{
   Lock _lock = new ReentrantLock();
   private final int _size;
   private volatile boolean[] _checkOut;
   private final List<T> _checkOutItems = new ArrayList<>();
   private Semaphore _available;
   public Pool(int size, Class<T> clazz)
   {
       _size = size;
       _checkOut = new boolean[_size];
       for(int i= 0;i<size;i++)
        try
        {
            _checkOutItems.add(clazz.newInstance());
        }
        catch (InstantiationException | IllegalAccessException e)
        {
            throw new RuntimeException();
        }
           _available = new Semaphore(_size , true);
           System.out.println(_available.availablePermits());
   }
   
   public T checkOut() throws InterruptedException
   {
       _lock.lock();
       calculateRemantPermit("before checkout", _available);
       _available.acquire();
       
       try{
       T t = getItem();
       calculateRemantPermit("after checkout",_available);
       return t; 
       }
       finally{
           _lock.unlock();
       }
   }
   private synchronized T getItem ()
{
    for(int i = 0;i<_size;i++)
        if(!_checkOut[i])
        {
            _checkOut[i] = true;
            return _checkOutItems.get(i);
        }
    return null;
}

public void checkIn(T item)
   {
    calculateRemantPermit("before checkin" , _available);   
    if (releaseItem(item))
           _available.release();
       calculateRemantPermit("after checkin",_available);
   }

private synchronized boolean releaseItem (T item) 
{
    int index = _checkOutItems.indexOf(item);
    if(index != -1)
    {
        _checkOut[index] = false;
        return true;    
    }
    return false;
}
private synchronized void calculateRemantPermit(String moment, Semaphore sema)
{
    int permit = 0;
    for(int i = 0 ;i<_size; i++)
        if(!_checkOut[i])
            ++permit;
    System.out.println("["+Thread.currentThread()+"]["+permit+"] permits still in the pool at "+moment);       
    System.out.println("["+Thread.currentThread()+"]["+sema.availablePermits()+"] permits still in the semaphore at "+moment);       
    printBooleanArray();
}

    private  void printBooleanArray()
    {
        System.out.print("{");
        for(int i = 0 ;i<_size; i++)
           System.out.print("["+_checkOut[i]+"]");
        System.out.println("}");
    }
}
