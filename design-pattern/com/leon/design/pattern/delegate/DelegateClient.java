package com.leon.design.pattern.delegate;

public class DelegateClient<T>
{
    public static void main (String[] args)
    {
        IPros<? extends IPros<?>> pros = new Pros();
        Mer<? extends IPros<?>> mer = new Mer<>(pros);
        mer.execCommandByDelegate();
        System.out.println(mer.collectResultByDelegate());

        IPros<? extends IPros<?>> anopros = new AnotherPros<>();
        mer = new Mer<>(anopros);
        mer.execCommandByDelegate();
        System.out.println(mer.collectResultByDelegate());
    }
}
