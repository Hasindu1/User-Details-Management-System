package com.hasindu.userdetailsmanagamentsystem.service;

import com.hasindu.userdetailsmanagamentsystem.dto.LoginHistoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *Login History Service
 */
public interface LoginHistoryService {
    List<LoginHistoryDTO> getAllLoginHistories();

    void addLoginHistory(LoginHistoryDTO loginHistoryDTO);

    List<LoginHistoryDTO> findUserHistoriesByUserName(String userName);

}
