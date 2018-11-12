package com.subrat.demo.rest.webservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.subrat.demo.rest.webservices.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
