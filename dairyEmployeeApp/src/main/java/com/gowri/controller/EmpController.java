package com.gowri.controller;
/*
 * @author NaveenWodeyar
 * @date 15-10-2024
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmpController {

    public static final Logger log = LoggerFactory.getLogger(EmpController.class);

    @GetMapping
    public String testEndPoint(){
        log.info("test endpoint accessed");
        return "Dairy Employee App connected,";
    }
}
