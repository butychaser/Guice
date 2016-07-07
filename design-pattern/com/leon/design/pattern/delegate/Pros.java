package com.leon.design.pattern.delegate;

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

    @Override
    public String toString ()
    {
        return "Pros one Collect result!";
    }

}
