package com.improving;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("com.improving")
public class SpringConfiguration {
    @Bean
    public Scanner getScanner() {return new Scanner(System.in);}
}
