package com.abyss.tech.concurrency.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SerialNumberChecker
{
    public static class SerialNumberTask implements Runnable
    {
        public SerialNumberTask (SerialNumberSet serialNumberPool)
        {
            _serialNumberPool = serialNumberPool;
        }

        public void run ()
        {
            System.out.println("Thread of Id :" + Thread.currentThread());
            int serialNumber = 0;
            while (true)
            {
                serialNumber = SerialNumberGenerator.generateSerialNumber();
                if (!_serialNumberPool.contain(serialNumber))
                {
                    System.out.println("Thread of Id :" + Thread.currentThread()
                        + " with seriaNumber  " + serialNumber);
                    _serialNumberPool.add(serialNumber);
                }
                else
                {
                    System.out.println("Duplicated serial number shows up :" + serialNumber);
                    System.exit(0);
                }
            }
        }

        final SerialNumberSet _serialNumberPool;
    }

    public static void main (String[] args)
    {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 1000; i++)
        {
            //new Thread(new EvenChecker(generator)).start();
            exec.execute(new SerialNumberTask(serialNumberPool));
        }
        exec.shutdown();
    }

    static SerialNumberSet serialNumberPool = new SerialNumberSet(10000);
}
