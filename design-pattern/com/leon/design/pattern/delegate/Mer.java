package com.leon.design.pattern.delegate;

public class Mer<T>
{
    final IPros<T> _delegate;

    Mer (IPros<T> pros)
    {
        _delegate = pros;
    }

    public void execCommandByDelegate ()
    {
        _delegate.execCommand();
    }

    public T collectResultByDelegate ()
    {
        return _delegate.collectResult();
    }
}
