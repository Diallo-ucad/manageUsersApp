package com.technicaltest.manageusersacountapp.repository;

import com.technicaltest.manageusersacountapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
