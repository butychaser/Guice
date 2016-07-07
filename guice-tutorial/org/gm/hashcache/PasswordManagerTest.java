package org.gm.hashcache;

import org.gm.guicetutorial.PasswordManager;
import org.junit.*;

import com.google.inject.*;

public class PasswordManagerTest
{

    private PasswordManager passwordManager;
    private Injector        injector;

    @Before
    public void setup ()
    {

        //injector = Guice.createInjector();
        injector = Guice.createInjector(new ExampleModule());
        //passwordManager = injector.getInstance(PasswordManager.class);
    }

    @Test
    public void testPasswordMatches () throws Exception
    {

        Helloworld hi = injector.getInstance(Helloworld.class);
        //injector.injectMembers(hi);
        hi.helloStr.greetToWorld();
        //assertTrue(passwordManager.passwordMatches("peter", "secret"));
        //assertFalse(passwordManager.passwordMatches("peter", "wrong password"));
    }
}
