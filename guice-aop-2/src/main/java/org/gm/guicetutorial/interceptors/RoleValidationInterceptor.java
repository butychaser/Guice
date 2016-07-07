package org.gm.guicetutorial.interceptors;

import org.aopalliance.intercept.*;
import org.gm.guicetutorial.*;

import com.google.inject.Inject;

public class RoleValidationInterceptor implements MethodInterceptor
{

    @Inject
    private UserManager userManager;

    @Override
    public Object invoke (MethodInvocation invocation) throws Throwable
    {

        Role requiredRole = invocation.getMethod().getAnnotation(RequiresRole.class).value();

        if (userManager.getCurrentUser() == null
            || !userManager.getCurrentUser().getRoles().contains(requiredRole))
        {
            throw new IllegalStateException("User requires role " + requiredRole);
        }

        return invocation.proceed();
    }
}
