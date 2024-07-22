package org.itstep.traffic;

import org.springframework.stereotype.Component;

@Component
public class Driver {

    public void stop(){
        System.out.println("Stop");
    }

    public void ready(){
        System.out.println("Ready");
    }

    public void go(){
        System.out.println("Go");
    }
} 