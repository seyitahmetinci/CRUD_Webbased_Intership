package com.seyitahmetinci.springsecurity.Repository;

import com.seyitahmetinci.springsecurity.entitites.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {

    List<Roles> findByName(String name);


}
