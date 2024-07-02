package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class Human {
    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;
    @Autowired
    private Parrot parrot;
    @Autowired
    private Parrot parrot1;
}