package com.abyss.tech.concurrency.performance.tuning;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Accumulator
{
    public static int              _globalCounter = 0;
    protected static StringBuilder aaa            = new StringBuilder("abc");
    public static long             cycles         = 50000L;
    protected final static int     N              = 4;
    protected CyclicBarrier        _barrier       = new CyclicBarrier(N * 2 + 2);
    public static ExecutorService  _executor      = Executors.newFixedThreadPool(N * 2 + 1);
    protected long                 duration       = 0;
    protected volatile int         index          = 0;
    protected volatile long        value          = 0;
    protected String               id             = "Error";
    protected static int           SIZE           = 100000;
    protected static int           preload[]      = new int[SIZE];
    static
    {
        for (int i = 0; i < SIZE; i++)
        {
            Random ran = new Random(47);
            preload[i] = ran.nextInt();
        }
    }

    protected abstract void accumulate ();

    protected abstract long read ();

    private class Modifier implements Runnable
    {
        public void run ()
        {
            for (long i = 0; i < cycles; i++)
                accumulate();
            awaitWrapper();

        }
    }

    private class Reader implements Runnable
    {
        public void run ()
        {
            for (long i = 0; i < cycles; i++)
                read();
            awaitWrapper();

        }
    }

    private class Guardian implements Runnable
    {
        public void run ()
        {

            if (id.equals("Baseline") || id.equals("NativeLock"))
            {
                System.out.println("Enter Guardian mode" + "[" + id + "]");
                awaitWrapper();
            }

        }
    }

    public void timedTest ()
    {
        long startTime = System.nanoTime();
        for (int i = 0; i < N; i++)
        {
            _executor.execute(new Modifier());
            _executor.execute(new Reader());
        }
        for (int j = 0; j < 1; j++)
        {
            _executor.execute(new Guardian());
        }

        System.out.println("[" + id + "][" + _barrier.getParties() + "]");
        awaitWrapper();
        System.out.println("[" + id + "]Global counter [" + Accumulator._globalCounter + "]");

        duration = System.nanoTime() - startTime;
        System.out.printf("%-13s: %13d \n", id, duration);
    }

    public static void report (Accumulator accu1, Accumulator accu2)
    {
        System.out.printf("%-13s/%-13s: %.2f \n", accu1.id, accu2.id, (double) accu1.duration
            / (double) accu2.duration);
    }

    private void awaitWrapper ()
    {

        try
        {
            ++_globalCounter;
            _barrier.await();
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (BrokenBarrierException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
