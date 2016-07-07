package exams.design.pattern.closure;

public class Callee1 implements Incrementable
{
    private int i = 0;

    @Override
    public void increase ()
    {
        System.out.println("Caller1 increase i to " + (++i));
    }
}
