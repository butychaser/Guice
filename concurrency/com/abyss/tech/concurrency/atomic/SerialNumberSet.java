package com.abyss.tech.concurrency.atomic;

public class SerialNumberSet
{

    public SerialNumberSet (int size)
    {
        _numbers = new int[size];
        _size = size;
    }

    public synchronized boolean contain (int candidateInt)
    {
        for (int i = 0; i < _length; i++)
        {

            if (candidateInt == _numbers[i])
            {
                System.out.println("Current thread id : " + Thread.currentThread() + "=========== "
                    + i + "contain==========" + _numbers[i]);
                return true;
            }
        }
        return false;
    }

    public synchronized void add (int candidateInt)
    {
        _numbers[_length] = candidateInt;
        _length = ++_length % _size;
        System.out.println("Current thread id : " + Thread.currentThread() + "=========== "
            + _length + " ADD==========" + candidateInt);
    }

    private int         _length;
    private final int   _size;

    private final int[] _numbers;
}
