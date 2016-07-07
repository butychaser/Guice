package com.abyss.tech.generics.fundation;

public class BasicGenerator<T> implements Generator<T>
{

    public BasicGenerator (Class<T> type)
    {
        _type = type;
    }

    private final Class<T> _type;

    public static <T> BasicGenerator<T> create (Class<T> type)
    {
        return new BasicGenerator<T>(type);
    }

    @Override
    public T next ()
    {
        try
        {
            return _type.newInstance();
        }
        catch (InstantiationException | IllegalAccessException e)
        {
            return null;
        }
    }

}
