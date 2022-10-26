package com.seyitahmetinci.springsecurity.dto;

import com.seyitahmetinci.springsecurity.Repository.RoleRepository;
import com.seyitahmetinci.springsecurity.Repository.UserRepository;
import com.seyitahmetinci.springsecurity.entitites.Roles;
import com.seyitahmetinci.springsecurity.entitites.User;
import com.seyitahmetinci.springsecurity.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;
@Getter
@RequiredArgsConstructor
@Setter
public class UserCreationDto {

    private UserService userService;

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    String rolename;

//    void getRoleName(User user){
//        String userrole;
//        userrole = userService.getUserRoles(user); //kullanıcının verilen rölünü alıyor ve userrole kayıt ediyor. - example: [ADMIN]
//        roles = roleRepository.findByName(String.valueOf(user)); //userrole içindeki rolü Roles'ün içinde aratıp buluyor. example: userrole[ADMIN] =? Roles[ADMIN , USER] ---->  userrole[ADMIN] == Roles[ADMIN]
//        user.setRoles(roles); // user.role = "ADMIN"
//
//
//
//
//    }
//
//    void DtoRoleName(String rolename, User user){
//
//        List<Roles> theRole = roleRepository.findByName(rolename);
//        user.setRoles(theRole);
//
//    }
}
