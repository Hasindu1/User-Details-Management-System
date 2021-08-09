package com.hasindu.userdetailsmanagamentsystem.service;

import com.hasindu.userdetailsmanagamentsystem.dao.LoginHistoryRepository;
import com.hasindu.userdetailsmanagamentsystem.dao.UserRepository;
import com.hasindu.userdetailsmanagamentsystem.dto.LoginHistoryDTO;
import com.hasindu.userdetailsmanagamentsystem.dto.UserDTO;
import com.hasindu.userdetailsmanagamentsystem.entity.LoginHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginHistoryServiceImpl implements LoginHistoryService {
    @Autowired
    private LoginHistoryRepository loginHistoryRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<LoginHistoryDTO> getAllLoginHistories() {
        List<LoginHistory> loginHistories = loginHistoryRepository.findAll();
        List<LoginHistoryDTO> loginHistoryDTOList = new ArrayList<>();


        for (LoginHistory currentLoginHistory : loginHistories) {
            UserDTO tempUserDTO = new UserDTO();
            tempUserDTO.setUserName(currentLoginHistory.getUser().getUserName());
            loginHistoryDTOList.add(new LoginHistoryDTO(currentLoginHistory.getRecordId(), currentLoginHistory.getLoggedInDate(), currentLoginHistory.getLoggedInTime(), currentLoginHistory.getIpAddress(), currentLoginHistory.getBrowserName(), currentLoginHistory.getDeviceType(), tempUserDTO));
        }
        return loginHistoryDTOList;
    }

    @Override
    @Transactional
    public void addLoginHistory(LoginHistoryDTO loginHistoryDTO) {
        UserDTO userDTO = loginHistoryDTO.getUser();
        loginHistoryRepository.save(new LoginHistory(loginHistoryDTO.getLoggedInDate(), loginHistoryDTO.getLoggedInTime(), loginHistoryDTO.getIpAddress(), loginHistoryDTO.getBrowserName(), loginHistoryDTO.getDeviceType(), userRepository.findByUserName(userDTO.getUserName()).get()));
    }

    @Override
    @Transactional
    public List<LoginHistoryDTO> findUserHistoriesByUserName(String userName) {
        List<LoginHistory> loginHistories = loginHistoryRepository.findUserHistoriesByUserName(userName);
        List<LoginHistoryDTO> loginHistoryDTOList = new ArrayList<>();
        UserDTO userDTO = new UserDTO();
        for (LoginHistory currentLoginHistory : loginHistories) {
            userDTO.setUserName(currentLoginHistory.getUser().getUserName());
            loginHistoryDTOList.add(new LoginHistoryDTO(currentLoginHistory.getRecordId(), currentLoginHistory.getLoggedInDate(), currentLoginHistory.getLoggedInTime(), currentLoginHistory.getIpAddress(), currentLoginHistory.getBrowserName(), currentLoginHistory.getDeviceType(), userDTO));
        }
        return loginHistoryDTOList;
    }
}
