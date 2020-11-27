package com.quylua98.service;

import com.quylua98.config.annotation.Log;
import org.springframework.stereotype.Service;

@Service
public class LogService {

//    @Log
    public void out(String msg) {
        System.out.println(msg);
        out2();
    }

    public void out2() {
        System.out.println("out 2 " + this);
    }
}
