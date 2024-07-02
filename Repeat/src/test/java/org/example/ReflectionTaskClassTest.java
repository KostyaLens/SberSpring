package org.example;

import java.lang.reflect.InvocationTargetException;
import static org.junit.jupiter.api.Assertions.*;

class ReflectionTaskClassTest {

    @org.junit.jupiter.api.Test
    void createClass() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        ReflectionTaskClass rt = new ReflectionTaskClass();
        assertEquals(new DataContainer("Костя", 32, true), rt.createClass(6, 12, new DataContainer("Костя", 19, true)));

    }
}