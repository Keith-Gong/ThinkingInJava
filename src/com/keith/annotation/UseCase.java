package com.keith.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

/**
 * Created by keith on 9/14/2015.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    int id();
    public String description() default "No Description";
}

class PasswordUtils {
    @UseCase(id = 47, description = "Passwords must contain at least one numeric")
    public boolean validatePassword(String password) {
        return false;
    }
    //@UseCase(id = 49, description = "Test")
    //public boolean checkForNewPassword (List<String>)
}
