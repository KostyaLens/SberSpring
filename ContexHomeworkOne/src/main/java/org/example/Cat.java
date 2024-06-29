package org.example;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Cat implements Pet{
    private String name;
}
