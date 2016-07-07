package exams.design.pattern.closure;

public class Callee2
{
    private int i = 0;

    public void increase ()
    {
        System.out.println("Callee2 increase i " + (++i));
    }

    public Incrementable returnInnerClousure ()
    {
        return new Closure();
    }

    class Closure implements Incrementable
    {
        @Override
        public void increase ()
        {
            System.out.println("Caller2 Closure increase i " + (++i));
            Callee2.this.increase();
        }

    }
}
