package com.abyss.tech.annotation.intro;

public class PasswordUtils
{
    @UserCase(id = 48, description = "Password is verified")
    void verifyPassword ()
    {
    }

    @UserCase(id = 49)
    void generatePassword ()
    {
    }

    @UserCase(id = 50, description = "Password is rejected!")
    void rejectPassword ()
    {
    }

    @UserCase(description = "no id")
    void rejectPassword (String s)
    {
    }
}
