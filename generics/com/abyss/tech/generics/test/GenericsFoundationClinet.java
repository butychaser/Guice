package com.abyss.tech.generics.test;

import com.abyss.tech.generics.fundation.BasicGenerator;
import com.abyss.tech.generics.fundation.Generator;

public class GenericsFoundationClinet
{
    public static void main (String[] argv)
    {
        Generator<GenericsTestCounter> generator = BasicGenerator.create(GenericsTestCounter.class);
        for (int i = 0; i < 5; i++)
            System.out.println(generator.next());
    }
}
