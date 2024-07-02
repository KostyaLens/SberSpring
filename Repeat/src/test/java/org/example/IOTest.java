package org.example;

import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import static org.junit.jupiter.api.Assertions.*;

class IOTest {

    @Test
    void writeFile() throws InvocationTargetException, IllegalAccessException, InstantiationException {
        ReflectionTaskClass rt = new ReflectionTaskClass();
        IO io = new IO();
        io.writeFile(String.valueOf(rt.createClass(6, 12, new DataContainer("Костя", 19, true))), "test.txt");
        String s = io.readFile("test.txt");

        assertEquals("DataContainer(name=Костя, year=32, isAct=true)", s);
    }
}