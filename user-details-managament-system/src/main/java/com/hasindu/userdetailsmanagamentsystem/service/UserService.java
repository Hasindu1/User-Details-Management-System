package com.hasindu.userdetailsmanagamentsystem.service;

import com.hasindu.userdetailsmanagamentsystem.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
/**
 *User Service
 */
public interface UserService extends UserDetailsService {
    List<UserDTO> getAllUsers();

    void saveUser(UserDTO userDTO);

    void deleteUser(int id);

    UserDTO findUserById(int id);

    UserDTO findUserByUserName(String userName);

}
