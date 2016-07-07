package com.abyss.tech.concurrency.performance.tuning;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest extends Accumulator
{
    {
        id = "NativeLock";
    }
    public LockTest ()
    {
        // TODO Auto-generated constructor stub
    }
 private final Lock _lock = new ReentrantLock();
    @Override
    protected void accumulate ()
    {
        _lock.lock();
        try
        {
            value += preload[index++];
            if(index >=SIZE) index = 0; 
        }finally
        {
            _lock.unlock();
        }

    }

    @Override
    protected long read ()
    {
        _lock.lock();
        try
        {
            return value;
        }finally
        {
            _lock.unlock();
        }
    }

}
