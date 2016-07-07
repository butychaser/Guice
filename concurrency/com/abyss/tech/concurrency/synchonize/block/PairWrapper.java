package com.abyss.tech.concurrency.synchonize.block;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class PairWrapper
{
    public synchronized Pair getPair ()
    {
        //System.out.println(Thread.currentThread() + " " + _pair.getX() + " " + _pair.getY());
        return new Pair(_pair.getX(), _pair.getY());
    }

    public void store ()
    {
        _pairContainer.add(getPair());
        try
        {
            TimeUnit.MILLISECONDS.sleep(50);
        }
        catch (InterruptedException i)
        {
        }
    }

    public String toString ()
    {
        return "x=" + _pair.getX() + " y= " + _pair.getY();
    }

    protected void update ()
    {
        increment();
        store();
    }

    protected abstract void increment ();

    protected final Pair _pair              = new Pair();
    AtomicInteger        performanceCounter = new AtomicInteger();
    List<Pair>           _pairContainer     = Collections.synchronizedList(new ArrayList<Pair>());
    protected Lock       _lock              = new ReentrantLock();
}
