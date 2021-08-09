package com.hasindu.userdetailsmanagamentsystem.controller;

import com.hasindu.userdetailsmanagamentsystem.dto.UserDTO;
import com.hasindu.userdetailsmanagamentsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
/**
 *User Controller
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignUpPage(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "signup";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model, RedirectAttributes redirectAttributes) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "login";
    }

    @GetMapping("/user-management")
    public String showUserManagementPage(Model model, @RequestParam(value = "userName", required = false) String userName, RedirectAttributes redirectAttributes, @RequestParam(value = "response", required = false) String response) {
        List<UserDTO> userDTOList;
        if (userName != null && !userName.equals("empty")) {

            userDTOList = new ArrayList<>();

            try {
                userDTOList.add(userService.findUserByUserName(userName));
                model.addAttribute("users", userDTOList);
                return "userManagement";

            } catch (java.util.NoSuchElementException e) {
                redirectAttributes.addFlashAttribute("message", "UserNameNotExists");
                return "redirect:/user/user-management";
            }

        }
        userDTOList = userService.getAllUsers();

        model.addAttribute("users", userDTOList);
        return "userManagement";
    }

    @GetMapping("/modify-user")
    public String showModifyUserPage(Model model, HttpServletRequest request) {
        UserDTO userDTO;
        if (request.getParameter("id") != null) {
            userDTO = userService.findUserById(Integer.parseInt(request.getParameter("id")));
            model.addAttribute("user", userDTO);
            return "modifyUser";
        }
        userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "modifyUser";

    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("user") UserDTO userDTO, RedirectAttributes redirectAttributes) {
        try {
            userService.saveUser(userDTO);
        } catch (DataIntegrityViolationException ex) {
            redirectAttributes.addFlashAttribute("message", "userNameDuplication");

            return "redirect:/user/login";
        } catch (Exception e) {

            redirectAttributes.addFlashAttribute("message", "error");
            return "redirect:/user/login";
        }
        redirectAttributes.addFlashAttribute("message", "success");
        return "redirect:/user/login";

    }

    @PostMapping("/save-user")
    public String saveOrUpdateUser(@ModelAttribute("customer") UserDTO userDTO) {
        userService.saveUser(userDTO);
        return "redirect:/user/user-management";

    }

    @GetMapping("/delete-user")
    public String deleteUser(HttpServletRequest request) {
        userService.deleteUser(Integer.parseInt(request.getParameter("id")));
        return "redirect:/user/user-management";

    }


}
