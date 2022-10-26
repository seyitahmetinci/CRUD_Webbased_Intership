package com.seyitahmetinci.springsecurity.entitites;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_id")
    private Long user_id;
    @Column(name = "role_id")
    private Long role_id;

}
