package com.nest.shoppingApp_backend.dao;

import com.nest.shoppingApp_backend.model.Product;
import com.nest.shoppingApp_backend.model.UserSignup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<UserSignup,Integer> {

    @Query(value = "SELECT `id`, `address`, `confirmpassword`, `email`, `name`, `password`, `phoneno` FROM `usersignup` WHERE `email`= :email AND `password`= :password",nativeQuery = true)
    List<UserSignup> login(@Param("email") String email,@Param("password")String password);

}
