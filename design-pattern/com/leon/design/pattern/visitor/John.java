package com.leon.design.pattern.visitor;

public class John implements AdultMale
{

    @Override
    public void amuze (Prostitute p)
    {
        p.amuze();

    }

    @Override
    public void entertain (Whore w)
    {
        w.entertain();

    }

    @Override
    public void nail (Housewife h)
    {
        h.nail();
    }

}
