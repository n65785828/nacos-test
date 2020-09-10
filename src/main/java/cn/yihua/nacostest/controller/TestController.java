package cn.yihua.nacostest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RefreshScope
public class TestController {

    @Value(value = "${yihua.config}")
    private String value;

    private Random random = new Random();

    @GetMapping("/test")
    public String test(){
        return value;
    }

    @GetMapping("/long-polling")
    public String testLongPolling(){
        int sleepSecends = random.nextInt(25);
        try {
            TimeUnit.SECONDS.sleep(sleepSecends);//sleep
        } catch (InterruptedException e) {

        }
        System.out.println("wait " + sleepSecends + " second");
        return sleepSecends+" second prepare data";
    }

    @GetMapping("/test2")
    public String test1(){
        return "test2";
    }

    @GetMapping("/test3")
    public String test3(){
        return "test3";
    }

    @GetMapping("/test4")
    public String test4(){
        return "test4";
    }

    @GetMapping("/test5")
    public String test5(){
        return "test5";
    }

    @GetMapping("/test6")
    public String test6(){
        return "test6";
    }
}
