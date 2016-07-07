package com.leon.design.pattern.delegate;

public class AnotherPros<T extends IPros<T>> implements IPros<T>
{

    public void execCommand ()
    {
        System.out.println("Another Pros Execute command!");

    }

    @SuppressWarnings("unchecked")
    @Override
    public T collectResult ()
    {
        System.out.println("Another Pros Collect result!");
        return (T) this;

    }

    @Override
    public String toString ()
    {
        return "Another Pros Collect result!";
    }

}
