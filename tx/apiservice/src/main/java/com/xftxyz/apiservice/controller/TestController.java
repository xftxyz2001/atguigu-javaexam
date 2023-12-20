package com.xftxyz.apiservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {

    // http://localhost:5000/test?a=1&b=nihao
    @GetMapping("/test")
    public HashMap<String, String> test(@RequestParam(value = "a",required = false) Integer a,
                                        @RequestParam(value = "b") String b) {
        HashMap<String, String> res = new HashMap<>();
        res.put("error_code", "0");
        res.put("error_message", "success");
        res.put("reference", "111");
        return res;
    }
}
