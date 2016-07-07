package com.abyss.tech.concurrency.semaphore;

public class Fat
{
    private volatile double d;
    private static int counter = 0;
    private final int id = counter++;
    Fat()
    {
        for(int i =0 ;i<10000; i++)
            d += (Math.E + Math.PI)/2;
    }
 public void operation(){System.out.println(this);}
 public String toString(){ return (id+" "+d);};
}
