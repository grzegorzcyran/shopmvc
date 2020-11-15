package com.grcy.shopmvc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.grcy.shopmvc.model.UserDao;
import com.grcy.shopmvc.model.UserDto;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/add")
    public ModelAndView addUser(Model model) {
        return new ModelAndView("userform", "userToInsert", new UserDto());
    }

    @PostMapping("/adduser")
    public String addUser(@ModelAttribute UserDto userDto) {
        userDao.saveUser(userDto);
        userDto.setCreationDate(new Date());
        return "usersaveresult";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<UserDto> allUsers = userDao.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "userlist";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@ModelAttribute("user") UserDto userDto) {
        userDao.deleteUser(userDto);
        return "userdeleteresult";
    }

    @GetMapping("/modifyUser/{userId}")
    public String modifyUser(@PathVariable("userId") int userId, Model model) {
        UserDto userDto = userDao.getAllUsers().get(userId);
        model.addAttribute("user", userDto);
        return "userupdateform";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute UserDto userDto) {
        userDao.updateUser(userDto);
        return "index";
    }
}
