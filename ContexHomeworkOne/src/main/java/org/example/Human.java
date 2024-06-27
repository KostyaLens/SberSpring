package org.example;

import lombok.Data;

@Data
public class Human {
    private Cat cat;
    private Dog dog;
    private Parrot parrot, parrot1;
}
