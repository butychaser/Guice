package com.leon.design.pattern.delegate;

//public class Pros implements IPros<Pros>
public class AnotherPros<List extends IPros<List>> implements IPros<List>
{

    public void execCommand ()
    {
        System.out.println("Another Pros Execute command!");

    }

    @SuppressWarnings("unchecked")
    @Override
    public List collectResult ()
    {
        System.out.println("Another Pros Collect result!");
        return (List) this;

    }

    public String toString ()
    {
        return "This is a Another.";
    }

}