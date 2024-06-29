package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Human human = context.getBean(Human.class);
        System.out.println(human.getParrot1().getName());
        System.out.println(human.getParrot().getName());
    }
}
