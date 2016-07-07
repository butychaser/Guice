package org.gm.hashcache;

import org.gm.guicetutorial.HelloworldStr;

import com.google.inject.Inject;

public class Helloworld
{
    public void doYourJob ()
    {
        System.out.println("Hello world, I came from the air");
    }

    @Inject
    public HelloworldStr helloStr;
}
