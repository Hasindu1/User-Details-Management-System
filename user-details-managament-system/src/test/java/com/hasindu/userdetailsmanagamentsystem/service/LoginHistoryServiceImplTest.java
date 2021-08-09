package com.hasindu.userdetailsmanagamentsystem.service;

import com.hasindu.userdetailsmanagamentsystem.Constants;
import com.hasindu.userdetailsmanagamentsystem.dao.LoginHistoryRepository;
import com.hasindu.userdetailsmanagamentsystem.dao.UserRepository;
import com.hasindu.userdetailsmanagamentsystem.dto.LoginHistoryDTO;
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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LoginHistoryServiceImplTest {
    @Mock
    private LoginHistoryRepository loginHistoryRepository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks // auto inject loginHistoryRepository and userRepository
    private LoginHistoryService loginHistoryService = new LoginHistoryServiceImpl();

    @Captor
    private ArgumentCaptor<LoginHistory> postArgumentCaptor;


    @Test
    @DisplayName("Test Should pass when the length of the loginHistory list is 2")
    public void getAllLoginHistoriesTest() {

        when(loginHistoryRepository.findAll()).thenReturn(Stream.of(new LoginHistory(new Date(), new Date(), "192:68:78:90", "Chrome", "Mobile", new User()), new LoginHistory(new Date(), new Date(), "192:60:76:99", "Firefox", "Mobile", new User())).collect(Collectors.toList()));
        Assertions.assertEquals(2, loginHistoryService.getAllLoginHistories().size());

    }

    @Test
    @DisplayName("Test should pass when the length is 2")
    public void findUserHistoriesByUserNameTest() throws ParseException {

        String userName = "Hasindu1";
        String mockLoginHistory2LoggedInDateStr = "January 2, 2020";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        Date mockLoginHistory2LoggedInDate = format.parse(mockLoginHistory2LoggedInDateStr);

        LoginHistory mockLoginHistory1 = new LoginHistory(new Date(), new Date(), "192:68:78:90", "Chrome", "Mobile", new User("Hasindu1", "Hasindu1", "Hasindu", "Dahnayake", "Maharagama", "0718230918", "Male", "epic123"));
        LoginHistory mockLoginHistory2 = new LoginHistory(mockLoginHistory2LoggedInDate, mockLoginHistory2LoggedInDate, "192:68:78:90", "Chrome", "Mobile", new User("Hasindu1", "Hasindu1", "Hasindu", "Dahnayake", "Maharagama", "0718230918", "Male", "epic123"));

        when(loginHistoryRepository.findUserHistoriesByUserName(userName)).thenReturn(Stream.of(mockLoginHistory1, mockLoginHistory2).collect(Collectors.toList()));


        Assertions.assertEquals(2, loginHistoryService.findUserHistoriesByUserName(userName).size());
    }

    @Test
    @DisplayName("Test should pass when the LoginHistory get saved with correct args")
    public void addLoginHistoryTest() {
        LoginHistoryDTO mockLoginHistoryDTO = new LoginHistoryDTO(new Date(), new Date(), "192:68:78:90", "Chrome", "Mobile", new UserDTO(1, "Hasindu1", "Hasindu1", "Hasindu", "Dahnayake", "Maharagama", "0718230918", "Male", Constants.ROLE_TYPE, "epic123"));
        LoginHistory mockLoginHistory = new LoginHistory(new Date(), new Date(), "192:68:78:90", "Chrome", "Mobile", new User("Hasindu1", "Hasindu1", "Hasindu", "Dahnayake", "Maharagama", "0718230918", "Male", "epic123"));
        UserRole mockUserRole = new UserRole(Constants.ROLE_TYPE);
        mockUserRole.setRoleId(2);

        when(userRepository.findByUserName("Hasindu1")).thenReturn(Optional.of(new User(1, "Hasindu1", "Hasindu1", "Hasindu", "Dahnayake", "Maharagama", "0718230918", "Male", mockUserRole, "epic123")));

        loginHistoryService.addLoginHistory(mockLoginHistoryDTO);

        //Mockito.verify(loginHistoryRepository, Mockito.times(1)).save( ArgumentMatchers.any(LoginHistory.class));

        Mockito.verify(loginHistoryRepository, Mockito.times(1)).save(postArgumentCaptor.capture());//Verifying that loginHistory service invoked loginHistoryDAOImpl save method only once successfully
        /*
         *Checking are the args get passed to the loginHistoryDAOImpl as expected
         */
        org.assertj.core.api.Assertions.assertThat(postArgumentCaptor.getValue().getRecordId()).isEqualTo(0);
        org.assertj.core.api.Assertions.assertThat(postArgumentCaptor.getValue().getUser().getUserName()).isEqualTo("Hasindu1");
        org.assertj.core.api.Assertions.assertThat(postArgumentCaptor.getValue().getUser().getUserRole().getRoleType()).isEqualTo(Constants.ROLE_TYPE);


    }



}
