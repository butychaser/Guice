package com.abyss.tech.concurrency.synchonize.block;

public class PairWrapperImpl2 extends PairWrapper
{

    @Override
    protected void increment ()
    {
        synchronized (this)
        {
            _pair.incrementX();
            _pair.incrementY();
        }
        store();
    }
}
