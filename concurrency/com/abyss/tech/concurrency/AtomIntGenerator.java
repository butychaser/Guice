package com.abyss.tech.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtomIntGenerator extends IntGenerator
{
    private int  _incrementInt = 0;
    private Lock _lock         = new ReentrantLock();

    @Override
    public int next ()
    {
        //_lock.lock();
        try
        {
            ++_incrementInt;
            ++_incrementInt;
            return _incrementInt;
        }
        finally
        {
          //  _lock.unlock();
        }
    }
}
