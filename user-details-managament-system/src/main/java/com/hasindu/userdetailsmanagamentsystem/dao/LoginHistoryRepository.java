package com.hasindu.userdetailsmanagamentsystem.dao;

import com.hasindu.userdetailsmanagamentsystem.entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
/**
 *DAO layer for LoginHistory
 */
@Repository
public interface LoginHistoryRepository extends JpaRepository<LoginHistory,Integer> {

    @Query("SELECT l FROM LoginHistory l JOIN  l.user user WHERE user.userName =:userName")
    List<LoginHistory> findUserHistoriesByUserName(@Param("userName") String userName);
}
