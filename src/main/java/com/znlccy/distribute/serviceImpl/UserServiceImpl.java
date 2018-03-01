package com.znlccy.distribute.serviceImpl;

import com.znlccy.distribute.dao.UserRepository;
import com.znlccy.distribute.model.User;
import com.znlccy.distribute.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUserName(String userName) {
        return this.userRepository.findByUserName(userName);
    }
}
