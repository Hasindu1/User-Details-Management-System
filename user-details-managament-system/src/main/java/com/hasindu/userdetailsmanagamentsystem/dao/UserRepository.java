package com.hasindu.userdetailsmanagamentsystem.dao;

import com.hasindu.userdetailsmanagamentsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 *DAO layer for User
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
 Optional<User> findByUserName(String userName);

}
