package com.leon.design.pattern.visitor;

import java.util.Arrays;
import java.util.List;

public class VisitorClient
{
    public static void main (String[] argv)
    {
        List<AdultFemale> women = Arrays.asList(new Prostitute(), new Whore(), new Housewife());
        AdultMale man = new John();
        for (AdultFemale doable : women)
            doable.accept(man);
    }
}
