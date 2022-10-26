package com.seyitahmetinci.springsecurity.Repository;

import com.seyitahmetinci.springsecurity.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    User findByName(String name);


}
// select * from user where name = :name;