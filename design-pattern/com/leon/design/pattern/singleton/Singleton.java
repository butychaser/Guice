package com.leon.design.pattern.singleton;

public class Singleton {
    static int _atom = 0;

    private Singleton (int atom)
    {
        _atom = atom;
    }

    public static Singleton getIntance ()
    {
        return _instance;
    }

    public void outputAtomValue ()
    {
        System.out.println(_atom);
    }

    private final static Singleton _instance = new Singleton(++_atom);
}
