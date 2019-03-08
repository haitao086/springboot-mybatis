package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by molds086 on 2019/2/13.
 */
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String loginUI() {
        return "login";
    }

    @RequestMapping("login")
    public String login() {
        return "redirect:/list";
    }

    @RequestMapping("list")
    public String getUserList(Model model) {
        List<User> users = userService.findAllUser();
        model.addAttribute("users", users);
        return "list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "add";
    }
    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model, Integer id) {
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/list";
    }

    @RequestMapping("/delete")
    public String delete(Integer id) {
        userService.delete(id);
        return "redirect:/list";
    }

}
