package org.gm.hashcache;

public class TestEqualOnObject
{
    public static void main (String[] args)
    {
        String str1 = new String("true");
        String str2 = new String("true");

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        if (str1 == str2)
            System.out.println("str1==str2");
        if (str1.equals(str2))
            System.out.println("str1.equal(str2)");
    }
}
