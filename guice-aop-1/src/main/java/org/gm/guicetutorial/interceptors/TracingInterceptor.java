package org.gm.guicetutorial.interceptors;

import java.util.Arrays;

import org.aopalliance.intercept.*;

public class TracingInterceptor implements MethodInterceptor
{

    @Override
    public Object invoke (MethodInvocation invocation) throws Throwable
    {

        long start = System.nanoTime();

        try
        {
            return invocation.proceed();

        }
        finally
        {
            System.out.println(String.format(
                "Invocation of class method %s() with parameters %s took %.1f ms.",
                invocation.getMethod().getName(),
                Arrays.toString(invocation.getArguments()),
                (System.nanoTime() - start) / 1000000.0));
        }
    }

}
