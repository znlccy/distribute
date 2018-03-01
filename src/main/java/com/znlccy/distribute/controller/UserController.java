package com.znlccy.distribute.controller;

import com.znlccy.distribute.model.User;
import com.znlccy.distribute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostMapping("/save")
    public User save() {
        User user = new User(2l, "zhangsanfeng",25);
        mongoTemplate.save(user);
        return user;
    }

    @GetMapping("/find")
    public List<User> find() {
        List<User> userList = mongoTemplate.findAll(User.class);
        return userList;
    }

    @GetMapping("findByName")
    public User findByUserName(@RequestParam("userName") String userName) {
        User user = userService.findByUserName(userName);
        return user;
    }
}
