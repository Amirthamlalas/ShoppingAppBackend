package com.nest.shoppingApp_backend.dao;

import com.nest.shoppingApp_backend.model.UserSignup;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserSignup,Integer> {
}
