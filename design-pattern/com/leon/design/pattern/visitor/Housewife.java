package com.leon.design.pattern.visitor;

public class Housewife implements AdultFemale
{

    @Override
    public void accept (AdultMale aMan)
    {
        aMan.nail(this);

    }

    public void missionaryService ()
    {
        System.out.println("A OK Missionary.");

    }

    public void extraAnnulServer ()
    {
        System.out.println("A surprise.");
    }

}
