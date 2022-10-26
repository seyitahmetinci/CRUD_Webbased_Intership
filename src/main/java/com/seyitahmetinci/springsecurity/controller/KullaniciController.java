package com.seyitahmetinci.springsecurity.controller;

import com.seyitahmetinci.springsecurity.Repository.RoleRepository;
import com.seyitahmetinci.springsecurity.Repository.UserRepository;
import com.seyitahmetinci.springsecurity.entitites.Roles;
import com.seyitahmetinci.springsecurity.entitites.User;
import com.seyitahmetinci.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class KullaniciController {

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String Login(@RequestParam(required = false) Integer error, Model model) {

        List<Roles> listRoles = roleRepository.findAll();
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("user", new User());


        if (error != null) {
            if (error == 1) {
                model.addAttribute("error", "User name already taken!");
            } else if (error == 2) {
                model.addAttribute("error", "isim kısa hatası");

            }
        }
        return "login";
    }

    @GetMapping("/signup")
    public String getFoos(@RequestParam(required = false) Integer error, Model model) {

        List<Roles> listRoles = roleRepository.findAll();
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("user", new User());


        if (error != null) {
            if (error == 1) {
                model.addAttribute("error", "User name already taken!");
            } else if (error == 2) {
                model.addAttribute("error", "isim kısa hatası");

            }
        }
        return "add-user";
    }


    @PostMapping("/adduser")
    public String addUser(User user, BindingResult bindingResult, Model model) {


        String username = user.getName();
        User kullanici = userRepository.findByName(username);

        if (kullanici != null) {
            return "redirect:/signup?error=1";

        } else {
            userService.saveUser(user);

            model.addAttribute("title", "save ");
            model.addAttribute("message", "kullanıcı daha önceden kayıtlı1 ");
        }

        return "usersave-success";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).get();

        model.addAttribute("user", user);

        List<Roles> listRoles = roleRepository.findAll();
        model.addAttribute("listRoles", listRoles);
        return "add-user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        User user = userRepository.findById(id).get();

//        userRepository.delete(user); // Kullanıcıyı rolü ile birlikte siler. Bunun yerine deletbyID kullanabilirsin
        userRepository.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping("/to-be-havai")
    public RedirectView localRedirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("https://www.youtube.com/shorts/VBZHmqPPLuw");
        return redirectView;
    }

    @GetMapping("/deneme")
    public String deneme(@RequestParam(required = false) Integer error, Model model) {

        List<Roles> listRoles = roleRepository.findAll();
        model.addAttribute("listRoles", listRoles);
        model.addAttribute("user", new User());


        if (error != null) {
            if (error == 1) {
                model.addAttribute("error", "User name already taken!");
            } else if (error == 2) {
                model.addAttribute("error", "isim kısa hatası");

            }
        }
        return "deneme";
    }

    @RequestMapping("/secured")
    public void secureResource(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("accessing secured resource");
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


}


//    @GetMapping("/signup")
//    public String showSignUpForm( Model model) {
//        List<Roles> listRoles = roleRepository.findAll();
//        model.addAttribute("listRoles", listRoles);
//        model.addAttribute("user",new User());
//
//
//        return "add-user";
//    }
//
//    @GetMapping("/edit/{id}")
////    public  String editUser (@PathVariable("id") int id,Model model){
////        User user = userService.getUserById(id);
////        model.addAttribute("user", user);
////        List<Roles> listRoles = roleRepository.findAll();
////        model.addAttribute("listRoles", listRoles);
////        return "edit-user";
////    }