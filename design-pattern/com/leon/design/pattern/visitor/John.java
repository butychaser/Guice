package com.leon.design.pattern.visitor;

public class John implements AdultMale
{

    @Override
    public void amuze (Prostitute p)
    {
        p.GFEService();

    }

    @Override
    public void entertain (Whore w)
    {
        w.oralService();

    }

    @Override
    public void nail (Housewife h)
    {
        h.missionaryService();
        h.extraAnnulServer();
    }

}
