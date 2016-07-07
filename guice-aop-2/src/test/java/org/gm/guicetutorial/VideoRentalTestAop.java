package org.gm.guicetutorial;

import static org.junit.Assert.*;

import java.util.EnumSet;

import org.junit.*;

import com.google.inject.*;

public class VideoRentalTestAop
{

    @Inject
    private VideoRentalAop videoRental;

    @Inject
    private UserManager    userManager;

    private static User    customer;

    private static User    employee;

    @BeforeClass
    @SuppressWarnings("serial")
    public static void setupUsers ()
    {

        customer = new User("Peter", EnumSet.of(Role.CUSTOMER));
        employee = new User("Bob", EnumSet.of(Role.EMPLOYEE));
    }

    @Before
    public void setup ()
    {
        ExampleModuleAop module = new ExampleModuleAop();

        Injector injector = Guice.createInjector(module);
        for (Object oneInjectee : module.getInjectees())
        {
            injector.injectMembers(oneInjectee);
        }

        injector.injectMembers(this);
    }

    @Test
    public void testRentMovieSuccessfully () throws Exception
    {
        userManager.setCurrentUser(customer);
        assertTrue(videoRental.rentMovie(1));
    }

    @Test(expected = IllegalStateException.class)
    public void testRentMovieFailing () throws Exception
    {
        userManager.setCurrentUser(employee);
        videoRental.rentMovie(1);
    }

    @Test
    public void testRegisterNewMovieSuccessfully () throws Exception
    {
        userManager.setCurrentUser(employee);
        assertTrue(videoRental.registerNewMovie("The Fugitive"));
    }

    @Test(expected = IllegalStateException.class)
    public void testRegisterNewMovieFailing () throws Exception
    {

        userManager.setCurrentUser(customer);
        assertTrue(videoRental.registerNewMovie("The Fugitive"));
    }
}
