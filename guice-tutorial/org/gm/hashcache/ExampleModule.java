package org.gm.hashcache;

import org.gm.guicetutorial.*;

import com.google.inject.*;

public class ExampleModule extends AbstractModule
{

    @Override
    public void configure ()
    {
        bind(MD5Helper.class).to(MD5HelperFastImpl.class);
    }

    @Provides
    public HelloworldStr provideHelloworldStr ()
    {
        return new HelloworldStr();
    }

}
