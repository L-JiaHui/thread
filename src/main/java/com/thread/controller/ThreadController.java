package com.thread.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: L-JiaHui
 * @date: 2020/11/29/19:09
 * @description:
 */
@RestController
public class ThreadController {

    @RequestMapping("/thread")
    @SentinelResource("thread")
    public String thread(String message) {
        return message;
    }


    @RequestMapping("/hot")
    @SentinelResource("hot")
    public String hot(String param1,String param2) {
        return param1 + "/" + param2;
    }
}
