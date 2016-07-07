package com.abyss.tech.concurrency.performance.tuning;

public class SynchronizedAccumulator extends Accumulator
{
    {
        id = "SynchronizedAccumulator";
    }
    
    @Override
    protected synchronized void accumulate ()
    {
       value += preload[index++];
       if(index >=SIZE) index = 0;
    }

    @Override
    protected synchronized long read ()
    {
        return value;

    }

}


