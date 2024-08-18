package com.leon.design.pattern.delegate;

//public class AnotherPros<T extends IPros<T>> implements IPros<T>
public class Pros implements IPros<Pros>
{
    @Override
    public Pros collectResult ()
    {
        System.out.println("Pros one Collect result!");
        return this;
    }

    public void execCommand ()
    {
        System.out.println("Pros one Execute command!");
    }

    public String toString ()
    {
        return "This is a Pros.";
    }

}
