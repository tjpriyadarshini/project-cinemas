package com.vapasi.justcinemas.controller;

import com.vapasi.justcinemas.model.view.NewUser;
import com.vapasi.justcinemas.service.UserCreationService;
import com.vapasi.justcinemas.service.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    @Autowired
    UserCreationService userCreationService;

    @GetMapping("/signup")
    public String getSignup(Model model) {
        NewUser newUser = new NewUser();
        model.addAttribute("newUser", newUser);
        return "signup";
    }

    @PostMapping("/signup")
    public String loginValidation(@ModelAttribute NewUser newUser, Model model)
    {
        UserValidation userValidation = userCreationService.validateSignupData(newUser);
        if (userValidation.isValidationSuccessful())
        {
            userCreationService.createNewUser(newUser);
        }
        model.addAttribute("userValidation", userValidation);
        return "signup";
    }
}
