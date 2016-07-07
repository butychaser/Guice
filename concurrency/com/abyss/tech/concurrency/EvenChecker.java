package com.abyss.tech.concurrency;

public class EvenChecker implements Runnable
{
    public EvenChecker (IntGenerator intGenerator)
    {
        _intGenerator = intGenerator;
    }

    public void validate ()
    {
        Thread t = Thread.currentThread();
        System.out.println(" Thread id: " + t);
        while (!_intGenerator.isCancel())
        {
            int value = _intGenerator.next();
            if (value % 2 != 0)
            {

                System.out.println(" Mutual exclusion is broken [" + value + "] Thread id: " + t);
                _intGenerator.cancel();
            }
            //System.out.println(" Mutual exclusion is NOT broken [" + value + "] Thread id: " + t);
        }
    }

    private final IntGenerator _intGenerator;

    @Override
    public void run ()
    {
        validate();
    }
}
