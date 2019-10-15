package com.improving;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        var game = context.getBean(Game.class);
        game.run();

    }
}
