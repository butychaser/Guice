package com.leon.design.pattern.visitor;

public class Prostitute implements AdultFemale
{

    @Override
    public void accept (AdultMale aMan)
    {
        aMan.amuze(this);

    }

    public void amuze ()
    {
        System.out.println("Girl Friend Experience.");
    }

}
