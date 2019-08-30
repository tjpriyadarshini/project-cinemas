package com.vapasi.justcinemas.service;
import com.vapasi.justcinemas.builder.UserValidationBuilder;
import com.vapasi.justcinemas.model.domain.User;
import com.vapasi.justcinemas.repository.UserRepository;
import com.vapasi.justcinemas.validator.UserLoginDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserValidationService {
    @Autowired
    UserRepository userRepository;

    public UserValidation validateUser(User user) {
        User userDataFromDB = userRepository.findByEmail(user.getEmail());
        UserLoginDataValidator userLoginDataValidator = new UserLoginDataValidator(user,userDataFromDB);
        userLoginDataValidator.validate();
        UserValidation userValidation = new UserValidationBuilder().build(userDataFromDB,userLoginDataValidator.getErrorMessage());
        return userValidation;
    }
}