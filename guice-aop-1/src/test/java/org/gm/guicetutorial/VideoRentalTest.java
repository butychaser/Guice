package org.gm.guicetutorial;

import static org.junit.Assert.*;

import org.junit.*;

import com.google.inject.*;

public class VideoRentalTest
{

    @Inject
    private VideoRental videoRental;

    @Before
    public void setup ()
    {

        Injector injector = Guice.createInjector(new ExampleModule());
        //videoRental = injector.getInstance(VideoRental.class);
        injector.injectMembers(this);
    }

    @Test
    public void testRentMovie () throws Exception
    {

        assertTrue(videoRental.rentMovie(1));
    }

    @Test
    public void testRegisterNewMovie () throws Exception
    {

        assertTrue(videoRental.registerNewMovie("The Fugitive"));
    }

}
