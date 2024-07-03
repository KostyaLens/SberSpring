package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class Human {
    @Autowired
    private Pet cat;
    @Autowired
    private Pet dog;
    @Autowired
    private Pet parrot;
    @Autowired
    private Pet parrot1;
}