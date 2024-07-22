package org.itstep;

import org.springframework.stereotype.Service;

@Service
public class SomeService {
    public void someMethods() throws InterruptedException {
        Thread.sleep(1000);
    }
}
