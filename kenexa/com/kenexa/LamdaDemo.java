package com.kenexa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;

public class LamdaDemo
{
    public static void main (String[] args)
    {
        printName("test");
        List<Integer> aList = Arrays.asList(1,2,3,3,4,4,-1);
        List<String> bList = Arrays.asList("1","2","3","3","4","4","-1");

        List<Integer> resul1 = aList.stream().skip(2).collect(Collectors.toList()); //[3, 3, 4, 4, -1]
        List<Integer> resul2 = aList.stream().limit(2).collect(Collectors.toList());//[1, 2]
        List<String> aStringList = Arrays.asList("aaa","bbb","ccc");
        System.out.println(aStringList.stream().reduce("Result of reduce with concat:", (a,b)->a.concat(" ,".concat(b))));
        System.out.println(bList.stream().flatMap(value->Stream.of(value)).collect(Collectors.toList()));

        ArrayList result = aList.stream().filter(value -> value > 1).sorted().sequential().
                map(Integer::valueOf).distinct().collect(Collectors.toCollection(ArrayList::new));


        System.out.println(resul1.toString());
        System.out.println(resul2.toString());
        System.out.println(result.toString());
    }

    public static void printName (String name)
    {
        Runnable r = () -> {
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Delay:" + name);
        };
        new Thread(r).start();
        System.out.println("Welcome:" + name);
    }
}
