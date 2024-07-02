package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionTaskClass {

    public ArrayList<Class> init() {
        ArrayList<Class> clazs = new ArrayList<>();
        clazs.add(Child0.class);
        clazs.add(Child1.class);
        clazs.add(Child2.class);
        return clazs;
    }


    public DataContainer createClass(int a, int hour, DataContainer dataContainer) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        ArrayList<Class> clasz = init();
        clasz = (ArrayList<Class>) clasz.stream().filter(x -> ((CustomInherited) x.getAnnotation(CustomInherited.class)).daysWeek() == a).collect(Collectors.toList());
        for (Class c : clasz) {
            List<Method> method = List.of(c.getDeclaredMethods());
            Object s = c.newInstance();
            method = method.stream().filter(x -> ((CustomRepeatable) x.getAnnotation(CustomRepeatable.class)).hour() == hour).collect(Collectors.toList());
            method = method.stream().sorted(Comparator.comparingInt(x -> ((CustomRepeatable) x.getAnnotation(CustomRepeatable.class)).priority())).toList();
            for (Method m : method) {
                m.invoke(s, dataContainer);
            }
        }
        return dataContainer;
    }
}