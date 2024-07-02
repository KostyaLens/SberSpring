package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    Dog dog() {
        return new Dog("Бобик");
    }

    @Bean
    Cat cat() {
        return new Cat("Мурзик");
    }

    @Bean
    Human man(Cat cat, Dog dog, Parrot parrot, Parrot parrot1) {
        return new Human(cat, dog, parrot, parrot1);
    }

    @Bean
    Parrot parrot() {
        return new Parrot("Кеша");
    }

    @Bean
    Parrot parrot1() {
        return new Parrot("Кешка");
    }
}