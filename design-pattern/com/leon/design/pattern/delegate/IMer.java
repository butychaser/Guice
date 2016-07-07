package com.leon.design.pattern.delegate;

public interface IMer<T>
{
    void execCommandByDelegate ();

    public T collectResultByDelegate ();

}
