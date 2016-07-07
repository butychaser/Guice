package com.leon.design.pattern.closure;

public class ClosureClient
{
    public static void main (String[] argv)
    {
        Callee1 callee1 = new Callee1();
        Caller caller1 = new Caller(callee1);
        caller1.fire();

        Callee2 callee2 = new Callee2();
        callee2.increase();
        Caller caller2 = new Caller(callee2.returnClosure());
        caller2.fire();
    }
}