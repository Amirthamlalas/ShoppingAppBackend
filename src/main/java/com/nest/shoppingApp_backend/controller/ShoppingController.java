package com.nest.shoppingApp_backend.controller;

import com.nest.shoppingApp_backend.dao.ProductDao;
import com.nest.shoppingApp_backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ShoppingController {
@Autowired
private ProductDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public String AddProduct(@RequestBody Product p){
        System.out.println(p.getName().toString());
        System.out.println(p.getCategory().toString());
        dao.save(p);
        HashMap<String, String>
                map=new HashMap<>();
        map.put("status","success");
        return "successfully added product";
    }
}
