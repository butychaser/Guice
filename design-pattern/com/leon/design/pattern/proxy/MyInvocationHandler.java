package com.leon.design.pattern.proxy;

import java.lang.reflect.*;

public class MyInvocationHandler implements InvocationHandler
{

    @Override
    public Object invoke (Object proxy, Method method, Object[] args) throws Throwable
    {
        if (method.getName() == "sayHelloToWorld")
            System.out.println("Hello world!");

        return null;
    }

}
