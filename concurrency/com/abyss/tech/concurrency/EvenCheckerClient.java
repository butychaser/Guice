package com.abyss.tech.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenCheckerClient
{

    public static void main (String[] args)
    {
        IntGenerator generator = new AtomIntGenerator();
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++)
        {
            //new Thread(new EvenChecker(generator)).start();
            exec.execute(new EvenChecker(generator));
        }
        exec.shutdown();
    }
}
