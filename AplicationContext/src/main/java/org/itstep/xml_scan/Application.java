package org.itstep.xml_scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;


public class Application {
    private static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(org.itstep.scan.Application.class);
    public static void main(String[] args) {
        //вывести все экземпляры бинов
        for (String bean: applicationContext.getBeanDefinitionNames()) {
            System.out.println(bean);

            applicationContext.getBean(Room.class).sound();
            System.out.println(applicationContext.containsBean("catDao"));
        }
    }
} 