package com.abyss.tech.concurrency.interrupt;

public class MutexLockInterruptClient
{
    public static void main (String[] argv)
    {
        Thread _thread = new Thread(new MutexLockInterrupt(), "secondaryThread");
        _thread.start();
        System.out.println("secondaryThread");
        _thread.interrupt();
        System.out.println("secondaryThread");
    }
}
