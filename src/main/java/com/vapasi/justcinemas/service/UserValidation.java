package com.vapasi.justcinemas.service;

import com.vapasi.justcinemas.model.domain.User;
import lombok.Getter;

@Getter
public class UserValidation {
    private boolean validationSuccessful;
    private String errorMessage;
    private User user;
    public UserValidation(boolean validationSuccessful, String errorMessage, User user)
    {
        this.validationSuccessful = validationSuccessful;
        this.errorMessage = errorMessage;
        this.user = user;
    }

    public String getUserName() {
        return user.getUserName();
    }
}
