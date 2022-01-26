package com.epam.spring.homework2;


import com.epam.spring.homework2.config.ConfigA;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigA.class);
    }
}
