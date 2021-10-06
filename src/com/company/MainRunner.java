package com.company;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MainRunner {
    public static void execute(String path, String[] args) {
        try {
            Class c = Class.forName(path);
            Method[] ms = c.getMethods();
            for (Method m: ms) {
                if (m.getName().compareTo("main") == 0 &&
                        m.getParameterTypes().length == 1 &&
                        m.getParameterTypes()[0] == String[].class &&
                        (m.getModifiers() & Modifier.PUBLIC) != 0 &&
                        (m.getModifiers() & Modifier.STATIC) != 0 &&
                        (m.getReturnType() == void.class))
                {
                    m.invoke(null, (Object) args);
                    return;
                }
            }
            System.out.println("Not found main");
        }
        catch (Exception e) {
            System.out.println("Invalid path: " + e.getMessage());
            return;
        }
    }
}
