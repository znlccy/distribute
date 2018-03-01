package com.znlccy.distribute.dao;

import com.znlccy.distribute.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByUserName(String userName);

}
