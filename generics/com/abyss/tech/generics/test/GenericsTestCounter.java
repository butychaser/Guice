package com.abyss.tech.generics.test;

public class GenericsTestCounter
{
    public static int __globalCounter  = 1;

    private int       _internalCounter = __globalCounter++;

    public GenericsTestCounter ()
    {

    }

    public String toString ()
    {
        System.out.printf(
            "GolbalCounter = %d , internalCounter = %d \n",
            __globalCounter,
            _internalCounter);
        return "GolbalCounter =" + __globalCounter + " , internalCounter =" + _internalCounter;

    }
}
