package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    Cat cat(){
        Cat cat = new Cat();
        cat.setName("Барсик");
        return cat;
    }

    @Bean
    Dog dog(){
        Dog dog = new Dog();
        dog.setName("Барсик");
        return dog;
    }

    @Bean
    Parrot parrot(){
        Parrot parrot = new Parrot();
        parrot.setName("Кеша");
        return parrot;
    }

    @Bean
    Parrot parrot1(){
        Parrot parrot1 = new Parrot();
        parrot1.setName("Кешка");
        return parrot1;
    }
    @Bean
    Human human(){
        Human human = new Human();
        human.setCat(cat());
        human.setDog(dog());
        human.setParrot(parrot());
        human.setParrot1(parrot1());
        return human;
    }

}
