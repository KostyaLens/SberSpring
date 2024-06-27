package org.example;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Cat implements Pet{
    private String name;
}
