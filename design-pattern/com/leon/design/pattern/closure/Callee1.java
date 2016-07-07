package com.leon.design.pattern.closure;

public class Callee1 implements Incrementable
{
    private int i = 0;

    @Override
    public void increase ()
    {
        i++;
        System.out.println("Callee1's integer value is " + i);
    }
}
