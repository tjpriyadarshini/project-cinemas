package com.vapasi.justcinemas.service;

import com.vapasi.justcinemas.builder.UserValidationBuilder;
import com.vapasi.justcinemas.model.view.NewUser;
import com.vapasi.justcinemas.model.domain.User;
import com.vapasi.justcinemas.repository.UserRepository;
import com.vapasi.justcinemas.validator.UserSignUpDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCreationService {

    @Autowired
    UserRepository userRepository;

    public UserValidation validateSignupData(NewUser newUser){
        UserSignUpDataValidator userSignUpDataValidator = new UserSignUpDataValidator(newUser);
        userSignUpDataValidator.validate();
        UserValidation userValidation = new UserValidationBuilder().build(null,userSignUpDataValidator.getErrorMessage());
        return userValidation;
    }

    public void createNewUser(NewUser newUser) {
        User user = new User();
        user.setEmail(newUser.getEmail());
        user.setUserName(newUser.getUserName());
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }
}
