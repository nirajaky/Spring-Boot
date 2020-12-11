package com.jpa.jpaMysql.dao;

import com.jpa.jpaMysql.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRespositry extends CrudRepository<User, Integer> {
    public List<User> findByName(String name);
    public List<User> findByNameAndCity(String name, String city);
    public List<User> findByNameLike(String name);

    // Java Persistance Query Language
    @Query("select u from User u")
    public List<User> getAllUsers();

    // Java Persistance Query Language with Parametrized Query
    // @Param is used to give parameter name
    @Query("SELECT u FROM User u WHERE u.name =:str and u.city =:c")
    public List<User> getUserByName(@Param("str") String name, @Param("c") String city);

    // Fire Native Query with @Query
    @Query(value = "select * from user", nativeQuery = true)
    public List<User> getUsers();

}
