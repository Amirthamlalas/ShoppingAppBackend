package com.nest.shoppingApp_backend.dao;

import com.nest.shoppingApp_backend.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product,Integer> {


}
