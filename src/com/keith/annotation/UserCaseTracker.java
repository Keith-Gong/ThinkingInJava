package com.keith.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by keith on 9/14/2015.
 */
public class UserCaseTracker {
    public static void trackUseCase(List<Integer> useCase, Class<?> cls) {
        for (Method m : cls.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println(uc.id() + ": " + uc.description());
                useCase.remove(new Integer(uc.id()));
            }
        }
        for (int i : useCase) {
            System.out.println("Warning : Missing use case-" + i);
        }
    }
    public static void main (String args[]) {
        List<Integer> useCase = new ArrayList<Integer>();
        Collections.addAll(useCase, 47, 48, 49, 50);
        trackUseCase(useCase, PasswordUtils.class);
    }
}
