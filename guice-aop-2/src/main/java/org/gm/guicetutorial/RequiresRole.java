package org.gm.guicetutorial;

import java.lang.annotation.*;

/**
 * A markup annation used to signal, that a session bean wants to make use of
 * the Guice DI container.
 * 
 * @author Gunnar Morlng
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresRole {
    Role value();
}