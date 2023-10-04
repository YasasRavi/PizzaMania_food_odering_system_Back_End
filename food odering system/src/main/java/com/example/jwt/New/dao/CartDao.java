package com.example.jwt.New.dao;

import com.example.jwt.New.entity.Cart;
import com.example.jwt.New.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDao extends CrudRepository <Cart,Integer > {
    public List<Cart> findByUser(User user);


}
