package com.hasindu.userdetailsmanagamentsystem.service;

import com.hasindu.userdetailsmanagamentsystem.Constants;
import com.hasindu.userdetailsmanagamentsystem.dao.UserRepository;
import com.hasindu.userdetailsmanagamentsystem.dto.UserDTO;
import com.hasindu.userdetailsmanagamentsystem.entity.LoginHistory;
import com.hasindu.userdetailsmanagamentsystem.entity.User;
import com.hasindu.userdetailsmanagamentsystem.entity.UserRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService = new UserServiceImpl();
    @Captor
    private ArgumentCaptor<User> postArgumentCaptor;



    @Test
    @DisplayName("Test Should pass when the length of the users list is 1")
    public void getAllUsersTest(){
        UserRole mockUserRole = new UserRole(Constants.ROLE_TYPE);
        mockUserRole.setRoleId(2);
        User mockUser =new User(1, "Hasindu1", "Hasindu1", "Hasindu", "Dahnayake", "Maharagama", "0718230918", "Male", mockUserRole, "epic123");

        System.out.println(userRepository);
        when(userRepository.findAll()).thenReturn(Stream.of(mockUser).collect(Collectors.toList()));

        Assertions.assertEquals(1, userService.getAllUsers().size());
    }
    @Test
    @DisplayName("Test should pass when the User get saved with correct args")
    public void saveUserTest(){
        UserDTO mockUserDTO =new UserDTO(1, "Hasindu1", "Hasindu1", "Hasindu", "Dahnayake", "Maharagama", "0718230918", "Male", Constants.COMPANY_CODE, "epic123");
        userService.saveUser(mockUserDTO);

        Mockito.verify(userRepository, Mockito.times(1)).save(postArgumentCaptor.capture());//Verifying that loginHistory service invoked loginHistoryDAOImpl save method only once successfully
        /*
         *Checking are the args get passed to the loginHistoryDAOImpl as expected
         */
        org.assertj.core.api.Assertions.assertThat(postArgumentCaptor.getValue().getUserId()).isEqualTo(1);
        org.assertj.core.api.Assertions.assertThat(postArgumentCaptor.getValue().getUserName()).isEqualTo("Hasindu1");
        org.assertj.core.api.Assertions.assertThat(postArgumentCaptor.getValue().getUserRole().getRoleType()).isEqualTo(Constants.ROLE_TYPE);


    }
    @Test
    @DisplayName("Test should pass when the expected user found")
    public void  findUserByIdTest(){
        UserRole mockUserRole = new UserRole(Constants.ROLE_TYPE);
        mockUserRole.setRoleId(2);
        User mockUser =new User(1, "Hasindu1", "Hasindu1", "Hasindu", "Dahnayake", "Maharagama", "0718230918", "Male", mockUserRole, "epic123");

        when(userRepository.findById(1)).thenReturn(Optional.of(mockUser));

        Assertions.assertEquals(1, userService.findUserById(1).getUserId());
    }
    @Test
    @DisplayName("Test should pass when the user deleted")
    public void deleteUser(){
        int userId = 1;
        UserRole mockUserRole = new UserRole(Constants.ROLE_TYPE);
        mockUserRole.setRoleId(2);
        User mockUser =new User(1, "Hasindu1", "Hasindu1", "Hasindu", "Dahnayake", "Maharagama", "0718230918", "Male", mockUserRole, "epic123");
        when(userRepository.getOne(1)).thenReturn(mockUser);
        userService.deleteUser(userId);
        Mockito.verify(userRepository, Mockito.times(1)).delete(ArgumentMatchers.any(User.class));//Verifying that UserServiceImpl UserRepository save method only once successfully


    }
    @Test
    @DisplayName("Test should pass when the user deleted")
    public void findUserByUserNameTest(){
        String userName ="Hasindu1";
        UserRole mockUserRole = new UserRole(Constants.ROLE_TYPE);
        mockUserRole.setRoleId(2);
        User mockUser =new User(1, "Hasindu1", "Hasindu1", "Hasindu", "Dahnayake", "Maharagama", "0718230918", "Male", mockUserRole, "epic123");

        when(userRepository.findByUserName(userName)).thenReturn(Optional.of(mockUser));
        Assertions.assertEquals(userName, userService.findUserByUserName(userName).getUserName());


    }
    @Test
    @DisplayName("Test should pass when the expected user found")
    public void loadUserByUserNameTest(){
        String userName ="Hasindu1";
        UserRole mockUserRole = new UserRole(Constants.ROLE_TYPE);
        mockUserRole.setRoleId(2);
        User mockUser =new User(1, "Hasindu1", "Hasindu1", "Hasindu", "Dahnayake", "Maharagama", "0718230918", "Male", mockUserRole, "epic123");

        when(userRepository.findByUserName(userName)).thenReturn(Optional.of(mockUser));
        Assertions.assertEquals(userName, userService.loadUserByUsername(userName).getUsername());


    }

//    @Test
//    @DisplayName("Test should pass when the UsernameNotFoundException thrown")
//    void loadUserByUserNameTestNegative() {
//
//        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
//            UserRole mockUserRole = new UserRole(Constants.ROLE_TYPE);
//            mockUserRole.setRoleId(2);
//            User mockUser =new User(1, "Hasindu1", "Hasindu1", "Hasindu", "Dahnayake", "Maharagama", "0718230918", "Male", mockUserRole, "epic123");
//            String userName = "Pasindu12";
//            when(userRepository.findByUserName(userName)).thenReturn(Optional.of(null));
//
//           userService.loadUserByUsername(userName);
//        });
//
//    }
}
