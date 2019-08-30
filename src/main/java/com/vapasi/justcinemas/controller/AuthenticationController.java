package com.vapasi.justcinemas.controller;

import com.vapasi.justcinemas.model.domain.User;
import com.vapasi.justcinemas.service.UserValidation;
import com.vapasi.justcinemas.service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AuthenticationController {
    @Autowired
    UserValidationService service;

    @GetMapping("/login")
    public String getLogin(Model model)
    {
        User user = new User();
        model.addAttribute("user",user);
        return "login";
    }

    @PostMapping("/login")
    public String loginValidation(@ModelAttribute User user, Model model, HttpSession session)
    {
        UserValidation userValidation  = service.validateUser(user);

        if (userValidation.isValidationSuccessful()){
            session.setAttribute("user",userValidation.getUser());
            return "redirect:/";
        }

        else
        {
            model.addAttribute("userValidation", userValidation);
            return "login";
        }
    }
    @GetMapping("/logoff")
    public String logoff(HttpSession session, Model model)
    {
        if (session != null)
        {
            session.removeAttribute("user");
        }
        return "redirect:/";
    }
}
