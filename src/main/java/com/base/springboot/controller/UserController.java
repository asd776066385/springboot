package com.base.springboot.controller;

import com.base.springboot.model.UserVO;
import com.base.springboot.service.UserService;
import com.base.springboot.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/user/getlist")
    public List<UserVO> getUserList(){
        return userService.getList();
    }

    @GetMapping("/user/testAsync")
    public String testAsync(){
        asyncService.execTask();
        return "处理完成";
    }
}
