package com.example.classwork.controller;



import org.springframework.web.bind.annotation.RestController;

import com.example.classwork.model.AppConfig;


import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ApiController {
    private final AppConfig appConfig;

    public ApiController(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    @GetMapping("/info")
    public String getAppInfo() {
        return "App Name: " + appConfig.getAppName() + ", Version: " + appConfig.getAppVersion();
    }
}