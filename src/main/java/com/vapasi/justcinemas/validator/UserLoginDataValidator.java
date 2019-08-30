package com.vapasi.justcinemas.validator;

import com.vapasi.justcinemas.interfaces.Validator;
import com.vapasi.justcinemas.model.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

public class UserLoginDataValidator implements Validator {
    private User userDataFromView;
    private User userDataFromDB;
    private String errorMessage;

    public UserLoginDataValidator(User user, User userDataFromDB) {
        this.userDataFromView = user;
        this.userDataFromDB = userDataFromDB;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public void validate() {
        if (userDataFromView.getPassword() == null || userDataFromView.getPassword().trim().length() < 8) {
            errorMessage = "Password must be atleast 8 characters long";
        } else {
            if (userDataFromDB == null) {
                errorMessage = "Email does not exist";
            } else if (!(userDataFromView.getPassword().equals(userDataFromDB.getPassword()))) {
                errorMessage = "Email and password do not match";
            }
        }

    }
}
