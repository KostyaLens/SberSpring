package org.example;

public interface FilleInterface {
    void createLog();

    void writeFile(String str, String name);

    void cleanLogDirectory();

    String readFile(String name);
}
