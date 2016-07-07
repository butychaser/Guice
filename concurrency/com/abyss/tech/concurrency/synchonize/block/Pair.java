package com.abyss.tech.concurrency.synchonize.block;

public class Pair
{
    public Pair ()
    {
        _x = 0;
        _y = 0;
    }

    public Pair (int x, int y)
    {
        _x = x;
        _y = y;
    }

    public void incrementX ()
    {
        ++_x;
    }

    public void incrementY ()
    {
        ++_y;
    }

    public int getX ()
    {
        return _x;
    }

    public int getY ()
    {
        return _y;
    }

    public void checkPair ()
    {

        if (_x != _y)
        {
            System.out.println(Thread.currentThread() + "checkPair " + _x + " " + _y);
            throw new RuntimeException("The pair is broken cuz x=" + _x + " y=" + _y);
        }
    }

    private int _x, _y;
}
