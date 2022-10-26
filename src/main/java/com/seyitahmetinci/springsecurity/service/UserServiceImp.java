package com.seyitahmetinci.springsecurity.service;

import com.seyitahmetinci.springsecurity.Repository.RoleRepository;
import com.seyitahmetinci.springsecurity.Repository.UserRepository;
import com.seyitahmetinci.springsecurity.dto.UserCreationDto;
import com.seyitahmetinci.springsecurity.entitites.Roles;
import com.seyitahmetinci.springsecurity.entitites.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {

//        List<Roles> roleUser = roleRepository.findByName("USER");
//        user.setRoles(roleUser);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        this.userRepository.save(user);

    }

    @Override
    public User getUserById(long id) {
        return this.userRepository.getReferenceById(id);
    }

    @Override
    public void deleteUserById(long id) {
        this.userRepository.deleteById(id);

    }

    @Override
    public User createUser(User user) {


//        kullanıcı kayıt
        List<Roles> roleUser = roleRepository.findByName("User");
        user.setRoles((List<Roles>) roleUser);
        encodePassword(user);
        return this.userRepository.save(user);
    }

    @Override
    public List<Roles> listRoles() {
        return roleRepository.findAll();
    }


    @Override
    public void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

//    @Override
//    public void getRoleName(User user) {
//        Set<Roles> userrole; //role cinsinden boş liste - example: [ BOŞ ]
//        userrole = getUserRoles(user); //kullanıcının verilen rölünü alıyor ve userrole kayıt ediyor. - example: [ADMIN]
//        roleRepository.findByName(String.valueOf(userrole)); //userrole içindeki rolü Roles'ün içinde aratıp buluyor. example: userrole[ADMIN] =? Roles[ADMIN , USER] ---->  userrole[ADMIN] == Roles[ADMIN]
//        user.setRoles(roles); // user.role = "ADMIN"
//
//    }


    public void assignUserRole(Integer userId, Integer roleId) {
        User user = userRepository.findById(Long.valueOf(userId)).orElse(null);
        Roles role = roleRepository.findById((int) Math.toIntExact(Long.valueOf(roleId))).orElse(null);
//        Roles role = roleRepository.findById(Math.toIntExact(Long.valueOf(roleId))).orElse(null);
        Set<Roles> userRoles = (Set<Roles>) user.getRoles();
        userRoles.add(role);
        user.setRoles((List<Roles>) userRoles);
        userRepository.save(user);

    }


    public Set<Roles> getUserRoles(User user){

        return (Set<Roles>) user.getRoles();
    }


    @Override
    public void DtoRoleName(UserCreationDto userCreationDto, User user){
        String rolename = userCreationDto.getRolename();
        List<Roles> theRole = roleRepository.findByName(rolename);
        user.setRoles((List<Roles>) theRole);

    }




}
