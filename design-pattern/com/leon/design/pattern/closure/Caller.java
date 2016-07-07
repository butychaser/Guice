package com.leon.design.pattern.closure;

public class Caller
{
    private Incrementable _myIncrementable;

    public Caller (Incrementable myIncrementable)
    {
        _myIncrementable = myIncrementable;
    }

    public void fire ()
    {
        _myIncrementable.increase();
    }
}
