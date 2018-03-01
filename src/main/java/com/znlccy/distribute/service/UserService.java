package com.znlccy.distribute.service;

import com.znlccy.distribute.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {

    void save(User user);

    User findByUserName(String userName);

}
