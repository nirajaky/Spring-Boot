package com.jpa.jpaMysql.dao;

import com.jpa.jpaMysql.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRespositry extends CrudRepository<User, Integer> {
    public List<User> findByName(String name);
    public List<User> findByNameAndCity(String name, String city);
    public List<User> findByNameLike(String name);

}
