package exams.design.pattern.closure;

public class ClosureClient
{

    /**
     * @param args
     */
    public static void main (String[] args)
    {
        Callee1 callee1 = new Callee1();
        Caller caller = new Caller(callee1);
        caller.fire();

        Callee2 callee2 = new Callee2();
        callee2.increase();
        Caller caller2 = new Caller(callee2.returnInnerClousure());
        caller2.fire();

    }

}
