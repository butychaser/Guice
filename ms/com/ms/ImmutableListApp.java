package com.ms;

import java.util.ArrayList;
import java.util.List;

public class ImmutableListApp {
    public static void main(String[] args)
    {
        List<String> input = new ArrayList<>();
        input.add("123");
        input.add("456");
        ImmutableList im = new ImmutableList(input);
        im.getInstance().stream().forEach(System.out::print);
        System.out.println("");
        im.getInstance().add("xyz");
        im.getInstance().stream().forEach(System.out::print);
    }
}
