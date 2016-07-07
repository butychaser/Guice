package com.abyss.tech.concurrency.performance.tuning;

public class Baseline extends Accumulator
{
    {
        id = "Baseline";
    }
    public Baseline ()
    {
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void accumulate ()
    {
       value += preload[index++];
       if(index >=SIZE-2) index = 0;
    }

    @Override
    protected long read ()
    {
        return value;

    }

}
