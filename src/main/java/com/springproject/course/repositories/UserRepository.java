package com.springproject.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
