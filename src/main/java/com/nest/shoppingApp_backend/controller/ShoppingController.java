package com.nest.shoppingApp_backend.controller;

import com.nest.shoppingApp_backend.dao.ProductDao;
import com.nest.shoppingApp_backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ShoppingController {
@Autowired
private ProductDao dao;
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
}
