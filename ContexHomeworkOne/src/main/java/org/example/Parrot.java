package org.example;

import lombok.Data;
import org.springframework.aop.target.PrototypeTargetSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope("prototype")
public class Parrot implements Pet{
    private String name;
}
