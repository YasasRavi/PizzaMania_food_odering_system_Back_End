package com.example.jwt.New.dao;

import com.example.jwt.New.entity.OrderDetail;
import com.example.jwt.New.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDetailDao extends CrudRepository<OrderDetail, Integer> {
    public List<OrderDetail> findByUser(User user);

    public List<OrderDetail> findByorderStatus(String status);
}
