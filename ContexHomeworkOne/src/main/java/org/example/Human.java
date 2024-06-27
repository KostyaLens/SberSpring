package org.example;

import lombok.Data;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Data
@Component
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
