package org.itstep.Sample1;

import org.springframework.stereotype.Component;

@Component
public class FullName {
    public String composeFullName(String firstName, String lastName){
        return firstName+lastName;
    }
}
