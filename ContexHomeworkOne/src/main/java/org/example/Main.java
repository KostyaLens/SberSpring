package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Human human = context.getBean(Human.class);
        human.getParrot().setName("Кеша");
        System.out.println(human.getParrot1().getName());
    }
}
