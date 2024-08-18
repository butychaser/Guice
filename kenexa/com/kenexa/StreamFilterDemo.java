package com.kenexa;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class StreamFilterDemo {
    public static void main(String[] args0){
        List<String> aList = Arrays.asList("alpha", "beta" , "delta");
        nothingOutput(aList);
        System.out.println("==============Start normal output==============");
        normalOutput(aList);

    }
//wont output anything if missing terminator of .collect() .
    public static void nothingOutput(List<String> aList){
        aList.stream().filter(name -> {
            System.out.println("Invisible Welcome " +name);
            return true;
        });
    }
//output with terminal function .collect() .
    public static void normalOutput(List<String> aList){
        aList.stream().filter(name ->{
        System.out.println("Welcome " + name);
        return true;
        }).collect(Collectors.toList());
    }
}
