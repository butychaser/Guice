package org.gm.guicetutorial;

import com.google.inject.Inject;

public class VideoRentalAop
{

    @Inject
    UserManager userManager;

    @RequiresRole(Role.CUSTOMER)
    public boolean rentMovie (long movieId)
    {

        System.out.println(String.format(
            "Movie %s rented by user %s.",
            movieId,
            userManager.getCurrentUser()));

        return true;
    }

    @RequiresRole(Role.EMPLOYEE)
    public boolean registerNewMovie (String name)
    {

        System.out.println(String.format(
            "New movie \"%s\" registered by user %s.",
            name,
            userManager.getCurrentUser()));

        return true;
    }
}
