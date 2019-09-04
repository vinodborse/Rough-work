package com.vinu.dao;

import org.springframework.data.repository.Repository;

import com.vinu.model.User;

public interface UserRepository extends Repository<User, Long> {

    User save( User user );

    User findByUsername( String username );

    void deleteAll();

}
