package org.example;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
//        Child0 pc = new Child0();
//        new Child1().method(null); //передаем null
//        pc.method(new DataContainer());
        DataContainer dataContainer = new DataContainer("Костя", 19, true);
//        System.out.println(dataContainer);
        IO io = new IO();
        io.createLog();
        ReflectionTaskClass rt = new ReflectionTaskClass();
        System.out.println(rt.createClass(6, 12, dataContainer));
        io.writeFile((rt.createClass(6, 12, dataContainer)).toString(), io.genarateFileName());

    }
}
