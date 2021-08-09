package com.hasindu.userdetailsmanagamentsystem.dao;

import com.hasindu.userdetailsmanagamentsystem.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 *DAO layer for UserRole
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
}
