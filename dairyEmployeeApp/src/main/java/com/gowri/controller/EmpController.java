package com.gowri.controller;
/*
 * @author NaveenWodeyar
 * @date 15-10-2024
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/emp")
public class EmpController {
    public static final Logger log = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private Environment environment;

    @GetMapping
    public String testEndPoint(){
        log.info("test endpoint accessed at: "+ LocalDateTime.now());
        String port = environment.getProperty("server.port", "8080");
log.info("Running on port:"+port);
        return "Dairy Employee App connected, running on port: " + port;
    }
}
