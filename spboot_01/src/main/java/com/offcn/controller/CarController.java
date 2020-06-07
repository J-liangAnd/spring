package com.offcn.controller;

import com.offcn.pojo.Car;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    @RequestMapping("/getName")
    public String getName(){
        return  "访问成功";
    }

    @RequestMapping("/car1")
    public Car car1(Car car){
        return car;
    }

    @RequestMapping("/car2")
    public Car car2(@RequestBody Car car){
        return car;
    }
}
