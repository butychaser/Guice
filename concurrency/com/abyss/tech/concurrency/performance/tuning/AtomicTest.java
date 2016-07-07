package com.abyss.tech.concurrency.performance.tuning;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicTest extends Accumulator
{
    {id = "Atmoic";}
    private final AtomicInteger _index = new AtomicInteger(0);
    private final AtomicLong _value = new AtomicLong(0);
    @Override
    protected void accumulate ()
    {
          _value.getAndAdd(preload[_index.getAndIncrement()]);
          _index.incrementAndGet();
          
        if(_index.get()>=SIZE-10) 
        {
            _index.set(0);
        }

    }
    @Override
    protected long read ()
    {
        return _value.get();
    }

}
