package org.gm.guicetutorial;

import java.util.Set;

public class User
{

    private String    name;

    private Set<Role> roles;

    public User (String name, Set<Role> roles)
    {

        super();
        this.name = name;
        this.roles = roles;
    }

    public String getName ()
    {

        return name;
    }

    public Set<Role> getRoles ()
    {

        return roles;
    }

    @Override
    public String toString ()
    {

        return name;
    }

}