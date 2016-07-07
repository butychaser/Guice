package exams.design.pattern.closure;

public class Caller
{
    private final Incrementable _incrementable;

    Caller (Incrementable incrementable)
    {
        _incrementable = incrementable;
    }

    void fire ()
    {
        _incrementable.increase();
    }
}
