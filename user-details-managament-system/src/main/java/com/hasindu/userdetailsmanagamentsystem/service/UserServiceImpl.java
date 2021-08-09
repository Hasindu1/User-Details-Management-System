package com.hasindu.userdetailsmanagamentsystem.service;

import com.hasindu.userdetailsmanagamentsystem.dao.UserRepository;
import com.hasindu.userdetailsmanagamentsystem.dto.CompanyUserDetailsDTO;
import com.hasindu.userdetailsmanagamentsystem.dto.UserDTO;
import com.hasindu.userdetailsmanagamentsystem.entity.User;
import com.hasindu.userdetailsmanagamentsystem.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.hasindu.userdetailsmanagamentsystem.Constants.COMPANY_CODE;
import static com.hasindu.userdetailsmanagamentsystem.Constants.ROLE_TYPE;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<User> userList = userRepository.findAll();
        for (User currentUser : userList) {
            userDTOList.add(new UserDTO(currentUser.getUserId(), currentUser.getUserName(), currentUser.getPassword(), currentUser.getFirstName(), currentUser.getLastName(), currentUser.getAddress(), currentUser.getContactNumber(), currentUser.getGender(), currentUser.getUserRole().getRoleType(), currentUser.getCompanyCode()));
        }
        return userDTOList;
    }

    @Override
    @Transactional
    public void saveUser(UserDTO userDTO) {
        UserRole userRole = new UserRole(ROLE_TYPE);
        userRepository.save(new User(userDTO.getUserId(), userDTO.getUserName(), userDTO.getPassword(), userDTO.getFirstName(), userDTO.getLastName(), userDTO.getAddress(), userDTO.getContactNumber(), userDTO.getGender(), userRole, COMPANY_CODE));

    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userRepository.delete(userRepository.getOne(id));
    }

    @Override
    public UserDTO findUserById(int id) {
        User currentUser = userRepository.findById(id).get();
        return new UserDTO(currentUser.getUserId(), currentUser.getUserName(), currentUser.getPassword(), currentUser.getFirstName(), currentUser.getLastName(), currentUser.getAddress(), currentUser.getContactNumber(), currentUser.getGender(), currentUser.getUserRole().getRoleType(), currentUser.getCompanyCode());

    }

    @Override
    public UserDTO findUserByUserName(String userName) {
        System.out.println("this is user name" + userName);
        User currentUser = userRepository.findByUserName(userName).get();
        return new UserDTO(currentUser.getUserId(), currentUser.getUserName(), currentUser.getPassword(), currentUser.getFirstName(), currentUser.getLastName(), currentUser.getAddress(), currentUser.getContactNumber(), currentUser.getGender(), currentUser.getUserRole().getRoleType(), currentUser.getCompanyCode());

    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("came");
        Optional<User> user = userRepository.findByUserName(userName);
        System.out.println("user" + user);

       user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));
        return user.map(CompanyUserDetailsDTO::new).get();

    }
}
