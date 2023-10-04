package com.example.jwt.New.dao;


import com.example.jwt.New.entity.Role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository <Role, String>{

}
