package com.beeveloper.auth.users;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@Data
public class User {

    @Id @GeneratedValue
    private Long id;

    private String username;

    private String password;

}
