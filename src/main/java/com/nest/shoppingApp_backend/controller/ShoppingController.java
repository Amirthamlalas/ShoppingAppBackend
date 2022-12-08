package com.nest.shoppingApp_backend.controller;

import com.nest.shoppingApp_backend.dao.ProductDao;
import com.nest.shoppingApp_backend.dao.UserDao;
import com.nest.shoppingApp_backend.model.Product;
import com.nest.shoppingApp_backend.model.UserSignup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ShoppingController {
@Autowired
private ProductDao dao;
@Autowired
private UserDao uao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> AddProduct(@RequestBody Product p){
        System.out.println(p.getName().toString());
        System.out.println(p.getCategory().toString());
        dao.save(p);
        HashMap<String, String> map = new HashMap<>();
        map.put("status","success");

        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/signup",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> UserSignup(@RequestBody UserSignup u){
        System.out.println(u.getName().toString());
        System.out.println(u.getEmail().toString());
        uao.save(u);
        HashMap<String, String> map = new HashMap<>();
        map.put("status","success");

        return map;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Product>view(){
        return (List<Product>) dao.findAll();

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Product>search(@RequestBody Product p){
        String name = String.valueOf(p.getName());
        System.out.println(name);
        return (List<Product>) dao.search(p.getName());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login",consumes = "application/json",produces = "application/json")
    public List<UserSignup>login(@RequestBody UserSignup u){
        String email = String.valueOf(u.getEmail());
        String password = String.valueOf(u.getPassword());
        System.out.println(email);
        System.out.println(password);
        return (List<UserSignup>)uao.login(u.getEmail(),u.getPassword());
    }
}
