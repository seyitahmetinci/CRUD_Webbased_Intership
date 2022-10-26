package com.seyitahmetinci.springsecurity.controller;


import com.seyitahmetinci.springsecurity.Repository.RoleRepository;
import com.seyitahmetinci.springsecurity.Repository.UserRepository;
import com.seyitahmetinci.springsecurity.entitites.Roles;
import com.seyitahmetinci.springsecurity.entitites.User;
import com.seyitahmetinci.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final UserService userService;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "users";
    }


    @RequestMapping(value = "/rolac", method = RequestMethod.GET)
    @ResponseBody
    public String roleac() {


        Roles role = new Roles();

        role.setName("admin");

        roleRepository.save(role);


        return "Hesap açıldı. Devam";
    }


    @RequestMapping(value = "/hesapac", method = RequestMethod.GET)
    @ResponseBody
    public String hesapac() {


        User user = new User();

        user.setName("osman");
        user.setPassword(passwordEncoder.encode("123"));

        userRepository.save(user);

        return "Losikik.";
    }


    @RequestMapping("/selam")
    public String getSelam() {
        return "selam";
    }

    @RequestMapping("/admin")
    public String getAdmineSelam() {
        return "Admin Osmana selam";
    }


    @RequestMapping("/403")
    public String error403() {
        return "403";
    }


}

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String getWelcoming() {
//        return "usermanage";
//    }

