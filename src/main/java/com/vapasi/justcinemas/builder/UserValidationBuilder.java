package com.vapasi.justcinemas.builder;

import com.vapasi.justcinemas.model.domain.User;
import com.vapasi.justcinemas.service.UserValidation;

public class UserValidationBuilder {
    public UserValidation build(User userDataFromDB, String errorMessage)
    {
        UserValidation userValidation = null;
        if (errorMessage == null || errorMessage.isEmpty())
            userValidation = new UserValidation(true,null,userDataFromDB);
        else
            userValidation = new UserValidation(false,errorMessage,userDataFromDB);
        return userValidation;
    }
}
