package com.quylua98.service.impl;

import com.quylua98.config.annotation.Log;
import com.quylua98.service.JDKDynamicProxyService;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IJDKDynamicProxyServiceService implements JDKDynamicProxyService {

    @Override
    @Transactional
    public void out(String str) {
        System.out.println(str);
    }
}
