package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Human {
    private Cat cat;
    private Dog dog;
    private Parrot parrot;
    private Parrot parrot1;
}