package com.abyss.tech.concurrency.synchonize.block;

import java.util.concurrent.TimeUnit;

public class PairWrapperClient
{

    public static void main (String[] args)
    {
        PairWrapper wrapper1 = new PairWrapperImpl1();
        PairWrapper wrapper2 = new PairWrapperImpl2();

        PairManipulator pairM1 = new PairManipulator(wrapper1);
        PairManipulator pairM2 = new PairManipulator(wrapper2);

        PairChecker pairC1 = new PairChecker(wrapper1);
        PairChecker pairC2 = new PairChecker(wrapper2);

        /*        ExecutorService executor = Executors.newCachedThreadPool();
                executor.execute(pairM1);
                executor.execute(pairM2);
                executor.execute(pairC1);
                executor.execute(pairC2);*/
        Thread pairM1T = new Thread(pairM1, "pairM1");
        Thread pairM2T = new Thread(pairM2, "pairM2");
        Thread pairC1T = new Thread(pairC1, "pairC1");
        Thread pairC2T = new Thread(pairC2, "pairC2");

        pairM1T.start();
        pairM2T.start();
        pairC1T.start();
        pairC2T.start();

        try
        {
            TimeUnit.MILLISECONDS.sleep(5000);
        }
        catch (InterruptedException i)
        {
        }
        System.out.println(pairM1 + " " + pairM2);
        //executor.shutdown();
        System.exit(0);
    }
}
