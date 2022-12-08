package com.nest.shoppingApp_backend.dao;

import com.nest.shoppingApp_backend.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductDao extends CrudRepository<Product,Integer> {
    @Query(value = "SELECT `id`, `category`, `description`, `image`, `name`, `price` FROM `products` WHERE `name` Like %:name%",nativeQuery = true)
    List<Product>search(@Param("name") String name);


}
