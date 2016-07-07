package com.abyss.tech.concurrency.atomic;

import java.util.concurrent.locks.ReentrantLock;

public class SerialNumberGenerator
{
    private static volatile int                          _serialNumber = 0;

    private static final java.util.concurrent.locks.Lock _lock         = new ReentrantLock();

    public static int generateSerialNumber ()
    {
        _lock.lock();
        try
        {
            return ++_serialNumber;
        }
        finally
        {
            _lock.unlock();
        }
    }
}
