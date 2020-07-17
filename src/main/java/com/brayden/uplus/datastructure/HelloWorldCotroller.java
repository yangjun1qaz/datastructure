package com.brayden.uplus.datastructure;

import com.brayden.uplus.datastructure.bean.Student;
import org.springframework.web.bind.annotation.*;

/**
 * @author Brayden
 * @version 1.0
 * @RequestHeader 只能获取请求头中的具体某个参数 与requestParams不能同用
 * @RequestParam 接收get请求，，post请求（from表单）x-www-from-urlencoded
 * @RequestBody 处理post content_type=application/json
 * @date 2020/4/20 13:49
 */
@RestController
public class HelloWorldCotroller {


    @RequestMapping(value = "/RequestHeaderGet", method = RequestMethod.GET)
    public String helloWorld1(@RequestHeader String clientId) {
        System.out.println(clientId);
        return clientId;
    }


    @RequestMapping(value = "/RequestParamsGet", method = RequestMethod.GET)
    public String helloWorld2(@RequestParam String username) {
        System.out.println(username);
        return username;
    }

    //@RequestParam
    @RequestMapping(value = "/RequestParamsGet0", method = RequestMethod.GET)
    public String helloWorld2(@RequestParam String username, @RequestParam String age) {
        System.out.println(username);
        return username;
    }

    //@RequestParam
    @RequestMapping(value = "/RequestParamsGet2", method = RequestMethod.POST)
    public String helloWorld4(@RequestParam String username, @RequestParam String age) {
        System.out.println(username);
        return username;
    }

    //@RequestParam
    @RequestMapping(value = "/RequestParamsGet4", method = RequestMethod.POST)
    public String helloWorld4(@RequestBody String username) {
        System.out.println(username);
        return username;
    }

    //@RequestParam
    @RequestMapping(value = "/RequestParamsGet1", method = RequestMethod.GET)
    public String helloWorld2(Student student) {
        System.out.println(student);
        return student.toString();
    }


}
