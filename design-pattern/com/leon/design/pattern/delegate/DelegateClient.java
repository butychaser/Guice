package com.leon.design.pattern.delegate;

public class DelegateClient<T>
{
    public static void main (String[] args)
    {
        IPros<String> pros = new ArbitraryPros();
        Mer<String> mer = new Mer<>(pros);
        mer.execCommandByDelegate();
        System.out.println(mer.collectResultByDelegate());

        IPros<? extends IPros<?>> anopros = new AnotherPros<>();
        Mer<? extends IPros<?>> mer2 = new Mer<>(anopros);
        mer2.execCommandByDelegate();
        System.out.println(mer2.collectResultByDelegate());

    }
}
