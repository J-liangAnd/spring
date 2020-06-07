package com.offcn.controller;

import com.offcn.pojo.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    private List<User> list=new ArrayList<>();

    //Swagger2的接口文档
    @ApiOperation(value="新增用户", notes="新增用户信息")
    @ApiImplicitParam(name = "user", value = "用户信息实体user", required = true, dataType = "pojo包下的类User")

    @PostMapping("/")
    public List<User> add(@RequestBody User user){
            list.add(user);
        return list;
    }

    @GetMapping("/")
    public List<User> find(){
        return list;
    }


    @GetMapping("/{id}")
    public User fidOne(@PathVariable Long id){

        for (User user : list) {
            if (user.getId().longValue()==id.longValue()){
                return user;
            }
        }
        return null;
    }

    @PutMapping("/")
    public List<User> update(@RequestBody User user){
        for (User user1 : list) {
            if (user1.getId().longValue() == user.getId().longValue()){
                user1.setAge(user.getAge());
                user1.setName(user.getName());
            }
        }
        return list;
    }


    @DeleteMapping("/{id}")
    public List<User> delete(@PathVariable("id") Long userid){
        List<User> newlist=new ArrayList<>();

        for (User user : list) {
            if (user.getId().longValue() != userid.longValue()){
                newlist.add(user);
            }
        }
        list=newlist;

        return list;
    }



}
