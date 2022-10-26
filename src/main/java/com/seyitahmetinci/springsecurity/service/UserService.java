package com.seyitahmetinci.springsecurity.service;

import com.seyitahmetinci.springsecurity.dto.UserCreationDto;
import com.seyitahmetinci.springsecurity.entitites.Roles;
import com.seyitahmetinci.springsecurity.entitites.User;

import java.util.List;
import java.util.Set;

public interface UserService {

        List<User> getAllUsers();
        void saveUser(User user);
        User getUserById(long id);
        void deleteUserById(long id);

        void encodePassword(User user);

//        void getRoleName(User user);

        User createUser(User user);

        public List<Roles> listRoles();

        void assignUserRole(Integer userId, Integer roleId);

        public Set<Roles> getUserRoles(User user);

        void DtoRoleName(UserCreationDto userCreationDto, User user);



    }


