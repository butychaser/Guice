package com.abyss.tech.concurrency.synchonize.block;

public class PairWrapperImpl1 extends PairWrapper
{
    @Override
    protected synchronized void increment ()
    {
        _pair.incrementX();
        _pair.incrementY();
        store();
    }
}
