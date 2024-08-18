package com.leon.design.pattern.visitor;

public class Whore implements AdultFemale
{

    @Override
    public void accept (AdultMale aMan)
    {
        aMan.entertain(this);

    }

    public void entertain ()
    {
        System.out.println("Lousy Annul Bang.");

    }

}
