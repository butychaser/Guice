package com.leon.design.pattern.singleton;

public class SingletonClient
{

    /**
     * @param args
     */
    public static void main (String[] args)
    {
        Singleton one = Singleton.getIntance();
        one.outputAtomValue();
        System.out.println(one.hashCode());
        Singleton two = Singleton.getIntance();
        System.out.println(two.hashCode());
        one.outputAtomValue();
        System.out.println(one.hashCode());
        two.outputAtomValue();
        System.out.println(two.hashCode());
    }
}
