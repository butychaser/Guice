package com.abyss.tech.concurrency.interrupt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexLockInterrupt implements Runnable
{
    public MutexLockInterrupt ()
    {
        _lock.lock();
    }

    public void f ()
    {
        try
        {
            System.out.println(Thread.currentThread());
            _lock.lockInterruptibly();
            System.out.println("no expectation to be there");
        }
        catch (InterruptedException e)
        {
            System.out.println("Interrupted from lock acquisition f()");
        }
        System.out.println("exit of method f()");
    }

    private final Lock _lock = new ReentrantLock();

    @Override
    public void run ()
    {
        f();

    }
}
