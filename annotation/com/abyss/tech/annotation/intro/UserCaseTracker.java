package com.abyss.tech.annotation.intro;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class UserCaseTracker
{

    public static void main (String[] args)
    {
        List<Integer> ids = Arrays.asList(
            new Integer(48),
            new Integer(49),
            new Integer(50),
            new Integer(51));
        Class<?> clazz = PasswordUtils.class;
        for (Method m : clazz.getDeclaredMethods())
        {
            UserCase u = m.getAnnotation(UserCase.class);
            if (u != null)
                System.out.println("id " + u.id() + " description " + u.description());
            else
                System.out.println("no annotation " + m.getName());
        }

    }
}
