package com.abyss.tech.annotation.orm;

import com.abyss.tech.annotation.orm.db.Constraints;
import com.abyss.tech.annotation.orm.db.DBTable;
import com.abyss.tech.annotation.orm.db.SQLInteger;
import com.abyss.tech.annotation.orm.db.SQLString;

@DBTable(name = "Member")
public class Member
{
    @SQLString(length = 30, name = "firstName", constraints = @Constraints(primaryKey = true,
        allowNull = true, unique = true))
    String     firstName;

    @SQLString(length = 50)
    String     lastName;

    @SQLInteger
    Integer    age;

    String     handle;

    static int memberCount;

    public String getHandle ()
    {
        return handle;
    }

    public String getFirstName ()
    {
        return firstName;
    }

    public String getLastName ()
    {
        return lastName;
    }

    public String toString ()
    {
        return handle;
    }

    public Integer getAge ()
    {
        return age;
    }
}
