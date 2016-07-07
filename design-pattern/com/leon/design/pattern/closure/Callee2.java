package com.leon.design.pattern.closure;

public class Callee2
{
    private int i = 0;

    public void increase ()
    {
        doSomethingDiff();
        i++;
        System.out.println("callee2's integer value is " + i);
    }

    public void doSomethingDiff ()
    {
        Closure closu = new Closure();
    }

    public Incrementable returnClosure ()
    {
        return new Closure();
    }

    class Closure implements Incrementable
    {
        @Override
        public void increase ()
        {
            //Magic wand waving
            Callee2.this.increase();
        }

    }

}
