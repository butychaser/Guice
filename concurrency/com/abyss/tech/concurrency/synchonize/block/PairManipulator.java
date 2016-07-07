package com.abyss.tech.concurrency.synchonize.block;

public class PairManipulator implements Runnable
{
    public PairManipulator (PairWrapper pair)
    {
        _pair = pair;
    }

    @Override
    public void run ()
    {
        while (true)
        {
            //            if (_pair instanceof PairWrapperImpl2)
            //            {
            //                System.out.println(_pair.getClass());
            //                Thread.yield();
            //            }
            _pair.update();
        }
    }

    public String toString ()
    {
        return _pair.toString() + " " + _pair.performanceCounter.get();
    }

    private final PairWrapper _pair;

}
