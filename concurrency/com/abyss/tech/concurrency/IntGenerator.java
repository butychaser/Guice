package com.abyss.tech.concurrency;

public abstract class IntGenerator
{
    private volatile boolean _cancel = false;

    protected void cancel ()
    {
        _cancel = true;
    }

    protected boolean isCancel ()
    {
        return _cancel;
    }

    public abstract int next ();
}
