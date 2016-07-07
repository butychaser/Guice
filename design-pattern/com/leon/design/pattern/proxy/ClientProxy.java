package com.leon.design.pattern.proxy;

import java.lang.reflect.*;

public class ClientProxy
{
    public static void main (String[] args) throws InstantiationException, IllegalAccessException,
        IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
        SecurityException
    {
        InvocationHandler handler = new MyInvocationHandler();

        Class<?> proxyClass = Proxy.getProxyClass(
            IHelloworld.class.getClassLoader(),
            new Class[] {IHelloworld.class});

        Object proxyInstance = proxyClass
            .getConstructor(new Class[] {InvocationHandler.class})
            .newInstance(new Object[] {handler});
        ((IHelloworld) proxyInstance).sayHelloToWorld();

        //        IHelloworld f = (IHelloworld) Proxy.newProxyInstance(
        //            Helloworld.class.getClassLoader(),
        //            new Class[] {IHelloworld.class},
        //            handler);
        //        f.sayHelloToWorld();
    }
}
