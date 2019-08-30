package com.vapasi.justcinemas.validator;

import com.vapasi.justcinemas.interfaces.Validator;
import com.vapasi.justcinemas.model.view.NewUser;

public class UserSignUpDataValidator implements Validator {
    NewUser newUser;
    private String errorMessage;

    public UserSignUpDataValidator(NewUser newUser) {
        this.newUser = newUser;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public void validate() {
        if (checkForEmptyString(newUser.getUserName()))
        {
            errorMessage = "Name field is missing";
        }
        else if (checkForEmptyString(newUser.getEmail()))
        {
            errorMessage = "Email is missing";
        }
        else if (newUser.getPassword() == null || newUser.getPassword().trim().length() < 8) {
            errorMessage = "Password must be atleast 8 characters long";
        }
        else if (!(newUser.getPassword().equals(newUser.getConfirmPassword()))) {
            errorMessage = "Password and Confirm Password do not match";
        }
    }

    private boolean checkForEmptyString(String input) {
        return (input == null || input.isEmpty());
    }
}
