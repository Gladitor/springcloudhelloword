package com.jiay.feign.service;

import org.springframework.stereotype.Component;

@Component
public class ApiServiceError implements ApiService {
    @Override
    public String index() {
        return "service error";
    }
}
