package org.itstep.scan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Application {
    private static ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    public static void main(String[] args) {
        //вывести все экземпляры бинов
        for (String bean: applicationContext.getBeanDefinitionNames()) {
            System.out.println(bean);

        }
    }
} 