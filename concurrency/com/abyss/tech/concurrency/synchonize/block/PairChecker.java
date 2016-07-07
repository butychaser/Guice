package com.abyss.tech.concurrency.synchonize.block;

public class PairChecker implements Runnable
{
    public PairChecker (PairWrapper pair)
    {
        _pair = pair;
    }

    @Override
    public void run ()
    {
        while (true)
        {
            _pair.performanceCounter.incrementAndGet();
            _pair.getPair().checkPair();

        }
    }

    private final PairWrapper _pair;
}
