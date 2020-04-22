package com.brayden.uplus.datastructure;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/4/20 13:49
 */
@RestController
public class HelloWorldCotroller {

    @RequestMapping("/hello")
    public String helloWorld(){
        return "hello world";
    }

}
