package com.wp.myfinance.Authorization.repository;

import com.wp.myfinance.Authorization.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//public interface UserRepository extends JpaRepository<User, Long> {
public interface UserRepository extends MongoRepository<User,String> {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);


}
