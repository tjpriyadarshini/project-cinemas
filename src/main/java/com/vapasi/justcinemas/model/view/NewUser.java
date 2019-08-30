package com.vapasi.justcinemas.model.view;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
public class NewUser {
    private String userName;
    private String email;
    private String password;
    private String confirmPassword;

}
