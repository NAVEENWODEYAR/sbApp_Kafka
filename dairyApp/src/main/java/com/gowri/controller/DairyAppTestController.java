package com.gowri.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author NaveenWodeyar
 * @date 07-10-2024
 */
@RestController
@RequestMapping("/api/v1")
public class DairyAppTestController {

    private static final Logger log = LoggerFactory.getLogger(DairyAppTestController.class);

    @Autowired
    private Environment  environment;

    @GetMapping
    public String test(){
        log.warn("test passed");
        String port = environment.getProperty("server.port");
        return "DairyApp_connected running on " + port;
    }
}
