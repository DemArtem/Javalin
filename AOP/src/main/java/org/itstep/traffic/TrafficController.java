package org.itstep.traffic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.itstep.Sample1.LoggingAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
@Aspect
public class TrafficController {
    @Autowired
    Driver driver;
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());{
    }

    @Pointcut("within(org.itstep.traffic.TrafficLight)")
    public void someMethods(){}

    @AfterReturning(pointcut="execution(public string org.itstep.traffic.TrafficLight.switchRed())", returning="result")
    public void stopDriver(JoinPoint joinPoint, Object result) {
        driver.stop();
    }

    @AfterReturning(pointcut = "execution(public String org.itstep.traffic.TrafficLight.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        String value = (String)result;
        System.out.println(value);
        if (name.equals("switchYellow"))
            driver.ready();
        else if (name.equals("switchGreen"))
            driver.go();
    }
}