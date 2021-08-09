package com.hasindu.userdetailsmanagamentsystem.controller;

import com.hasindu.userdetailsmanagamentsystem.dto.LoginHistoryDTO;
import com.hasindu.userdetailsmanagamentsystem.dto.LoginResponseDTO;
import com.hasindu.userdetailsmanagamentsystem.dto.UserDTO;
import com.hasindu.userdetailsmanagamentsystem.service.LoginHistoryService;
import com.hasindu.userdetailsmanagamentsystem.service.UserService;
import com.hasindu.userdetailsmanagamentsystem.util.pdf.PdfExporter;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *Login History Controller
 */
@Controller
@RequestMapping("/login-history")
public class LoginHistoryController {
    @Autowired
    private LoginHistoryService loginHistoryService;
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String showLoginHistoryPage(Model model) {
        System.out.println(model);
        model.addAttribute("loginHistories", loginHistoryService.getAllLoginHistories());

        return "loginHistory";
    }

    @GetMapping("/add")
    public ResponseEntity showLoginHistoryPage(Authentication authentication, HttpServletRequest request) {
        Date currentDate = java.util.Calendar.getInstance().getTime();
        String ipAddress = request.getRemoteAddr();
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        String browserName = userAgent.getBrowser().getName();
        String deviceType = userAgent.getOperatingSystem().getDeviceType().getName();

        try {

            UserDTO userDTO = new UserDTO();
            System.out.println("************" + authentication.getName());
            userDTO.setUserName(authentication.getName());
            loginHistoryService.addLoginHistory(new LoginHistoryDTO(currentDate, currentDate, ipAddress, browserName, deviceType, userDTO));


        } catch (Exception e) {
            LoginResponseDTO loginResponseDTO = new LoginResponseDTO("Failed");
            return new ResponseEntity<LoginResponseDTO>(loginResponseDTO, HttpStatus.EXPECTATION_FAILED);
        }

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO("Success");

        return new ResponseEntity<>(loginResponseDTO, HttpStatus.OK);

    }
    @GetMapping("/generate-report")
    public void generateLoginHistoryReport(HttpServletResponse response) throws IOException {
        System.out.println("came111");
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment;filename=login-histories_"+currentDateTime+".pdf";
        response.setHeader(headerKey,headerValue);
        List<LoginHistoryDTO> loginHistories = loginHistoryService.getAllLoginHistories();


        PdfExporter pdfExporter = new PdfExporter(loginHistories);
        pdfExporter.export(response);
    }


}
