package com.abyss.tech.concurrency.performance.tuning;

public class AccumulatorClient
{
    static Baseline                baseline   = new Baseline();
    static SynchronizedAccumulator sync       = new SynchronizedAccumulator();
    static LockTest                lockTest   = new LockTest();
    static AtomicTest              atomicTest = new AtomicTest();

    public AccumulatorClient ()
    {
        // TODO Auto-generated constructor stub
    }

    public static void main (String[] args) throws InterruptedException
    {

        baseline.timedTest();
        lockTest.timedTest();
        sync.timedTest();

        //TimeUnit.SECONDS.sleep(2);
        //atomicTest.timedTest();

        //        System.out.println(baseline._barrier.hashCode());
        //        System.out.println(sync._barrier.hashCode());
        //        System.out.println(lockTest._barrier.hashCode());
        //        Accumulator.report(baseline, sync);
        //        Accumulator.report(sync, lockTest);

        Accumulator._executor.shutdown();

    }

}
