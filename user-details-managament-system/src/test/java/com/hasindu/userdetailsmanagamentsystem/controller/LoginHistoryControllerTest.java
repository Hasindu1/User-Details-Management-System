package com.hasindu.userdetailsmanagamentsystem.controller;

import com.hasindu.userdetailsmanagamentsystem.dto.LoginHistoryDTO;
import com.hasindu.userdetailsmanagamentsystem.dto.UserDTO;
import com.hasindu.userdetailsmanagamentsystem.service.LoginHistoryService;
import com.hasindu.userdetailsmanagamentsystem.service.UserService;
import eu.bitwalker.useragentutils.UserAgent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = LoginHistoryController.class)
@AutoConfigureMockMvc(addFilters = false)

/**
 * Test class for LoginHistory Controller
 */
public class LoginHistoryControllerTest {

    @Autowired
    private MockMvc mockMvc;
   @MockBean
   private LoginHistoryService loginHistoryService;
    @MockBean
   private  UserService userService;

    @MockBean
    private  HttpServletRequest mockedRequest;

    @MockBean
    private Authentication mockedAuthentication;

    @Test
    @DisplayName("should be forward to loginHistory.jsp")
    public void showLoginHistoryPageTest() throws Exception {

        LoginHistoryDTO mockLoginHistoryDTO1 = new LoginHistoryDTO(new Date(), new Date(), "192:68:78:90", "Chrome", "Mobile", new UserDTO());
        LoginHistoryDTO mockLoginHistoryDTO2 = new LoginHistoryDTO(new Date(), new Date(), "192:68:77:99", "Firefox", "Mobile", new UserDTO());

        when(loginHistoryService.getAllLoginHistories()).thenReturn(Stream.of(mockLoginHistoryDTO1,mockLoginHistoryDTO2).collect(Collectors.toList()));


        this.mockMvc.perform(get("/login-history/all")).andDo(print()).andExpect(status().isOk())
                        .andExpect(forwardedUrl("/WEB-INF/jsp/loginHistory.jsp"));

    }
    @Test
    @DisplayName("should return the response entity")
    public void  addLoginHistoryTest() throws Exception {
        HttpServletRequest mockedRequest = Mockito.mock(HttpServletRequest.class);
        Authentication mockedAuthentication= Mockito.mock(Authentication.class);
        UserAgent mockedUserAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0");

        String mockedIpAddress = "192.168.20.82";
        Mockito.doReturn(mockedIpAddress).when( mockedRequest.getRemoteAddr());
        Mockito.doReturn("Hasindu").when(mockedAuthentication.getName());

        this.mockMvc.perform(get("/login-history/add")).andDo(print()).andExpect(status().isOk())
                ;


    }
}
