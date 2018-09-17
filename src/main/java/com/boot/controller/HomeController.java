package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 607880661 on 17/09/2018.
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home()
    {
        return "Hello World";
    }
}
