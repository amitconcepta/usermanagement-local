package com.usermanagement.spring.microservice.orm.repository;

import com.usermanagement.spring.microservice.orm.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneById(Long id);

    @Query(value = "SELECT e FROM User e WHERE e.email=:email ")
    User findByEmailId(@Param("email") String email);

    @Query(value = "SELECT e FROM User e WHERE e.accessKey=:accessKey ")
    User findByAccessKey(@Param("accessKey") String accessKey);
}